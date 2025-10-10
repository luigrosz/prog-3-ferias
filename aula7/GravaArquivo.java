import java.io.*;
import java.util.*;

public class GravaArquivo {
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
      System.out.println("Conteudo gravado em saida.txt");
    } catch (IOException e) {
      System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
    } finally {
      sc.close();
    }
  }
}
