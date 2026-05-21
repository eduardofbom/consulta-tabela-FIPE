package br.com.eduardofbom.consulta_tabela_FIPE.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleResponse(@JsonProperty("TipoVeiculo") String vehicleTypeVeh,
                              @JsonProperty("Valor") String valueVeh,
                              @JsonProperty("Marca") String brandVeh,
                              @JsonProperty("Modelo") String modelVeh,
                              @JsonProperty("AnoModelo") String yearVeh,
                              @JsonProperty("SiglaCombustivel") String fuelAbbreviation,
                              @JsonProperty("CodigoFipe") String codeFipeVeh) {
}