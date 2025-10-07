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
}
