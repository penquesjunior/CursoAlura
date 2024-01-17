import java.util.Random;
import java.util.Scanner;

public class Condicional {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sorteado = new Random().nextInt(100);
        int numeroEntrada;

        System.out.println(sorteado);

        for (int i = 0; i < 5 ; i++) {
            System.out.printf("digite o numero ");
            numeroEntrada = sc.nextInt();
            if (numeroEntrada > sorteado){
                System.out.println("numero errado tente um numero menor");
            } else if (numeroEntrada< sorteado) {
                System.out.println("numero errado tente um numero maior");
            }else{
                System.out.println("voce acertou!");
                i = 4;
                System.out.println("fim de jogo");
            }
        }

    }
}
