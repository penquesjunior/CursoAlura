package br.com.trabalho.calculadora.excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {

    private String mensagem;
    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
