package br.com.alura.screenMatch.modelo;

import br.com.alura.screenMatch.calculo.Classificavel;
import br.com.alura.screenMatch.exceptions.ConversaoDeAno;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.Scanner;

public class Titulo implements Comparable<Titulo> {
    private String name;
    private int releaseDate;
    private boolean included;
    private double somaAvaliacoes;
    private int totalScore;
    private int timeInMinutes;
    private int option = 0;
    private double score = 0;
    private Scanner scan = new Scanner(System.in);

    public Titulo (String name, int releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public Titulo(TituloOMDB meuTitulo) {
        this.name = meuTitulo.title();

        if (meuTitulo.year().length() > 4) {
            throw new ConversaoDeAno("Não foi possível converter o ano de  por ter mais de 4 caracteres");
        }

        this.releaseDate = Integer.valueOf(meuTitulo.year());
        this.timeInMinutes = Integer.valueOf(meuTitulo.runtime().substring(0, 3));
    }

    public void showTecnicTable () {
        System.out.println("Nome do titulo: " + name);
        System.out.println("Ano de lançamento: " + releaseDate);

    }

    public void avaliacao () {
        System.out.println("Deseja avaliar " + name);
        System.out.println("""
                0- Não
                1- Sim""");
        option = scan.nextInt();

        while(option != 0) {
            avalia();
            System.out.println("A nota que você dá pra esse titulo é " + score);

            System.out.println("Deseja avaliar novamente esse titulo ?");
            System.out.println("""
                0- Nâo
                1- Sim""");
            option = scan.nextInt();
            if (option != 0 && option != 1){
                System.out.println("Opção inválida");
            }

        }
    }

    void avalia () {
        System.out.println("Digite tua nota para " + name);
        score = scan.nextDouble();
        somaAvaliacoes += score;
        totalScore++;
    }

    public double getScore () {

        return somaAvaliacoes / totalScore;
    }

    public int getTotalScore() {

        return totalScore;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setIncluded(boolean included) {

        this.included = included;
    }

    public void setTimeInMinutes(int timeInMinutes) {

        this.timeInMinutes = timeInMinutes;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getName().compareTo(outroTitulo.getName());
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", timeInMinutes=" + timeInMinutes +
                '}';
    }
}
