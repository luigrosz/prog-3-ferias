import java.time.LocalDate;

public class Livro extends Item {
  private String autor;
  private int numeroPaginas;

  public Livro(String titulo, String descricao, LocalDate dataCadastro, String autor, int numeroPaginas) {
    super(titulo, descricao, dataCadastro);
    this.autor = autor;
    this.numeroPaginas = numeroPaginas;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getNumeroPaginas() {
    return numeroPaginas;
  }

  public void setNumeroPaginas(int numeroPaginas) {
    this.numeroPaginas = numeroPaginas;
  }

  public String exibirDetalhes() {
    return "Autor: " + autor;
  }
}
