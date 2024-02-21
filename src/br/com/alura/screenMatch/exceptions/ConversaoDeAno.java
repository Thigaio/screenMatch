package br.com.alura.screenMatch.exceptions;

public class ConversaoDeAno extends RuntimeException {
    private String mensagem;
    public ConversaoDeAno(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
