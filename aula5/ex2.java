public class ex2 {
  public static double calcularRaiz(int numero) throws IllegalArgumentException {
    if (numero < 0) {
      throw new IllegalArgumentException("Erro: Nao eh possivel calcular a raiz quadrada de um numero negativo.");
    }

    return Math.sqrt(numero);
  }

  public static void main(String[] args) {
    int numeroPositivo = 25;
    try {
      double resultado = calcularRaiz(numeroPositivo);
      System.out.println("A raiz quadrada de " + numeroPositivo + " eh: " + resultado);
    } catch (IllegalArgumentException e) {
      System.err.println("Ocorreu um erro inesperado para um numero positivo: " + e.getMessage());
    }

    int numeroNegativo = -9;
    try {
      double resultado = calcularRaiz(numeroNegativo);
      System.out.println("A raiz quadrada de " + numeroNegativo + " eh: " + resultado);
    } catch (IllegalArgumentException e) {
      System.err.println("Falha ao calcular a raiz quadrada de " + numeroNegativo + ".");
      System.err.println("Mensagem do erro: " + e.getMessage());
    }
  }
}
