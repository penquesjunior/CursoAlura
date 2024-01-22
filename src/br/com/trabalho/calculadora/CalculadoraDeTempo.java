package br.com.trabalho.calculadora;

import models.Filme;
import models.Serie;
import models.Titulo;

public class CalculadoraDeTempo {

    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void inclui(Filme f){
//        tempoTotal += f.getDuracaoEmMinutos();
//    }
//    public void inclui(Serie s){
//        tempoTotal += (s.getTemporadas()*s.getEpPorTemporada()) * s.getMinutosPorEp();
//    }

    public void inclui(Titulo titulo){
        tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
