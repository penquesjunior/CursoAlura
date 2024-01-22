import br.com.trabalho.calculadora.Calculadora.FiltroRecomendacao;
import br.com.trabalho.calculadora.CalculadoraDeTempo;
import models.Episodio;
import models.Filme;
import models.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme favorito = new Filme();
        favorito.setNome("The Matrix");
        favorito.setAnoDeLancamento(1999);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);
        favorito.setSomaDasAvaliacoes(10);
        favorito.setTotalDeAvaliacoes(4);

        Filme outro = new Filme();
        outro.setNome("John Wick");
        outro.setAnoDeLancamento(2014);
        outro.setDuracaoEmMinutos(101);
        outro.setIncluidoNoPlano(true);

        Serie serie = new Serie();
        serie.setNome("lost");
        serie.setAnoDeLancamento(2017);
        serie.setIncluidoNoPlano(true);
        serie.setAtiva(true);
        serie.setTemporadas(5);
        serie.setEpPorTemporada(10);
        serie.setMinutosPorEp(45);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(favorito);
        calculadora.inclui(outro);
        calculadora.inclui(serie);

        System.out.println("Tempo total: " +calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(favorito);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

    }
}