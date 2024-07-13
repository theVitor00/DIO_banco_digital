package banco.conta;

import java.util.List;

public interface Conta {


    // GETTERS
    public int getAgencia();

    public int getNumeroConta();

    public void mostrarSaldo();

    public double getSaldo();


    public String getNome();

    public String getTipo();




    // SETTERS
    public void setNome(String nome);

    public void depositar(double valor);
    public void sacar(double valor);

    void salvarAtividadeParaExtrato(String transacao, double valor);

    public List<String> getExtrato();

}
