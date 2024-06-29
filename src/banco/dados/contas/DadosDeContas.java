package banco.dados.contas;

import banco.conta.Conta;

import java.util.ArrayList;
import java.util.List;

public class DadosDeContas {

    List<Conta> dadosDeContas = new ArrayList<>();

    public int getTotalContas() {
        return dadosDeContas.size();
    }

    public void adicionarConta(Conta conta) {
        dadosDeContas.add(conta);
        System.out.printf("Conta <%s> adicionada com sucesso", conta.getNome());
    }

    public void removerConta(Conta conta) {
        for(Conta c : dadosDeContas) {
            if(c.getNome().equalsIgnoreCase(conta.getNome())) {
                dadosDeContas.remove(c);
            }
        }
    }

    public void mostrarListaContas() {
        int marcador = 1;
        for(Conta conta :dadosDeContas) {
            System.out.println(marcador + "-" + conta);
            marcador++;
        }
    }

    public void mostrarDadosDeContas() {
        int marcador = 1;
        for(Conta conta : dadosDeContas) {
            System.out.printf("%d - %s | %d | %d | %s | %.2f", marcador, conta.getTipo(), conta.getAgencia(), conta.getNumeroConta(), conta.getNome(), conta.mostrarSaldo());
            marcador++;
        }
    }
}
