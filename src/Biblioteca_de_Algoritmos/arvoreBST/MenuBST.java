package Biblioteca_de_Algoritmos.arvoreBST;

import Biblioteca_de_Algoritmos.projeto.ConsoleUtil;

import java.util.Scanner;

public class MenuBST {

    private Scanner scanner;
    private BST<Integer> bst;

    public MenuBST(Scanner scanner) {
        this.scanner = scanner;
        this.bst = new BST<>();
    }

    public void abrir() {
        int opcao;
        do {
            System.out.println("\n----- ÁRVORE BINÁRIA DE BUSCA (BST) -----");
            System.out.println("1 - insert");
            System.out.println("2 - remove");
            System.out.println("3 - search");
            System.out.println("4 - isEmpty");
            System.out.println("5 - height");
            System.out.println("6 - size");
            System.out.println("7 - pre-Ordem");
            System.out.println("8 - em ordem");
            System.out.println("9 - pós-Ordem");
            System.out.println("0 - Voltar");
            opcao = ConsoleUtil.lerInt(scanner, "Escolha uma opção: ");

            try {
                switch (opcao) {
                    case 1:
                        int valorInsert = ConsoleUtil.lerInt(scanner, "Valor para inserir: ");
                        bst.insert(valorInsert);
                        System.out.println("Elemento inserido.");
                        break;
                    case 2:
                        int valorRemove = ConsoleUtil.lerInt(scanner, "Valor a remover: ");
                        bst.remove(valorRemove);
                        System.out.println("Remoção realizada (se o valor existia).");
                        break;
                    case 3:
                        int valorSearch = ConsoleUtil.lerInt(scanner, "Valor a buscar: ");
                        BTNode<Integer> resultado = bst.search(valorSearch);
                        System.out.println(resultado != null ? "Encontrado: " + resultado.getValue() : "Não encontrado.");
                        break;
                    case 4:
                        System.out.println("A árvore está vazia? " + bst.isEmpty());
                        break;
                    case 5:
                        System.out.println("Altura da árvore: " + bst.height());
                        break;
                    case 6:
                        System.out.println("Quantidade de elementos: " + bst.size());
                        break;
                    case 7:
                        imprimirArray("Pré-ordem", bst.preOrder());
                        break;
                    case 8:
                        imprimirArray("Em-ordem", bst.order());
                        break;
                    case 9:
                        imprimirArray("Pós-ordem", bst.postOrder());
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

    private void imprimirArray(String rotulo, Object[] array) {
        StringBuilder sb = new StringBuilder(rotulo + ": [");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
