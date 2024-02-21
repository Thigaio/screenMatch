import br.com.alura.screeMatch.calculo.Calculator;
import br.com.alura.screeMatch.calculo.RecommendationFilter;
import br.com.alura.screenMatch.modelo.Episodes;
import br.com.alura.screenMatch.modelo.Movie;
import br.com.alura.screenMatch.modelo.Series;
import br.com.alura.screenMatch.modelo.Titulo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Movie myMovie = new Movie("Harry Potter, e o Cálice de Fogo", 2005);
        myMovie.setTimeInMinutes(157);
        myMovie.setIncluded(true);
        myMovie.setDirector("Mike Newell");

        myMovie.showTecnicTable();

        myMovie.avaliacao();

        System.out.println("Esse filme foi avaliado " + myMovie.getTotalScore() + " vezes");

        System.out.println("A média de avaliações desse filme é " + myMovie.getScore());

        Series mySerie = new Series("Stranger Things", 2016);
        mySerie.setIncluded(true);
        mySerie.setSeasons(4);
        mySerie.setEpsPerSeason(8);
        mySerie.setMinutesPerEps(50);

        mySerie.showTecnicTable();

        mySerie.avaliacao();

        System.out.println("Essa série foi avaliada " + mySerie.getTotalScore() + " vezes");

        System.out.println("A média de avaliações dessa série é " + mySerie.getScore());

        Calculator calc = new Calculator();
        calc.Include(myMovie);
        System.out.println("Esse filme tem " + calc.getTotalTime() + " Minutos");
        calc.Include(mySerie);
        System.out.println("Essa série tem " + calc.getTotalTime() + " Minutos");

        RecommendationFilter filter = new RecommendationFilter();
        filter.filtra(myMovie);

        Episodes episodes = new Episodes();
        episodes.setSeries(mySerie);
        episodes.setEpNumber(1);
        episodes.setTotalViews(300);

        filter.filtra(episodes);

        Movie yourMovie = new Movie("Harry Potter e o Prisioneiro de Azkaban", 2004);
        Movie ourMovie = new Movie("Harry Potter e a Câmara Secreta", 2002);

        ArrayList<Titulo> movieList = new ArrayList<>();

        movieList.add(myMovie);
        movieList.add(yourMovie);
        movieList.add(ourMovie);

        System.out.println("Tamanho da lista " + movieList.size());
        System.out.println("Primeiro Filme " + movieList.get(0).getName());
        System.out.println(movieList);
        System.out.println("toString do filme " + movieList.get(0).toString());
    }
}