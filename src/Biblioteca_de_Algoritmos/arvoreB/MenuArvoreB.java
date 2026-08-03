package Biblioteca_de_Algoritmos.arvoreB;

import Biblioteca_de_Algoritmos.projeto.ConsoleUtil;

import java.util.Scanner;

public class MenuArvoreB {

    private Scanner scanner;
    private ArvoreB<Integer> arvoreB;

    public MenuArvoreB(Scanner scanner) {

        this.scanner = scanner;

        // Solicita o grau mínimo da árvore até que seja válido.
        while (true) {

            try {

                int grau = ConsoleUtil.lerInt(scanner,
                        "Digite o grau mínimo da Árvore B (>= 2): ");

                this.arvoreB = new ArvoreB<>(grau);

                System.out.println("Árvore B criada com sucesso!");
                break;

            } catch (IllegalArgumentException e) {

                System.out.println("Erro: " + e.getMessage());
                System.out.println("Digite um valor válido.\n");

            }
        }
    }

    public void abrir() {

        int opcao;

        do {

            System.out.println("\n----- ÁRVORE B -----");
            System.out.println("1 - insert");
            System.out.println("2 - search");
            System.out.println("3 - height");
            System.out.println("4 - size");
            System.out.println("5 - printLevels (imprimir por nível)");
            System.out.println("6 - Demonstração automática");
            System.out.println("7 - Criar nova Árvore B");
            System.out.println("0 - Voltar");

            opcao = ConsoleUtil.lerInt(scanner, "Escolha uma opção: ");

            try {

                switch (opcao) {

                    case 1:

                        int valorInsert =
                                ConsoleUtil.lerInt(scanner,
                                        "Valor para inserir: ");

                        arvoreB.insert(valorInsert);

                        System.out.println("Elemento inserido com sucesso.");
                        break;

                    case 2:

                        int valorSearch =
                                ConsoleUtil.lerInt(scanner,
                                        "Valor para buscar: ");

                        if (arvoreB.search(valorSearch)) {

                            System.out.println("Elemento encontrado.");

                        } else {

                            System.out.println("Elemento não encontrado.");
                        }

                        break;

                    case 3:

                        System.out.println("Altura da árvore: "
                                + arvoreB.height());

                        break;

                    case 4:

                        System.out.println("Quantidade de elementos: "
                                + arvoreB.size());

                        break;

                    case 5:

                        arvoreB.printLevels();

                        break;

                    case 6:

                        demonstracaoAutomatica();

                        break;

                    case 7:

                        try {

                            int grau =
                                    ConsoleUtil.lerInt(scanner,
                                            "Novo grau mínimo (>=2): ");

                            arvoreB = new ArvoreB<>(grau);

                            System.out.println("Nova Árvore B criada com sucesso!");

                        } catch (IllegalArgumentException e) {

                            System.out.println("Erro: "
                                    + e.getMessage());

                        }

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

    private void demonstracaoAutomatica() {

        System.out.println("\n--- Demonstração automática da Árvore B ---");

        System.out.println("\nConjunto de dados 1:");

        ArvoreB<Integer> arv1 = new ArvoreB<>(3);

        int[] dados1 = {
                10,20,30,40,50,60,70,80,90
        };

        for (int v : dados1) {

            arv1.insert(v);
        }

        arv1.printLevels();

        System.out.println("Altura: " + arv1.height());
        System.out.println("Quantidade de elementos: " + arv1.size());
        System.out.println("search(45): " + arv1.search(45));
        System.out.println("search(60): " + arv1.search(60));

        System.out.println("\nConjunto de dados 2:");

        ArvoreB<Integer> arv2 = new ArvoreB<>(3);

        int[] dados2 = {
                5,12,3,18,27,9,1,15,22,30,6
        };

        for (int v : dados2) {

            arv2.insert(v);
        }

        arv2.printLevels();

        System.out.println("Altura: " + arv2.height());
        System.out.println("Quantidade de elementos: " + arv2.size());
    }
}