package br.com.eduardofbom.consulta_tabela_FIPE.principal;

import br.com.eduardofbom.consulta_tabela_FIPE.model.*;
import br.com.eduardofbom.consulta_tabela_FIPE.service.ApiConsumption;
import br.com.eduardofbom.consulta_tabela_FIPE.service.DataConversion;
import br.com.eduardofbom.consulta_tabela_FIPE.service.MenuAction;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private final DataConversion converter = new DataConversion();
    private final ApiConsumption apiConsumption = new ApiConsumption();
    private final MenuAction menuAction = new MenuAction();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() throws IOException, InterruptedException {

        String uriAddressBase = "https://parallelum.com.br/fipe/api/v1/";

        menuAction.showInitial();
        String userTypeVehicle = URLEncoder.encode(scanner.nextLine().toLowerCase());
        String uriAddressUserTypeVehicle = uriAddressBase + userTypeVehicle + "/marcas/";

        String jsonBrandsResponse = apiConsumption.consume(uriAddressUserTypeVehicle);

        List<DataBrand> dataBrandList = converter.getDataList(jsonBrandsResponse, DataBrand.class);
        List<Brand> brandList = new ArrayList<>();
        for (DataBrand dataBrand : dataBrandList) {
            brandList.add(new Brand(dataBrand));
        }
        brandList.stream()
                .sorted(Comparator.comparing(Brand::getCode))
                .forEach(System.out::println);

        System.out.println("\nEnter the brand code:");
        String userBrandCode = URLEncoder.encode(scanner.nextLine().toLowerCase());
        String uriAddressUserBrandCode = uriAddressUserTypeVehicle + userBrandCode + "/modelos/";

        String jsonModelsResponse = apiConsumption.consume(uriAddressUserBrandCode);
        DataModelResponse dataModelResponse = converter.getData(jsonModelsResponse, DataModelResponse.class);
        List<Model> modelsList = new ArrayList<>();
        for (DataModel dataModel : dataModelResponse.models()) {
            modelsList.add(new Model(dataModel));
        }
        modelsList.stream()
                .sorted(Comparator.comparing(Model::getCode))
                .forEach(System.out::println);

        System.out.println("\nEnter a portion of the vehicle's name:");
        String userModelName = scanner.nextLine().toLowerCase();
        String userModeNameEncode = URLEncoder.encode(userModelName);
        modelsList.stream()
                .filter(m -> m.getDescription().toLowerCase().contains(userModelName))
                .forEach(System.out::println);

        System.out.println("Enter a model code:");
        String userModelCode = URLEncoder.encode(scanner.nextLine().toLowerCase());

        String uriAddressUserModelCode = uriAddressUserBrandCode + userModelCode + "/anos/";

        String jsonModelsCodeResponse = apiConsumption.consume(uriAddressUserModelCode);

        List<DataYear> dataYearList = converter.getDataList(jsonModelsCodeResponse, DataYear.class);
        List<Year> yearList = new ArrayList<>();
        for (DataYear dataYear : dataYearList) {
            yearList.add(new Year(dataYear));
        }
        yearList.stream()
                .map(y -> {
                    String uriAddressCode = uriAddressUserModelCode + y.getCode();
                    try {
                        String jsonVehiclesResponse = apiConsumption.consume(uriAddressCode);
                        DataVehicle dataVehicle = converter.getData(jsonVehiclesResponse, DataVehicle.class);
                        return new Vehicle(dataVehicle);
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(System.out::println);


    }

}
