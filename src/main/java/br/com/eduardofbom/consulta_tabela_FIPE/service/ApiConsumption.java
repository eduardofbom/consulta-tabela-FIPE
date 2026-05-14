package br.com.eduardofbom.consulta_tabela_FIPE.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumption {

    public String consume(String uriAddress) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriAddress))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

}
