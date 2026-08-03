package Biblioteca_de_Algoritmos.fila;

import java.util.Scanner;

public class MenuFila {

    private Fila<Integer> fila;
    private Scanner scanner;

    public MenuFila(Scanner scanner) {

        fila = null;
        this.scanner = scanner;
    }

    //Inicia o menu fila
    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            //Lê a opções escolhidas pelo usuário
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            //Executa a operação correspondente
            switch (opcao) {
                case 1:
                    criarFila();
                    break;
                case 2:
                    enfileirar();
                    break;
                case 3:
                    desenfileirar();
                    break;
                case 4:
                    mostrarInicio();
                    break;
                case 5:
                    verificarVazia();
                    break;
                case 6:
                    verificarCheia();
                    break;
                case 0:
                    System.out.println("\nRetornando ao menu principal...");
                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (opcao != 0);
    }
    //Exibi as opções de menu da fila
    private void exibirMenu(){


        System.out.println("\n=================================");
        System.out.println("           MENU FILA");
        System.out.println("=================================");
        System.out.println("1 - Criar Fila");
        System.out.println("2 - Enfileirar (Enqueue)");
        System.out.println("3 - Desenfileirar (Dequeue)");
        System.out.println("4 - Mostrar Início (Head)");
        System.out.println("5 - Verificar se está vazia");
        System.out.println("6 - Verificar se está cheia");
        System.out.println("0 - Voltar");
        System.out.println("=================================");
    }

    //Cria uma nova fila
    //Usuário informa capacidade máxima da fila
    //Caso já exista uma fila criada, ela será substituida
    private void  criarFila() {
        System.out.println("\n======== CRIAR FILA ========");

        //Solicitar a capacidade da fila
        System.out.println("Informe a capacidade da fila: ");
        int capacidade = scanner.nextInt();

        //Cria uma nova fila com a capacidade informada
        fila = new Fila<>(capacidade);

        System.out.println("\nFila criada com sucesso!");
    }

    //Inseri um novo elemento no final da fila
    //Antes da inserção, verifica se a fila foi criada.
    //Caso a fila esteja cheia, a exceção lançada pela
        //classe Fila será capturada e exibida ao usuário.
    private void enfileirar() {
        System.out.println("\n========== ENQUEUE ==========");

        //Verfica se a fila foi criada
        if (fila == null) {
            System.out.println("Crie a fila primeiro");
            return;
        }
        //Solicita o valor ao usuário
        System.out.println("Digite o valor: ");
        int valor = scanner.nextInt();

        try {
            //Insere o elemento no final da fila
            fila.enqueue(valor);
            System.out.println("Elemento inserido com sucesso!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    //Remove o primeiro elemento da fila
    //Antes da remoção, verifica se a fila foi criada.
    //Caso a fila esteja vazia, a exceção lançada pela
    //classe Fila será capturada e exibida ao usuário.
    private void desenfileirar() {
        System.out.println("\n========== DEQUEUE ==========");
        //Verifica se a fila criada
        if (fila == null) {
            System.out.println("Crie a fila primeiro.");
            return;
        }

        try {
            //Remove o primeiro elemento da fila
            Integer removido = fila.dequeue();
            System.out.println("Elemento removido: " + removido);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    //Exibe o primeiro elemento da fila
    private void mostrarInicio() {
        System.out.println("\n========== INÍCIO DA FILA ==========");

        //Verifica se a fila foi criada
        if (fila == null) {
            System.out.println("Crie a fila primeiro.");
            return;
        }

        try {
            //Obtém o primeiro elemento da fila
            Integer inicio = fila.head();
            System.out.println("Primeiro element da fila: " + inicio);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    //Verifica se a fila está vazia
    private void verificarVazia() {
        System.out.println("\n========== FILA VAZIA ==========");

        //Verifica se a fila foi criada
        if (fila == null) {
            System.out.println("Crie a fila primeio.");
            return;
        }
        //Verifica se a fila está vazia
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("A fila NÃO está vazia.");
        }
    }
    //Verifica se a fila está cheia
    private void verificarCheia() {
        System.out.println("\n========== FILA CHEIA==========");

        //Verifica se a fila foi criada
        if (fila == null) {
            System.out.println("Crie a fila primeio.");
            return;
        }
        //Verifica se a fila está cheia
        if (fila.isFull()) {
            System.out.println("A fila está cheia.");
        } else {
            System.out.println("A fila NÃO está cheia.");
        }
    }
}
