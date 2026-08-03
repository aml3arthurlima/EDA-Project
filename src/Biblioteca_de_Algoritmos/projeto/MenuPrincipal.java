package Biblioteca_de_Algoritmos.projeto;

import Biblioteca_de_Algoritmos.arvoreB.MenuArvoreB;
import Biblioteca_de_Algoritmos.arvoreBST.MenuBST;
import Biblioteca_de_Algoritmos.avl.MenuAVL;
import Biblioteca_de_Algoritmos.fila.MenuFila;
import Biblioteca_de_Algoritmos.listaEncadeada.MenuListaEncadeada;
import Biblioteca_de_Algoritmos.listadupla.MenuListaDupla;
import Biblioteca_de_Algoritmos.pilha.MenuPilha;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner;

    private MenuPilha menuPilha;
    private MenuFila menuFila;
    private MenuListaEncadeada menuLista;
    private MenuListaDupla menuListaDupla;
    private MenuAVL menuAVL;
    private MenuBST menuBST;
    private MenuArvoreB menuArvoreB;


    public MenuPrincipal() {
        scanner = new Scanner(System.in);

        menuPilha = new MenuPilha(scanner);
        menuFila = new MenuFila(scanner);
        menuLista = new MenuListaEncadeada(scanner);
        menuListaDupla = new MenuListaDupla(scanner);
        menuBST = new MenuBST(scanner);
        menuAVL = new MenuAVL(scanner);
    }

    //Inicia o menu principal da aplicação.
    public void abrir() {

        int opcao;

        do {

            exibirMenu();

            opcao = ConsoleUtil.lerInt(scanner, "Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    menuPilha.iniciar();
                    break;

                case 2:
                    menuFila.iniciar();
                    break;

                case 3:
                    menuLista.iniciar();
                    break;

                case 4:
                    menuListaDupla.abrir();
                    break;

                case 5:
                    menuBST.abrir();
                    break;

                case 6:
                    menuAVL.iniciar();
                    break;

                case 7:
                    menuArvoreB = new MenuArvoreB(scanner);
                    menuArvoreB.abrir();
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida.");

            }

        } while (opcao != 0);

        scanner.close();

    }

     //Exibe as opções do menu principal
    private void exibirMenu() {

        System.out.println("\n======================================");
        System.out.println(" BIBLIOTECA DE ESTRUTURAS DE DADOS");
        System.out.println("======================================");
        System.out.println("1 - Pilha");
        System.out.println("2 - Fila");
        System.out.println("3 - Lista Encadeada");
        System.out.println("4 - Lista Dupla");
        System.out.println("5 - BST");
        System.out.println("6 - AVL");
        System.out.println("7 - Árvore B");
        System.out.println("0 - Encerrar");
        System.out.println("======================================");

    }


}
