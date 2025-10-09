import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GerenciadorItens {
  private List<Item> itens = new ArrayList<>();

  public void adicionarItem(Item item) throws CampoVazioException {
    if (item == null || item.getTitulo() == null || item.getTitulo().trim().isEmpty())
      throw new CampoVazioException("titulo");
    itens.add(item);
  }

  public List<Item> listarTodos() {
    List<Item> copia = new ArrayList<>(itens);
    Collections.sort(copia, Comparator.comparing(i -> i.getTitulo().toLowerCase()));
    return copia;
  }

  public List<Item> buscarPorTitulo(String titulo) {
    String termo = titulo.toLowerCase();
    return itens.stream()
        .filter(i -> i.getTitulo().toLowerCase().contains(termo))
        .sorted(Comparator.comparing(i -> i.getTitulo().toLowerCase()))
        .collect(Collectors.toList());
  }

  public Map<String, Long> contarPorTipo() {
    return itens.stream()
        .collect(Collectors.groupingBy(i -> i.getClass().getSimpleName(), Collectors.counting()));
  }

  public void exportarParaArquivo(String caminho) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(caminho))) {
      for (Item i : itens) {
        pw.println(i.getClass().getSimpleName() + ";" +
            i.getTitulo() + ";" +
            i.getDescricao() + ";" +
            i.getDataCadastro());
      }
    } catch (IOException e) {
      System.out.println("Erro ao exportar: " + e.getMessage());
    }
  }

  public void importarDeArquivo(String caminho) {
    try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
      String linha;
      while ((linha = br.readLine()) != null) {
        String[] partes = linha.split(","); // csv
        if (partes.length >= 4) {
          String titulo = partes[1];
          String descricao = partes[2];
          LocalDate data = LocalDate.parse(partes[3]);
          Item item = new Item(titulo, descricao, data);
          itens.add(item);
        }
      }
    } catch (IOException e) {
      System.out.println("Erro ao importar: " + e.getMessage());
    }
  }
}
