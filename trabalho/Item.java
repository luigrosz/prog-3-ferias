import java.time.LocalDate;

public class Item {
  private String titulo;
  private String descricao;
  LocalDate dataCadastro;

  public Item(String titulo, String descricao, LocalDate dataCadastro) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.dataCadastro = dataCadastro;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public LocalDate getDataCadastro() {
    return dataCadastro;
  }
}
