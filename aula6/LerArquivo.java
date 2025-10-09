import java.io.*;

public class LerArquivo {
    public static void main(String[] args) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Digite o nome do arquivo: ");
        try {
            String nome = teclado.readLine();
            FileInputStream fis = new FileInputStream(nome);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
