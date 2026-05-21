package br.com.eduardofbom.consulta_tabela_FIPE.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class DataConversion {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T getData(String json, Class<T> tClass) throws JsonProcessingException {
        return mapper.readValue(json, tClass);
    }

    public <T> List<T> getList(String json, Class<T> tClass) throws JsonProcessingException {
        return mapper.readValue(json,
                mapper.getTypeFactory().constructCollectionType(List.class, tClass));
    }

}
