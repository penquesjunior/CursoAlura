package br.com.trabalho.calculadora.principal;

import br.com.trabalho.calculadora.models.Filme;
import br.com.trabalho.calculadora.models.Serie;
import br.com.trabalho.calculadora.models.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {


        Serie serie = new Serie("Lost", 2017);
        Filme filme2 = new Filme("Dogville", 2003);
        Filme outro = new Filme("John Wick", 2014);
        Filme favorito = new Filme("The Matrix", 1999);

        List<Titulo> lista = new LinkedList<>();
        lista.add(filme2);
        lista.add(favorito);
        lista.add(serie);
        lista.add(outro);
        for (Titulo titulo: lista){
            System.out.println(titulo.getNome());
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        System.err.println("Depois da Ordenação:");
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);
        System.out.println("List de Titulos Ordenadas");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenano por ano: ");
        System.out.println(lista);


        //API -KEY http://www.omdbapi.com/?i=tt3896198&apikey=9ace215f

    }
}
