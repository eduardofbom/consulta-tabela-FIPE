package br.com.eduardofbom.consulta_tabela_FIPE.model;

public class Year {

    private Integer code;
    private String description;

    public Year(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
    public Year(DataYear dataYear) {
//        try {
        this.code = code;
//        } catch (RuntimeException ex) {
//            System.out.println(ex.getMessage());
//            this.code = 0;
//        }
        this.description = description;
    }

    @Override
    public String toString() {
        return "code=" + code +
                ", description=" + description;
    }
}
