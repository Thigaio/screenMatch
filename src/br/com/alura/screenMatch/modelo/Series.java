package br.com.alura.screenMatch.modelo;

public class Series extends Titulo {
    private int seasons = 0;
    private int epsPerSeason = 0;
    private boolean streaming;
    private int minutesPerEps = 0;

    public Series(String nome, int releaseDate) {
        super(nome, releaseDate);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpsPerSeason() {
        return epsPerSeason;
    }

    public void setEpsPerSeason(int epsPerSeason) {
        this.epsPerSeason = epsPerSeason;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    public int getMinutesPerEps() {
        return minutesPerEps;
    }

    public void setMinutesPerEps(int minutesPerEps) {
        this.minutesPerEps = minutesPerEps;
    }

    @Override
    public int getTimeInMinutes() {
        return seasons * epsPerSeason * minutesPerEps;
    }

    public String toString() {
        return "Serie: " + this.getName() + "(" + this.getReleaseDate() +  ")";
    }

}
