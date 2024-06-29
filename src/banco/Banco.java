package banco;

import banco.controlador.Administrativo;

import java.util.Scanner;


public class Banco {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Administrativo administrativo = new Administrativo();

        administrativo.mostrarOpcoes();
    }

}
