import java.util.ArrayList;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um numero: ");
            numeros.add(sc.nextInt());
        }

        System.out.println("Numeros inseridos: " + numeros);

        int soma = 0;
        for (int n : numeros) soma += n;
        double media = soma / 10.0;

        System.out.println("Soma: " + soma);
        System.out.println("Media: " + media);

        numeros.removeIf(n -> n % 2 == 0);
        System.out.println("Lista sem pares: " + numeros);

        sc.close();
    }
}
