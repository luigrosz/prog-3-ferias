import java.util.Scanner;

public class ex3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String entradaDoUsuario = "";
    int numeroConvertido = 0;

    try {
      System.out.print("Digite um numero inteiro: ");
      entradaDoUsuario = scanner.nextLine();
      numeroConvertido = Integer.parseInt(entradaDoUsuario);

      System.out.println("\nO numero que você digitou foi: " + numeroConvertido);

    } catch (NumberFormatException e) {
      System.err.println("Voce digitou um valor invalido. A entrada '" + entradaDoUsuario
          + "' nao pode ser convertida para um numero inteiro.");
      System.err.println("Detalhes do erro: " + e.getMessage());

    } finally {
      System.out.println("Encerrando programa");
      scanner.close();
    }
  }
}
