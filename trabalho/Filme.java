import java.time.LocalDate;

public class Filme extends Item {
  private String diretor;

  public Filme(String titulo, String descricao, LocalDate dataCadastro, String diretor) {
    super(titulo, descricao, dataCadastro);
    this.diretor = diretor;
  }

  public String getDiretor() {
    return diretor;
  }

  public void setDiretor(String diretor) {
    this.diretor = diretor;
  }

  public String exibirDetalhes() {
    return "Diretor: " + diretor;
  }
}
