import java.io.*;
import java.util.*;

public class GravarArquivo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      PrintStream ps = new PrintStream("saida.txt");
      while (true) {
        String linha = sc.nextLine();
        if (linha.equals("FIM"))
          break;
        ps.println(linha);
      }
      ps.close();
    } catch (IOException e) {
      System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
    }
    sc.close();
  }
}
