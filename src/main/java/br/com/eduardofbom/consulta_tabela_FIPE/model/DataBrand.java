package br.com.eduardofbom.consulta_tabela_FIPE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBrand(@JsonProperty("codigo") String code,
                        @JsonProperty("nome") String description) {
}
