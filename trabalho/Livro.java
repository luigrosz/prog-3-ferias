import java.time.LocalDate;

public class Livro extends Item {
  private String autor;

  public Livro(String titulo, String descricao, LocalDate dataCadastro, String autor) {
    super(titulo, descricao, dataCadastro);
    this.autor = autor;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String exibirDetalhes() {
    return "Autor: " + autor;
  }
}
