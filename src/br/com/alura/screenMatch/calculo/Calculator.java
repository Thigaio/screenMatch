package br.com.alura.screeMatch.calculo;

import br.com.alura.screenMatch.modelo.Titulo;

public class Calculator {
    private int totalTime = 0;

    public int getTotalTime() {
        return totalTime;
    }

    public void Include(Titulo t) {
        totalTime  += t.getTimeInMinutes();
    }
}
