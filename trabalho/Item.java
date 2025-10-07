import java.time.LocalDate;

public abstract class Item {
  private String titulo;
  private String descricao;
  private LocalDate dataCadastro;

  public Item(String titulo, String descricao, LocalDate dataCadastro) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.dataCadastro = dataCadastro;
  }

  public abstract String exibirDetalhes();

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDate getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(LocalDate dataCadastro) {
    this.dataCadastro = dataCadastro;
  }
}
