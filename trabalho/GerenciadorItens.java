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
        String tipo = i.getClass().getSimpleName();
        if (tipo.equals("Filme")) { // i.getClass().SimpleName() = filme || livro
          Filme f = (Filme) i;
          pw.println("Filme;" +
              f.getTitulo() + ";" +
              f.getDescricao() + ";" +
              f.getDataCadastro() + ";" +
              f.getDuracaoMinutos() + ";" +
              f.getDiretor());
        } else if (tipo == "Livro") {
          Livro l = (Livro) i;
          pw.println("Livro;" +
              l.getTitulo() + ";" +
              l.getDescricao() + ";" +
              l.getDataCadastro() + ";" +
              l.getNumeroPaginas() + ";" +
              l.getAutor());
        }
      }
    } catch (IOException e) {
      System.out.println("Erro ao exportar: " + e.getMessage());
    }
  }

  public void importarDeArquivo(String caminho) {
    try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
      String linha;
      while ((linha = br.readLine()) != null) {
        String[] partes = linha.split(";");
        if (partes.length >= 6) {
          String tipo = partes[0];
          String titulo = partes[1];
          String descricao = partes[2];
          LocalDate data = LocalDate.parse(partes[3]);
          if (tipo.equals("Livro")) {
            String numeroPaginas = partes[4];
            String autor = partes[5];
            int paginas = Integer.parseInt(numeroPaginas);
            Livro livro = new Livro(titulo, descricao, data, autor, paginas);
            itens.add(livro);
          } else if (tipo.equals("Filme")) {
            String duracaoMinutos = partes[4];
            String diretor = partes[5];
            int duracao = Integer.parseInt(duracaoMinutos);
            Filme filme = new Filme(titulo, descricao, data, diretor, duracao);
            itens.add(filme);
          }
        }
      }
    } catch (IOException e) {
      System.out.println("Erro ao importar: " + e.getMessage());
    }
  }
}
