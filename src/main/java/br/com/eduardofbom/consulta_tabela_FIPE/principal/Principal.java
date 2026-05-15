package br.com.eduardofbom.consulta_tabela_FIPE.principal;

import br.com.eduardofbom.consulta_tabela_FIPE.model.Brand;
import br.com.eduardofbom.consulta_tabela_FIPE.model.DataBrand;
import br.com.eduardofbom.consulta_tabela_FIPE.service.ApiConsumption;
import br.com.eduardofbom.consulta_tabela_FIPE.service.DataConversion;
import br.com.eduardofbom.consulta_tabela_FIPE.service.MenuAction;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final DataConversion converter = new DataConversion();
    private final ApiConsumption apiConsumption = new ApiConsumption();
    private final MenuAction menuAction = new MenuAction();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() throws IOException, InterruptedException {

        String uriAddressBase = "https://parallelum.com.br/fipe/api/v1/";

        menuAction.showInitial();
        String userTypeVehicle = URLEncoder.encode(scanner.nextLine().toLowerCase());
        String uriAddressUser = uriAddressBase + userTypeVehicle + "/marcas/";

        String jsonBrandResponse = apiConsumption.consume(uriAddressUser);
        System.out.println(jsonBrandResponse);

        List<DataBrand> dataBrandList = converter.getDataList(jsonBrandResponse, DataBrand.class);
        List<Brand> brandList = new ArrayList<>();
        for (DataBrand dataBrand : dataBrandList) {
            brandList.add(new Brand(dataBrand));
        }
        System.out.println(brandList);

    }

}
