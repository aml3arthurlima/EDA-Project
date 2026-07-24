package Biblioteca_de_Algoritmos.projeto;

import Biblioteca_de_Algoritmos.listadupla.ListaEncadeadaDupla;

import java.util.Scanner;

public class MenuListaDupla {

    private Scanner scanner;
    private ListaEncadeadaDupla<Integer> lista;

    public MenuListaDupla(Scanner scanner) {
        this.scanner = scanner;
        this.lista = new ListaEncadeadaDupla<>();
    }

    public void abrir() {
        int opcao;
        do {
            System.out.println("\n----- LISTA DUPLAMENTE ENCADEADA -----");
            System.out.println("Estado atual: " + lista);
            System.out.println("1 - insert (inserir no final)");
            System.out.println("2 - insertFirst (inserir no início)");
            System.out.println("3 - removeFirst");
            System.out.println("4 - removeLast");
            System.out.println("5 - remove (por valor)");
            System.out.println("6 - search");
            System.out.println("7 - isEmpty");
            System.out.println("8 - size");
            System.out.println("9 - toArray");
            System.out.println("0 - Voltar");
            opcao = ConsoleUtil.lerInt(scanner, "Escolha uma opção: ");

            try {
                switch (opcao) {
                    case 1:
                        int valorInsert = ConsoleUtil.lerInt(scanner, "Valor para inserir no final: ");
                        lista.insert(valorInsert);
                        System.out.println("Elemento inserido no final.");
                        break;
                    case 2:
                        int valorInsertFirst = ConsoleUtil.lerInt(scanner, "Valor para inserir no início: ");
                        lista.insertFirst(valorInsertFirst);
                        System.out.println("Elemento inserido no início.");
                        break;
                    case 3:
                        lista.removeFirst();
                        System.out.println("Primeiro elemento removido (se existia).");
                        break;
                    case 4:
                        lista.removeLast();
                        System.out.println("Último elemento removido (se existia).");
                        break;
                    case 5:
                        int valorRemove = ConsoleUtil.lerInt(scanner, "Valor a remover: ");
                        lista.remove(valorRemove);
                        System.out.println("Remoção realizada (se o valor existia).");
                        break;
                    case 6:
                        int valorSearch = ConsoleUtil.lerInt(scanner, "Valor a buscar: ");
                        Integer achado = lista.search(valorSearch);
                        System.out.println(achado != null ? "Encontrado: " + achado : "Não encontrado.");
                        break;
                    case 7:
                        System.out.println("A lista está vazia? " + lista.isEmpty());
                        break;
                    case 8:
                        System.out.println("Tamanho da lista: " + lista.size());
                        break;
                    case 9:
                        System.out.print("toArray() = [");
                        Object[] array = lista.toArray();
                        for (int i = 0; i < array.length; i++) {
                            System.out.print(array[i]);
                            if (i < array.length - 1) System.out.print(", ");
                        }
                        System.out.println("]");
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            if (opcao != 0) {
                ConsoleUtil.pausar(scanner);
            }
        } while (opcao != 0);
    }
}
