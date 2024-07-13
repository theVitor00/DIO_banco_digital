package banco;

import banco.conta.ContaCorrente;
import banco.conta.ContaPoupanca;


public class Banco {

    public static void main(String[] args) {

        ContaCorrente conta1 = new ContaCorrente("Pablo");
        ContaCorrente conta2 = new ContaCorrente("Monalisa");
        ContaPoupanca conta3 = new ContaPoupanca("Ronaldinho");

        System. out.println("____________CONTA 1_____________");
        System.out.println("Número da Conta: " + conta1.getNumeroConta());
        System.out.println("Agência: " + conta1.getAgencia());
        System.out.println("Tipo de Conta: " + conta1.getTipo());
        System.out.println("Limite de Crédito: " + conta1.getLimiteCredito());
        conta1.depositar(200);
        conta1.mostrarSaldo();
        conta1.transferirCC(150, conta2);
        conta1.sacar(50);
        conta1.mostrarExtrato();

        conta1.mostrarSaldo();

        System. out.println("____________CONTA 2_____________");
        System.out.println("Número da Conta: " + conta2.getNumeroConta());
        System.out.println("Agência: " + conta2.getAgencia());
        System.out.println("Tipo de Conta: " + conta2.getTipo());
        System.out.println("Limite de Crédito: " + conta2.getLimiteCredito());
        conta2.mostrarSaldo();
        conta2.depositar(350);
        conta2.sacar(135);
        conta2.mostrarSaldo();

        System. out.println("____________CONTA 3_____________");
        System.out.println("Número da Conta: " + conta3.getNumeroConta());
        System.out.println("Agência: " + conta3.getAgencia());
        System.out.println("Tipo de Conta: " + conta3.getTipo());
        System.out.println("Taxa de Rendimento: " + conta3.getTaxaRendimentoAoMes());
        conta3.depositar(500);
        conta3.sacar(75);
        conta3.mostrarExtrato();
        conta3.mostrarSaldo();
        System.out.printf("Rendimento Previsto: %.2f%n", conta3.getRendimentoPorMeses(1));

        conta2.transferirCP(15, conta3);
        System.out.print("Saldo conta 2: \n");
        conta2.mostrarSaldo();

        System.out.println("Saldo Conta 3: ");
        conta3.mostrarSaldo();
        conta3.mostrarExtrato();




    }



}
