package Biblioteca_de_Algoritmos.pilha;

import java.util.Scanner;

public class MenuPilha {

    private Pilha<Integer> pilha;
    private Scanner scanner;

    public MenuPilha(Scanner scanner) {
        this.scanner = scanner;
        //Não cria a pilha aqui
        pilha = null;
    }

    //Inicia o menu da Pilha
    //Exibi o menu até escolher a opção voltar
    public void iniciar () {

        int opcao;

        do {
            exibirMenu();

            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();

            switch(opcao){

                case 1:
                    criarPilha();
                    break;
                case 2:
                    empilhar();
                    break;
                case 3:
                    desempilhar();
                    break;
                case 4:
                    mostrarTopo();
                    break;
                case 5:
                    verificarVazia();
                    break;
                case 6:
                    verificarCheia();
                    break;
                case 0:
                    System.out.println("\nRetornando ao menu principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (opcao != 0);
    }

    public void exibirMenu()  {

        System.out.println("\n=================================");
        System.out.println("           MENU PILHA");
        System.out.println("=================================");
        System.out.println("1 - Criar Pilha");
        System.out.println("2 - Push (Empilhar)");
        System.out.println("3 - Pop (Desempilhar)");
        System.out.println("4 - Top (Mostrar topo)");
        System.out.println("5 - Verificar se está vazia");
        System.out.println("6 - Verificar se está cheia");
        System.out.println("0 - Voltar");
        System.out.println("=================================");
    }

    //Cria uma nova pilha
    public void criarPilha() {
        System.out.println("\n======== CRIAR PILHA ========");

        //Solicitar a capacidade da pilha
        System.out.println("Informe a capacidade da pilha: ");
        int capacidade = scanner.nextInt();

        //Cria uma nova pilha com a capacidade informada
        pilha = new Pilha<>(capacidade);

        System.out.println("\nPilha criada com sucesso!");
    }

    //Insere um novo elemento no topo da pilha
    //Antes de inserir verifica se a pilha foi criada
    //Caso a pilha esteja cheia, a exceção lançada pela
        //classe Pilha será capturada e exibida ao usuário
    public void empilhar() {

        System.out.println("\n======== PUSH ========");
        //Verifica se a pilha foi criada
        if (pilha == null) {
            System.out.println("Crie a pilha primeiro");
            return;
        }
        //Solicitar o valor ao usuário
        System.out.println("Digite o valor: ");
        int valor = scanner.nextInt();

        try {

            //Insere o elemento no topo da pilha
            pilha.push(valor);
            System.out.println("Elemento inserido com sucesso!");

        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    //Remove o elemento que está no topo da pilha
    public void desempilhar() {

        System.out.println("\n======== POP ========");

        //Verifica se a pilha foi criada
        if (pilha == null) {
            System.out.println("Crie a pilha primeiro.");
            return;
        }

        try {
            //Remover o elemento do topo
            Integer valor = pilha.pop();
            System.out.println("Elemento removido: " + valor);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    //Exibe o elemento que está no topo da pilha
    public void mostrarTopo() {

        System.out.println("\n======== TOPO DA PILHA =========");
        //Verifica se a pilha foi criada
        if (pilha == null) {
            System.out.println("Crie a pilha primeiro.");
            return;
        }

        try {
            //Obtém o elemento do topo da pilha
            Integer topo = pilha.top();

            System.out.println("Elemento do topo: " + topo);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    //Verifica se a pilha está vazia
    public void verificarVazia() {

        System.out.println("\n======== PILHA VAZIA ========");

        //Verificar se a pilha foi criada
        if (pilha == null) {
            System.out.println("Crie a pilha primeiro.");
            return;
        }
        //Verifique se a pilha está vazia
        if (pilha.isEmpty()) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("A pilha NÃO está vazia.");
        }
    }

    //Verifica se a pilha está cheia
    public void verificarCheia() {

        System.out.println("\n======== PILHA CHEIA ========");
        //Verifica se a pilha foi criada
        if (pilha == null) {
            System.out.println("Crie a pilha primeiro");
            return;
        }
        //Verifica se a pilha está cheia
        if (pilha.isFull()) {
            System.out.println("A pilha está cheia.");
        } else {
            System.out.println("A pilha NÃO está cheia.");
        }

    }

}
