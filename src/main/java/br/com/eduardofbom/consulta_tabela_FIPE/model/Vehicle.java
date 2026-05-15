package br.com.eduardofbom.consulta_tabela_FIPE.model;


public class Vehicle {

    private Integer vehicleTypeVeh;
    private String valueVeh;
    private String brandVeh;
    private String modelVeh;
    private Integer yearVeh;
    private String fuelTypeVeh;
    private String codeFipeVeh;

    public Vehicle(Integer vehicleTypeVeh, String valueVeh, String brandVeh, String modelVeh, Integer yearVeh, String fuelTypeVeh, String codeFipeVeh) {
        this.vehicleTypeVeh = vehicleTypeVeh;
        this.valueVeh = valueVeh;
        this.brandVeh = brandVeh;
        this.modelVeh = modelVeh;
        this.yearVeh = yearVeh;
        this.fuelTypeVeh = fuelTypeVeh;
        this.codeFipeVeh = codeFipeVeh;
    }
    public Vehicle(DataVehicle dataVehicle) {
//        try {
            this.vehicleTypeVeh = Integer.parseInt(dataVehicle.vehicleTypeVeh());
//        } catch (RuntimeException ex) {
//            new throws RuntimeException(ex);
//            this.vehicleTypeVeh = 0;
//        }
        this.valueVeh = dataVehicle.valueVeh();
        this.brandVeh = dataVehicle.brandVeh();
        this.modelVeh = dataVehicle.modelVeh();
//        try {
            this.yearVeh = Integer.parseInt(dataVehicle.yearVeh());
//        } catch (RuntimeException ex) {
//            new throws RuntimeException(ex);
//            this.yearVeh = 0;
//        }
        this.fuelTypeVeh = dataVehicle.fuelTypeVeh();
        this.codeFipeVeh = dataVehicle.codeFipeVeh();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleTypeVeh=" + vehicleTypeVeh +
                ", valueVeh='" + valueVeh + '\'' +
                ", brandVeh='" + brandVeh + '\'' +
                ", modelVeh='" + modelVeh + '\'' +
                ", yearVeh=" + yearVeh +
                ", fuelTypeVeh='" + fuelTypeVeh + '\'' +
                ", codeFipeVeh='" + codeFipeVeh + '\'' +
                '}';
    }
}
