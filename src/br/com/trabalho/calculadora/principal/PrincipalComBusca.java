package br.com.trabalho.calculadora.principal;

import br.com.trabalho.calculadora.excecao.ErroDeConversaoDeAnoException;
import br.com.trabalho.calculadora.models.Titulo;
import br.com.trabalho.calculadora.models.TituloOmdb;
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

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulo = new ArrayList<>();

        // pega o nome com letra minuscula para consumir api
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting() //faz com que o json fique mais facil de ler
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca:");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            try {
                String endereco = "http://www.omdbapi.com/?t=" +
                        busca.replace(" ", "+") + "&apikey=9ace215f";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                System.out.println(endereco);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("-----------------");
                System.out.println("Meu titulo convertido: \n" + meuTitulo);
                titulo.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro de Argumento");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
       // aqui to pedindo para ele escrever um arquivo e salvar meus filmes
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulo));
        escrita.close();
        System.out.println("Aprovado" + titulo);
    }
}
