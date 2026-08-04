package Biblioteca_de_Algoritmos.listaEncadeada;

import java.util.Scanner;

public class MenuListaEncadeada {

    private ListaEncadeada<Integer> lista; //Lista manipulada pelo menu
    private Scanner scanner;

    public MenuListaEncadeada(Scanner scanner) {
        this.scanner = scanner;
        lista = new ListaEncadeada<>();
    }
    //Iniciar o menu da lista encadeada
    public void iniciar() {
        int opcao;
        do {
            exibirMenu();

            System.out.println("Escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inserir();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    pesquisar();
                    break;
                case 4:
                    mostrarElementos();
                    break;
                case 5:
                    mostrarTamanho();
                    break;
                case 6:
                    verificarVazia();
                    break;
                case 0:
                    System.out.println("\nRetornando ao menu principal...");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
            }
        } while(opcao != 0);
    }

    //Exibi as opções disponíveis no menu
    private void exibirMenu() {
        System.out.println("\n=================================");
        System.out.println("   MENU LISTA ENCADEADA");
        System.out.println("=================================");
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Pesquisar");
        System.out.println("4 - Mostrar elementos");
        System.out.println("5 - Mostrar tamanho");
        System.out.println("6 - Verificar se está vazia");
        System.out.println("0 - Voltar");
        System.out.println("=================================");
    }

    //Inseri um novo elemento na lista encadeada
    private void inserir() {

        System.out.println("\n========== INSERIR ELEMENTO ==========");

        //Solicita o valor ao usuário
        System.out.println("Digite o valor: ");
        int valor = scanner.nextInt();

        //Inseri=e o elemento na lista
        lista.insert(valor);

        System.out.println("Elemento inserido com sucesso!");
    }

    //Remove um elemento da lista encadeada
    private void remover() {
        System.out.println("\n========== REMOVER ELEMENTO ==========");

        //Solicita o valor que será removido
        System.out.println("Digite o valor: ");
        int valor = scanner.nextInt();

        //Verifica se o elemento existe na lista
        if (lista.search(valor) == null) {
            System.out.println("Elemento não encontrado");
            return;
        }
        //Remove o elemento da lista
        lista.remove(valor);
        System.out.println("Elemento removido com sucesso!");
    }
    //Pesquisa um elemento na lista encadeada
    private void pesquisar() {
        System.out.println("\n======== PESQUISAR ELEMENTO =========");
        //Solicita o valor que será pesquisado
        System.out.println("Digite o valor: ");
        int valor = scanner.nextInt();

        //Procura o elemento na lista
        Integer encontrado = lista.search(valor);

        if(encontrado != null) {
            System.out.println("Elemento encontrado: " + encontrado);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }
    //Exibe os elementos armazenados na lsita encadeada
    private void mostrarElementos() {

        System.out.println("\n========== ELEMENTOS DA LISTA ==========");

        //Verificar se a lista está vazia
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia");
            return;
        }

        //Obtém todos os elementos da lista em um vetor
        Integer[] elementos = lista.toArray();

        System.out.print("Lista: ");
        //Percorre o vetor e imprime cada elemento
        for (Integer elemento : elementos) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
    //Exibe a quantidade de elementos presentes na lista
    private void mostrarTamanho() {
        System.out.println("\n======== TAMANHO DA LISTA =========");

        //Exibe a quantidade de elementos da lista
        System.out.println("Quantidade de elementos: " + lista.size());
    }
    //Verificar se a lista encadeada está vazia
    private void verificarVazia() {

        System.out.println("\n========== LISTA VAZIA ==========");
        //Verifica se a lista está vazia
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println("A lista NÃO está vazia.");
        }
    }
}
