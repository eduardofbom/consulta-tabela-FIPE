package br.com.eduardofbom.consulta_tabela_FIPE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelResponse(@JsonProperty("modelos") List<DataResponse> models) {
}
