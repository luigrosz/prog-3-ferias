import java.util.HashMap;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> pessoas = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();
            System.out.print("Digite a idade: ");
            int idade = sc.nextInt();
            sc.nextLine();
            pessoas.put(nome, idade);
        }

        System.out.print("Digite um nome para consultar a idade: ");
        String consulta = sc.nextLine();
        if (pessoas.containsKey(consulta))
            System.out.println("Idade de " + consulta + ": " + pessoas.get(consulta));
        else
            System.out.println("Nome nao encontrado.");

        System.out.print("Digite um nome para remover: ");
        String remover = sc.nextLine();
        pessoas.remove(remover);

        System.out.println("Mapa atualizado: " + pessoas);
        sc.close();
    }
}
