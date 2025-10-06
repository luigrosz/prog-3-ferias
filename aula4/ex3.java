interface Corredor {
  void correr();
}

interface Nadador {
  void nadar();
}

interface Ciclista {
  void pedalar();
}

class Triatleta implements Corredor, Nadador, Ciclista {
  String nome;

  Triatleta(String nome) {
    this.nome = nome;
  }

  @Override
  public void correr() {
    System.out.println(nome + " esta correndo na pista.");
  }

  @Override
  public void nadar() {
    System.out.println(nome + " esta nadando na piscina.");
  }

  @Override
  public void pedalar() {
    System.out.println(nome + " esta pedalando na estrada.");
  }
}

public class ex3 {
  public static void main(String[] args) {
    Triatleta t1 = new Triatleta("Carlos");

    t1.correr();
    t1.nadar();
    t1.pedalar();
  }
}
