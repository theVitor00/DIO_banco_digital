package banco.controlador;

import banco.cliente.Cliente;
import banco.conta.ContaCorrente;
import banco.conta.ContaPoupanca;
import banco.dados.contas.DadosDeContas;

import java.util.Scanner;

public class Administrativo {

    Scanner scan = new Scanner(System.in);
    DadosDeContas dados = new DadosDeContas();

    public void mostrarOpcoes() {
        int opcao;
        System.out.println("Qual serviço admistrativo deseja realizar: ");
        System.out.println("\t1 - Criar Conta");
        System.out.println("\t2 - Listar Contas");
        System.out.println("\t3 - Mostrar Dados de Cliente");
        System.out.println("\t4 - Retornar ao início");
        System.out.println("OPÇÃO: ");
        opcao = scan.nextInt();

        switch(opcao) {
            case 1:
                criarConta();
                break;
            case 2:
                dados.mostrarDadosDeContas();
                break;/*
            case 3:
                mostrarListaClientes();
                break;
            case 4:
                voltarMenuPrincipal();
                break;*/
            default:
                System.out.println("Opção Inválida!");
        }
    }

    private void criarConta() {
        String nome, cpf, endereco, telefone;
        System.out.println("CRIANDO CONTA");
        System.out.println("Nome: ");
        scan.nextLine();
        nome = scan.nextLine();
        System.out.println("CPF (xxx.xxx.xxx-xx): ");
        cpf = scan.nextLine();
        System.out.println("Endereço: ");
        endereco = scan.nextLine();
        System.out.println("Telefone: ");
        telefone = scan.nextLine();

        Cliente cliente = new Cliente(nome, cpf, endereco, telefone);

        System.out.println("--------------------------------------------------------");

        int tipo;
        System.out.println("Tipo de Conta (1 - Corrente | 2 - Poupança");
        while (true) {
            System.out.println("Tipo: ");
            tipo = scan.nextInt();
            scan.nextLine();
            if(tipo == 1) {
                ContaCorrente contaCorrente = new ContaCorrente(nome);
                System.out.println("Conta Corrente criada com sucesso!");
                dados.adicionarConta(contaCorrente);
                break;
            } else if(tipo == 2) {
                ContaPoupanca contaPoupanca = new ContaPoupanca(nome);
                System.out.println("Conta Poupança criada com sucesso!");
                dados.adicionarConta(contaPoupanca);
                break;

            } else {
                System.out.println("Valor inválido, digite novamente");
            }
        }
        mostrarOpcoes();

    }

    private void mostrarDadosCliente(String nome) {

    }


}
