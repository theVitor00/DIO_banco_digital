package banco.controlador;

import banco.conta.ContaCorrente;
import banco.conta.ContaPoupanca;
import banco.dados.contas.DadosDeContas;


import java.util.Scanner;

public class Controlador {

    Scanner scan = new Scanner(System.in);

    // TODO: otimizar este método dividindo o em várias funções menores
    public void criarContaCorrente(String nome) {
            ContaCorrente conta = new ContaCorrente(nome);
            DadosDeContas dados = new DadosDeContas();
            dados.adicionarConta(conta);
            System.out.println("Conta Corrente criada com sucesso!");
    }

    public void criarContaPoupanca(String nome) {
        ContaPoupanca conta = new ContaPoupanca(nome);
        System.out.println("Conta Poupança criada com sucesso!");
    }
}
