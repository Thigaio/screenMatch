package br.com.alura.screenMatch.principal;

import br.com.alura.screenMatch.modelo.Episodes;
import br.com.alura.screenMatch.modelo.Movie;
import br.com.alura.screenMatch.modelo.Series;
import br.com.alura.screenMatch.modelo.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Movie myMovie = new Movie("Harry Potter, e o Cálice de Fogo", 2005);
        myMovie.avaliacao();
        Movie yourMovie = new Movie("Harry Potter, e o Prisioneiro de Azkaban", 2004);
        yourMovie.avaliacao();
        Movie ourMovie = new Movie("Harry Potter, e a Câmara Secreta", 2002);
        ourMovie.avaliacao();
        Series mySerie = new Series("Stranger Things", 2016);
        mySerie.avaliacao();

        List<Titulo> list = new ArrayList<>();
        list.add(myMovie);
        list.add(yourMovie);
        list.add(ourMovie);
        list.add(mySerie);
        for (Titulo item: list) {
            System.out.println(item.getName());
            if (item instanceof Movie movie) {
                System.out.println("Classificação " + movie.getClassification());
            }
        }

        Collections.sort(list);
        System.out.println(list);
    }
}
