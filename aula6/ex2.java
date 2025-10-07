import java.util.HashSet;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> palavras = new HashSet<>();

        while (true) {
            System.out.print("Digite uma palavra (ou 'fim' para encerrar): ");
            String p = sc.nextLine();
            if (p.equalsIgnoreCase("fim")) break;
            palavras.add(p);
        }

        System.out.println("Palavras unicas: " + palavras);

        if (palavras.contains("Java"))
            System.out.println("A palavra 'Java' foi digitada.");
        else
            System.out.println("A palavra 'Java' nao foi digitada.");

        sc.close();
    }
}
