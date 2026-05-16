package br.com.eduardofbom.consulta_tabela_FIPE.model;

public class Year {

    private String code;
    private String description;

    public Year(String code, String description) {
        this.code = code;
        this.description = description;
    }
    public Year(DataYear dataYear) {
//        try {
        this.code = dataYear.code();
//        } catch (RuntimeException ex) {
//            System.out.println(ex.getMessage());
//            this.code = 0;
//        }
        this.description = dataYear.description();
    }

    public String getCode() {
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
