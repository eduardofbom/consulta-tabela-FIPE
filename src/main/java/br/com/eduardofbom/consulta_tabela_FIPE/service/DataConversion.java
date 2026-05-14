package br.com.eduardofbom.consulta_tabela_FIPE.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConversion {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T getData(String json, Class<T> tClass) {
        return mapper.convertValue(json, tClass);
    }

}
