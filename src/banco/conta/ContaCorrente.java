package banco.conta;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente implements Conta, Corrente {

    private static int SEQUENCIAL = 1000;
    private static final int AGENCIA_PADRAO = 100;
    private double limiteCredito = 300;
    protected int agencia;
    private int numeroConta;
    private double saldo = 0;
    private String nome;
    private String tipo;
    List<String> extrato = new ArrayList<>();

    public ContaCorrente(String nome) {
        this.nome = nome;
        this.tipo = "CC";
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
    }


    @Override
    public int getAgencia() {
        return this.agencia;
    }

    @Override
    public int getNumeroConta() {
        return this.numeroConta;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }


    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        salvarAtividadeParaExtrato("DEPÓSITO", valor);
        System.out.printf("Depósito de %.2f concluído com sucesso!%n", valor);
        System.out.println("-----------------------------------------------------------------------");
    }

    @Override
    public void sacar(double valor) {
        if(valor > this.saldo + limiteCredito) {
            System.out.println("Valor ultrapassa limite disponível");
        } else if(valor <= this.saldo) {
            this.saldo -= valor;
            System.out.printf("Saque no valor de %.2f realizado com sucesso!%n", valor);
            salvarAtividadeParaExtrato("SAQUE", valor);
        } else if(valor >= this.saldo && valor <= this.saldo + limiteCredito) {
            this.limiteCredito = limiteCredito - (valor - this.saldo);
            this.saldo = 0;
            System.out.println("Saque utilizando limite de crédito foi realizado com sucesso");
            salvarAtividadeParaExtrato("SAQUE UTIL. LIMITE", valor);
            System.out.printf("Limite de crédito disponível: %.2f%n", this.limiteCredito);
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    @Override
    public void transferirCC(double valor, ContaCorrente conta){
        if(conta != null) {
            sacar(valor);
            conta.depositar(valor);
            salvarAtividadeParaExtrato("TRANSFERÊNCIA", valor);
            System.out.println("-----------------------------------------------------------------------");
        } else {
            System.out.println("Conta inexitente!");
        }
    }

    @Override
    public void transferirCP(double valor, ContaPoupanca conta){
        if(conta != null) {
            sacar(valor);
            conta.depositar(valor);
            salvarAtividadeParaExtrato("TRANSFERÊNCIA", valor);
            System.out.println("-----------------------------------------------------------------------");
        } else {
            System.out.println("Conta inexitente!");
        }
    }

    @Override
    public void salvarAtividadeParaExtrato(String transacao, double valor) {
        String operacao = "TRANSAÇÃO: " + transacao + " | " + "VALOR: " + String.valueOf(valor) + "|\n";
        extrato.add(operacao);
    }

    @Override
    public List<String> getExtrato() {
        return this.extrato;
    }

    public void mostrarExtrato() {
        System.out.println("EXTRATO DE TRANSAÇÕES");
        for(String atividade : extrato) {
            System.out.print(atividade);
        }
    }

    public void mostrarSaldo() {
        System.out.printf("SALDO ATUAL: %.2f%n", this.saldo);
        System.out.println("-----------------------------------------------------------------------");
    }

}
