package br.com.alura.screenMatch.modelo;

import br.com.alura.screenMatch.calculo.Classificavel;

public class Movie extends Titulo implements Classificavel {
    private String director;

    public Movie (String nome, int releaseDate) {
        super(nome, releaseDate);
    }

    public String getDirector() {

        return director;
    }

    public void setDirector(String director) {

        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) getScore() / 2;
    }

    public String toString() {
        return "Filme: " + this.getName() + "(" + this.getReleaseDate() +  ")";
    }
}
