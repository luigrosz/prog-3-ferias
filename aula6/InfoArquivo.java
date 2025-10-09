import java.io.*;

public class InfoArquivo {
  public static void main(String[] args) {
    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Digite o caminho do arquivo: ");
    try {
      String caminho = teclado.readLine();
      File f = new File(caminho);
      if (!f.exists()) {
        System.out.println("O arquivo ou diretorio nao existe.");
        return;
      }
      if (f.isFile()) {
        System.out.println("Eh um arquivo.");
        System.out.println("Tamanho: " + f.length() + " bytes");
      } else if (f.isDirectory()) {
        System.out.println("Eh um diretorio.");
        String[] arquivos = f.list();
        if (arquivos != null) {
          System.out.println("Conteudo:");
          for (String nome : arquivos)
            System.out.println("- " + nome);
        }
      }
      System.out.println("Caminho absoluto: " + f.getAbsolutePath());
    } catch (IOException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}
