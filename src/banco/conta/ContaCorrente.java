package banco.conta;

public class ContaCorrente extends Conta {

    // ATRIBUTOS
    private String extrato;
    private double limiteCredito = 350;

    // CONSTRUCTOR
    public ContaCorrente(String nome) {
        super(nome);
        this.tipo = "CC";

    }

    //SETTERS
    public void setLimiteCredito(double novoLimite) {
        this.limiteCredito = novoLimite;
    }

    // GETTERS
    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public void sacar(double valor) {
        if(valor > this.saldo + this.limiteCredito) {
            System.out.println("Valor ultrapassa limite disponível");
        } else if(valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            mostrarSaldo();
        } else if(valor >= this.saldo && valor <= this.saldo + this.limiteCredito) {
            this.limiteCredito = limiteCredito - (valor - this.saldo);
            this.saldo = 0;
            System.out.println("Saque utilizando limite de crédito foi realizado com sucesso");
            mostrarSaldo();
            System.out.printf("Limite de crédito disponível: %.2f%n", this.getLimiteCredito());
        }
    }

    public void transferir(double valor, Conta conta) {
        sacar(valor);
        conta.depositar(valor);
        System.out.printf("Foi depositado a quantia de %.2f na conta %s%n", valor, conta.getNome());
        salvarAtividadeParaExtrato("TRANSFERÊNCIA", valor);
    }
}
