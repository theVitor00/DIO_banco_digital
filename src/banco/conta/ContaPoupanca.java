package banco.conta;

import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca implements Conta, Poupanca{

    private double taxaRendimentoAoMes;
    private static int SEQUENCIAL = 2000;
    private static final int AGENCIA_PADRAO = 100;
    protected int agencia;
    private final int numeroConta;
    private double saldo = 0;
    private String nome;
    private final String tipo;
    List<String> extrato = new ArrayList<>();

    public ContaPoupanca(String nome) {
        this.nome = nome;
        this.tipo = "CP";
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.taxaRendimentoAoMes = 0.0053;
    }

    public double getRendimentoPorMeses(int mes) {
        System.out.println("RENDIMENTO PREVISTO");
        return (saldo + (saldo * taxaRendimentoAoMes)) * mes;
    }

    @Override
    public int getAgencia() {
        return agencia;
    }

    @Override
    public int getNumeroConta() {
        return numeroConta;
    }

    @Override
    public void mostrarSaldo() {
        System.out.printf("SALDO ATUAL: %.2f%n", this.saldo);
    }

    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }


   public void mostrarExtrato() {
       for(String atividade : extrato) {
           System.out.print(atividade);
       }
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
        salvarAtividadeParaExtrato("SAQUE", valor);
    }

    public void depositar(double valor) {
        this.saldo += valor;
        salvarAtividadeParaExtrato("DEPÓSITO", valor);
    }

    @Override
    public void salvarAtividadeParaExtrato(String transacao, double valor) {
        String operacao = "TRANSAÇÃO: " + transacao + " | " + "VALOR: " + valor + "|\n";
        extrato.add(operacao);
    }

    @Override
    public List<String> getExtrato() {
        return extrato;
    }

    public double getTaxaRendimentoAoMes() {
        return taxaRendimentoAoMes;
    }

    @Override
    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimentoAoMes = taxaRendimentoAoMes;
    }




}
