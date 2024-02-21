package br.com.alura.screenMatch.calculo;

public class RecommendationFilter {
    public void filtra (Classificavel classificavel) {
        if (classificavel.getClassification() >= 4) {
            System.out.println("Está entre os preferidos do momento!");
        } else if (classificavel.getClassification() >= 2 && classificavel.getClassification() < 4) {
            System.out.println("Muito bem avaliado no momento!");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
