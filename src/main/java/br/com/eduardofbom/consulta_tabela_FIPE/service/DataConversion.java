package br.com.eduardofbom.consulta_tabela_FIPE.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class DataConversion {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T getData(String json, Class<T> tClass) {
        return mapper.convertValue(json, tClass);
    }

    public <T> List<T> getDataList(String json, Class<T> tClass) throws JsonProcessingException {
        return mapper.readValue(json,
                new TypeReference<List<T>>(){});
    }

}
