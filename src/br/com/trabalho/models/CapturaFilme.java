package br.com.trabalho.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class CapturaFilme {
    List<Titulo> titulo = new ArrayList<>();
    FileWriter escrita = new FileWriter("filmes.json");
    Scanner leitura = new Scanner(System.in);

    // pega o nome com letra minuscula para consumir api
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting() //faz com que o json fique mais facil de ler
            .create();

    public CapturaFilme() throws IOException {
    }

    public void setBusca() throws IOException, InterruptedException {
        String busca = "";
            while (!busca.equalsIgnoreCase("sair")) {
                System.out.println("Digite um filme para busca:");
                busca = leitura.nextLine();

                if (busca.equalsIgnoreCase("sair")) {
                    break;
                }
                impressao(busca);
            }

    }

    public Titulo endereco(String busca) throws IOException, InterruptedException {
         busca = "http://www.omdbapi.com/?t=" +
                busca.replace(" ", "+") + "&apikey=9ace215f";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busca))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        Titulo meuTitulo = new Titulo(meuTituloOmdb);
        return meuTitulo;
    }

    public void impressao(String busca) throws IOException, InterruptedException {
    if(endereco(busca) != null) {
        titulo.add(endereco(busca));
        System.out.println(endereco(busca).toString());
        escrita.write(gson.toJson(titulo));
    }else{
        Logger.getLogger("Não Foi possivel Adicionar este titulo no momento:");
        setBusca();
    }
    }






}