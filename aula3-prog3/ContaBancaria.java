public class ContaBancaria {
    private String numero;

    public ContaBancaria(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Conta Bancária [Número: " + numero + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContaBancaria outraConta = (ContaBancaria) obj;
        return numero.equals(outraConta.numero);
    }

    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("12345");
        ContaBancaria conta2 = new ContaBancaria("12345");

        System.out.println("As contas são iguais? " + conta1.equals(conta2));

        System.out.println("Conta 1: " + conta1);
        System.out.println("Conta 2: " + conta2);
    }
}
