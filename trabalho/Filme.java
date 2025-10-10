import java.time.LocalDate;

public class Filme extends Item {
  private String diretor;
  private int duracaoMinutos;

  public Filme(String titulo, String descricao, LocalDate dataCadastro, String diretor, int duracaoMinutos) {
    super(titulo, descricao, dataCadastro);
    this.diretor = diretor;
    this.duracaoMinutos = duracaoMinutos;
  }

  public String getDiretor() {
    return diretor;
  }

  public void setDiretor(String diretor) {
    this.diretor = diretor;
  }

  public int getDuracaoMinutos() {
    return duracaoMinutos;
  }

  public void setDuracaoMinutos(int duracaoMinutos) {
    this.duracaoMinutos = duracaoMinutos;
  }

  public String exibirDetalhes() {
    return "Diretor: " + diretor;
  }
}
