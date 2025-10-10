public class GeradorCorAluno {
  public static String gerarCorComMultiplicacao(String nome, String rga) {
    // Remove espaços e normaliza para maiúsculas
    nome = nome.trim().toUpperCase();
    rga = rga.trim();

    long rgaNumero;
    try {
      rgaNumero = Long.parseLong(rga);
    } catch (NumberFormatException e) {
      rgaNumero = 1;
    }

    // 1️⃣ Soma ASCII do nome
    long somaNome = 0;
    for (char c : nome.toCharArray()) {
      somaNome += c;
    }

    // 2️⃣ Multiplica pela versão numérica do RGA
    long valorTotal = somaNome * rgaNumero;

    // 3️⃣ Separa valores RGB com deslocamentos
    int r = (int) ((valorTotal) % 256);
    int g = (int) ((valorTotal / 1000) % 256);
    int b = (int) ((valorTotal / 1000000) % 256);

    // 4️⃣ Clareia a cor (evita tons escuros)
    int min = 100; // mínimo para cada canal
    r = Math.max(r, min);
    g = Math.max(g, min);
    b = Math.max(b, min);

    // 5️⃣ Retorna em formato hexadecimal #RRGGBB
    return String.format("#%02X%02X%02X", r, g, b);
  }

  // 🔸 Exemplo de uso
  public static void main(String[] args) {
    String nome = " Lui Mendes Grosz ";
    String rga = "202111722018 ";

    String cor = gerarCorComMultiplicacao(nome, rga);
    System.out.println("Cor gerada para " + nome + ": " + cor);
  }
}
