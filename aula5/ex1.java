import java.util.InputMismatchException;
import java.util.Scanner;

public class ex1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      System.out.print("Digite o primeiro numero inteiro: ");
      int numerador = scanner.nextInt();
      System.out.print("Digite o segundo numero inteiro: ");
      int denominador = scanner.nextInt();

      int resultado = numerador / denominador;
      System.out.println("O resultado da divisão é: " + resultado);
    } catch (ArithmeticException e) {
      System.out.println("Erro: Nao eh possivel dividir por zero.");
    } catch (InputMismatchException e) {
      System.out.println("Erro: Insira apenas numeros inteiros validos.");
    } finally {
      scanner.close();
    }
  }
}
