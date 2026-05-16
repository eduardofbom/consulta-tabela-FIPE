package br.com.eduardofbom.consulta_tabela_FIPE.model;

public class Model {

    private Integer code;
    private String description;

    public Model(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
    public Model(DataModel dataModel) {
//        try {
            this.code = Integer.parseInt(dataModel.code());
//        } catch (RuntimeException ex) {
//            System.out.println(ex.getMessage());
//            this.code = 0;
//        }
        this.description = dataModel.description();
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
