package br.com.eduardofbom.consulta_tabela_FIPE.model;

public class Brand {

    private Integer code;
    private String description;

    public Brand(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
    public Brand(DataBrand dataBrand) {
        try {
            this.code = Integer.parseInt(dataBrand.code());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            this.code = 0;
        }
        this.description = dataBrand.description();
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "code=" + code +
                ", description=" + description;
    }
}
