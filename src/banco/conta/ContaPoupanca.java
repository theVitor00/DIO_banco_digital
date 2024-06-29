package banco.conta;

import banco.conta.Conta;

public class ContaPoupanca extends Conta{

    private double taxaRendimentoAoMes;
    private double rendimentoPrevisto;

    public ContaPoupanca(String nome) {
        super(nome);
        this.taxaRendimentoAoMes = 0.0053;
        this.tipo = "CP";
    }

    public double getTaxaRendimentoAoMes() {
        return taxaRendimentoAoMes;
    }

    public void setTaxaRendimentoAoMes(double taxaRendimentoAoMes) {
        this.taxaRendimentoAoMes = taxaRendimentoAoMes;
    }

    private void calcularRendimento() {
        rendimentoPrevisto += this.saldo * taxaRendimentoAoMes;
    }

    public double mostrarRendimentoPrevisto() {
        return rendimentoPrevisto;
    }
}
