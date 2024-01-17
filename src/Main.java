//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    double precoProduto  =  59.90;
    int  quantidade = 10;

    double media = quantidade * precoProduto;

        System.out.format("preço produtp : %s e quantidade :  %d, Soma: %.2f",
                precoProduto,quantidade,media );
    }
}