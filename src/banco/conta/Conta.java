package banco.conta;

import java.util.List;

public class Conta {

    // ATRIBUTOS
    private static int SEQUENCIAL = 1000;
    private static final int AGENCIA_PADRAO = 100;
    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected String nome;
    protected String tipo;
    List<String> extrato;


    // CONSTRUCTOR
    public Conta(String nome) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.nome = nome;
    }

    // GETTERS
    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double mostrarSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }



    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        salvarAtividadeParaExtrato("DEPÓSITO", valor);
    }

    public void sacar(double valor) {
        if(this.saldo > valor) {
            this.saldo = this.saldo - valor;
            System.out.printf("Foi sacado o falor de %.2f Reais.%n", valor);
            System.out.printf("Novo Saldo: %.2f%n", mostrarSaldo());
            salvarAtividadeParaExtrato("SAQUE", valor);
        }
    }

    protected void salvarAtividadeParaExtrato(String transacao, double valor) {
        String item = transacao + "\nValor: " + String.valueOf(valor);
        extrato.add(item);
    }

    public void mostrarExtrato() {
        System.out.println("EXTRATO DA CONTA:");
        for(String atividade : extrato) {
            System.out.println(atividade);
        }
    }

}
