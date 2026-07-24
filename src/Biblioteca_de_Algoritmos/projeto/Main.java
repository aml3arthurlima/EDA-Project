package Biblioteca_de_Algoritmos.projeto;

import java.util.Scanner;

/**
Menu com opções:
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===================================");
            System.out.println(" Biblioteca de Estruturas de Dados");
            System.out.println("===================================");
            System.out.println("1 - Pilha");
            System.out.println("2 - Fila");
            System.out.println("3 - Lista Simples");
            System.out.println("4 - Lista Dupla");
            System.out.println("5 - BST");
            System.out.println("6 - AVL");
            System.out.println("7 - Árvore B");
            System.out.println("0 - Encerrar");

            opcao = ConsoleUtil.lerInt(scanner, "Escolha uma opção: ");


            if (opcao == 4) {
                new MenuListaDupla(scanner).abrir();

            } else if (opcao == 5) {
                new MenuBST(scanner).abrir();

            } else if (opcao == 0) {
                System.out.println("Encerrando...");

            } else {
                System.out.println("Opção inválida");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
