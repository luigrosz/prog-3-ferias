public class CampoVazioException extends Exception {
  public CampoVazioException(String campo) {
    super("O campo '" + campo + "' nao pode estar vazio.");
  }
}
