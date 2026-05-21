package br.com.eduardofbom.consulta_tabela_FIPE.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vehicle {

    private static final Logger log = LoggerFactory.getLogger(Vehicle.class);
    private Integer vehicleTypeVeh;
    private String valueVeh;
    private String brandVeh;
    private String modelVeh;
    private Integer yearVeh;
    private String fuelAbbreviation;
    private String codeFipeVeh;

    public Vehicle(Integer vehicleTypeVeh, String valueVeh, String brandVeh, String modelVeh, Integer yearVeh, String fuelAbbreviation, String codeFipeVeh) {
        this.vehicleTypeVeh = vehicleTypeVeh;
        this.valueVeh = valueVeh;
        this.brandVeh = brandVeh;
        this.modelVeh = modelVeh;
        this.yearVeh = yearVeh;
        this.fuelAbbreviation = fuelAbbreviation;
        this.codeFipeVeh = codeFipeVeh;
    }
    public Vehicle(VehicleResponse vehicleResponse) {
        try {
            this.vehicleTypeVeh = Integer.parseInt(vehicleResponse.vehicleTypeVeh());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            this.vehicleTypeVeh = 0;
        }
        this.valueVeh = vehicleResponse.valueVeh();
        this.brandVeh = vehicleResponse.brandVeh();
        this.modelVeh = vehicleResponse.modelVeh();
        try {
            this.yearVeh = Integer.parseInt(vehicleResponse.yearVeh());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            this.yearVeh = 0;
        }
        this.fuelAbbreviation = vehicleResponse.fuelAbbreviation();
        this.codeFipeVeh = vehicleResponse.codeFipeVeh();
    }

    public Integer getVehicleTypeVeh() {
        return vehicleTypeVeh;
    }

    public String getValueVeh() {
        return valueVeh;
    }

    public String getBrandVeh() {
        return brandVeh;
    }

    public String getModelVeh() {
        return modelVeh;
    }

    public Integer getYearVeh() {
        return yearVeh;
    }

    public String getFuelAbbreviation() {
        return fuelAbbreviation;
    }

    public String getCodeFipeVeh() {
        return codeFipeVeh;
    }

    public String getVehicleTypeVehString() {
        return switch (this.vehicleTypeVeh) {
            case 1 -> "Carro";
            case 2 -> "Moto";
            case 3 -> "Caminhão";
            default -> "N/A";
        };
    }

    @Override
    public String toString() {
        return this.getVehicleTypeVehString() +
                ": " + brandVeh +
                " " + modelVeh +
                " " + yearVeh +
                " " + fuelAbbreviation +
                " | " + valueVeh +
                " (Código fipe = " + codeFipeVeh + ")";
    }
}
