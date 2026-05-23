package br.com.eduardofbom.consulta_tabela_FIPE.principal;

import br.com.eduardofbom.consulta_tabela_FIPE.model.*;
import br.com.eduardofbom.consulta_tabela_FIPE.service.ApiConsumption;
import br.com.eduardofbom.consulta_tabela_FIPE.service.DataConversion;
import br.com.eduardofbom.consulta_tabela_FIPE.service.MenuAction;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

public class Principal {

    private final DataConversion converter = new DataConversion();
    private final ApiConsumption apiConsumption = new ApiConsumption();
    private final MenuAction menuAction = new MenuAction();
    private final Scanner scanner = new Scanner(System.in);
    private final String uriAddressBase = "https://parallelum.com.br/fipe/api/v1/";

    public void showMenu() throws IOException, InterruptedException {


        Map<Integer,String> vehicleTypeMap = Map.of(1, "carros", 2, "motos", 3, "caminhoes");

        menuAction.showInitial();
        String userTypeVehicle = scanner.nextLine();

        String typeVehicle;
        if (vehicleTypeMap.get(1).contains(userTypeVehicle.toLowerCase())) typeVehicle = vehicleTypeMap.get(1);
        else if (vehicleTypeMap.get(2).contains(userTypeVehicle.toLowerCase())) typeVehicle = vehicleTypeMap.get(2);
        else if (vehicleTypeMap.get(3).contains(userTypeVehicle.toLowerCase())) typeVehicle = vehicleTypeMap.get(3);
        else {
            System.out.println("Invalid option. Please try again.");
            return;
        }
        String uriAddressUserTypeVehicle = uriAddressBase + typeVehicle + "/marcas/";

        String jsonBrandsResponse = apiConsumption.consume(uriAddressUserTypeVehicle);

        List<DataResponse> dataBrandList = converter.getList(jsonBrandsResponse, DataResponse.class);
        List<Data> brandList = new ArrayList<>();
        for (DataResponse dataBrand : dataBrandList) {
            brandList.add(new Data(dataBrand));
        }
        brandList.stream()
                .sorted(Comparator.comparing(Data::getDescription))
                .forEach(System.out::println);

        System.out.println("\nEnter the brand code:");
        String userBrandCode = URLEncoder.encode(scanner.nextLine().toLowerCase());
        String uriAddressUserBrandCode = uriAddressUserTypeVehicle + userBrandCode + "/modelos/";

        String jsonModelsResponse = apiConsumption.consume(uriAddressUserBrandCode);
        ModelResponse dataModelResponse = converter.getData(jsonModelsResponse, ModelResponse.class);
        List<Data> modelsList = new ArrayList<>();
        for (DataResponse modelResponse : dataModelResponse.models()) {
            modelsList.add(new Data(modelResponse));
        }
        modelsList.stream()
                .sorted(Comparator.comparing(Data::getDescription))
                .forEach(System.out::println);

        System.out.println("\nEnter a portion of the vehicle's name:");
        String userModelName = scanner.nextLine().toLowerCase();
        modelsList.stream()
                .filter(m -> m.getDescription().toLowerCase().contains(userModelName))
                .forEach(System.out::println);

        System.out.println("Enter a model code:");
        String userModelCode = URLEncoder.encode(scanner.nextLine().toLowerCase());

        String uriAddressUserModelCode = uriAddressUserBrandCode + userModelCode + "/anos/";

        String jsonModelsCodeResponse = apiConsumption.consume(uriAddressUserModelCode);

        List<DataResponse> yearResponseList = converter.getList(jsonModelsCodeResponse, DataResponse.class);
        List<Data> yearList = new ArrayList<>();
        for (DataResponse yearResponse : yearResponseList) {
            yearList.add(new Data(yearResponse));
        }
        yearList.stream()
                .map(y -> {
                    String uriAddressCode = uriAddressUserModelCode + y.getCode();
                    try {
                        String jsonVehiclesResponse = apiConsumption.consume(uriAddressCode);
                        VehicleResponse vehicleResponse = converter.getData(jsonVehiclesResponse, VehicleResponse.class);
                        return new Vehicle(vehicleResponse);
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(System.out::println);


    }

}
