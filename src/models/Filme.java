package models;

import br.com.trabalho.calculadora.Calculadora.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificavel() {
        return (int)pegaMedia() / 2;
    }
}

