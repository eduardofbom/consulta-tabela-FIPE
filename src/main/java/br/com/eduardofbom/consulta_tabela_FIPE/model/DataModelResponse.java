package br.com.eduardofbom.consulta_tabela_FIPE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataModelResponse(@JsonProperty("modelos") List<DataModel> models,
                                @JsonProperty("anos") List<DataYear> years) {
}
