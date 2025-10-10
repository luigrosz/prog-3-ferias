import java.io.*;

public class LeitorArquivo {
  public static void main(String[] args) {
    BufferedReader br = null;
    try {
      System.out.print("Digite o nome do arquivo: ");
      BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
      String nomeArquivo = entrada.readLine();

      FileInputStream fis = new FileInputStream(nomeArquivo);
      InputStreamReader isr = new InputStreamReader(fis);
      br = new BufferedReader(isr);

      String linha;
      while ((linha = br.readLine()) != null) {
        System.out.println(linha);
      }
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    } finally {
      try {
        if (br != null)
          br.close();
      } catch (IOException e) {
        System.out.println("Erro ao fechar o arquivo.");
      }
    }
  }
}
