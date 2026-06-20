package br.com.eduardofbom.consulta_tabela_FIPE.model;

public class Data {

    private String code;
    private String description;

    public Data(String code, String description) {
        this.code = code;
        this.description = description;
    }
    public Data(DataResponse dataResponse) {
        this.code = dataResponse.code();
        this.description = dataResponse.description();
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        // Formatação mais legível para exibição em console/portfólio
        String c = code == null ? "-" : code;
        String d = description == null ? "(sem descrição)" : description;
        return String.format("[%s] %s", c, d);
    }
}
