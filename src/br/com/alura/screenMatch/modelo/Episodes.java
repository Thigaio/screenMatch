package br.com.alura.screenMatch.modelo;

import br.com.alura.screenMatch.calculo.Classificavel;

public class Episodes implements Classificavel {
    private int epNumber = 0;
    private String epName;
    private Series series;
    private int totalViews = 0;

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getEpNumber() {
        return epNumber;
    }

    public void setEpNumber(int epNumber) {
        this.epNumber = epNumber;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    @Override
    public int getClassification() {
        if (totalViews >= 300) {
            return 4;
        } else {
            return 2;
        }
    }
}
