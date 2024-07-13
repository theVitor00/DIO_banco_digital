package banco.conta;

public interface Corrente {

    public void transferirCC(double valor, ContaCorrente conta);
    public void transferirCP(double valor, ContaPoupanca conta);
}
