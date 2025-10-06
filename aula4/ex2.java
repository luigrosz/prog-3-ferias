enum NivelAcesso {
  BASICO,
  INTERMEDIARIO,
  ADMIN
}

class Usuario {
  String nome;
  NivelAcesso nivel;

  Usuario(String nome, NivelAcesso nivel) {
    this.nome = nome;
    this.nivel = nivel;
  }

  void exibirMensagem() {
    if (nivel == NivelAcesso.BASICO) {
      System.out.println(nome + " possui acesso basico. Pode apenas visualizar conteudos.");
    } else if (nivel == NivelAcesso.INTERMEDIARIO) {
      System.out.println(nome + " possui acesso intermediario. Pode visualizar e editar conteudos.");
    } else if (nivel == NivelAcesso.ADMIN) {
      System.out.println(nome + " possui acesso de administrador. Pode gerenciar todo o sistema.");
    }
  }
}

public class ex2 {
  public static void main(String[] args) {
    Usuario u1 = new Usuario("Ana", NivelAcesso.BASICO);
    Usuario u2 = new Usuario("Bruno", NivelAcesso.INTERMEDIARIO);
    Usuario u3 = new Usuario("Carla", NivelAcesso.ADMIN);

    u1.exibirMensagem();
    u2.exibirMensagem();
    u3.exibirMensagem();
  }
}
