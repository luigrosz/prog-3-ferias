import java.io.*;

public class VerificaArquivo {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Digite o caminho do arquivo: ");
      String caminho = br.readLine();

      File f = new File(caminho);

      if (!f.exists()) {
        System.out.println("O arquivo ou diretorio nao existe.");
        return;
      }

      if (f.isFile()) {
        System.out.println("Tipo: Arquivo");
        System.out.println("Tamanho: " + f.length() + " bytes");
      } else if (f.isDirectory()) {
        System.out.println("Tipo: Diretorio");
      }

      System.out.println("Caminho absoluto: " + f.getAbsolutePath());
    } catch (IOException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}
