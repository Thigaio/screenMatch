package br.com.alura.screenMatch.principal;

import br.com.alura.screenMatch.exceptions.ConversaoDeAno;
import br.com.alura.screenMatch.modelo.Titulo;
import br.com.alura.screenMatch.modelo.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        var option = 0;
        while (option != 1) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite o nome do filme que você quer buscar:");
            var busca = scan.nextLine();
            busca = busca.replaceAll(" ","+");
 
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.omdbapi.com/?t="+ busca +"&apikey=d8e3a7a5"))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TituloOMDB meuTitulo = gson.fromJson(json, TituloOMDB.class);

            try {
                Titulo titulo = new Titulo(meuTitulo);
                System.out.println("titulo convertido " + titulo);
                System.out.println(meuTitulo);
            } catch (ConversaoDeAno e) {
                System.out.println("Aconteceu um erro!");
                System.out.println(e.getMessage());
            }

            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(meuTitulo.toString());
            escrita.close();

            System.out.println("Deseja pesquisar outro filme? " +
                    "\n0- Sim" +
                    "\n1- Não");
            option = scan.nextInt();
        }
    }
}