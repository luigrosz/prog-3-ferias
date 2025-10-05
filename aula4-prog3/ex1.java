abstract class ContaBancaria {
  protected double saldo;

  public ContaBancaria(double saldoInicial) {
    this.saldo = saldoInicial;
  }

  public abstract boolean sacar(double valor);

  public abstract void depositar(double valor);

  public double getSaldo() {
    return saldo;
  }
}

class ContaCorrente extends ContaBancaria {
  public ContaCorrente(double saldoInicial) {
    super(saldoInicial);
  }

  @Override
  public boolean sacar(double valor) {
    double total = valor + 1.0;
    if (saldo >= total) {
      saldo -= total;
      return true;
    }
    return false;
  }

  @Override
  public void depositar(double valor) {
    saldo += valor;
  }
}

class ContaPoupanca extends ContaBancaria {
  public ContaPoupanca(double saldoInicial) {
    super(saldoInicial);
  }

  @Override
  public boolean sacar(double valor) {
    if (saldo >= valor) {
      saldo -= valor;
      return true;
    }
    return false;
  }

  @Override
  public void depositar(double valor) {
    saldo += valor;
  }
}

public class ex1 {
  public static void main(String[] args) {
    ContaBancaria cc = new ContaCorrente(100);
    ContaBancaria cp = new ContaPoupanca(100);

    System.out.println("Saldo inicial CC: " + cc.getSaldo());
    cc.depositar(50);
    cc.sacar(30);
    System.out.println("Saldo final CC: " + cc.getSaldo());

    System.out.println("\nSaldo inicial CP: " + cp.getSaldo());
    cp.depositar(50);
    cp.sacar(30);
    System.out.println("Saldo final CP: " + cp.getSaldo());
  }
}
