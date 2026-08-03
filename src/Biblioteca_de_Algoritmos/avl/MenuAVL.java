package Biblioteca_de_Algoritmos.avl;

import Biblioteca_de_Algoritmos.arvoreBST.BTNode;

import java.util.Scanner;
import java.util.Arrays;

//Classe responsável pelo menu da Árvore AVL
//Permiti o usuário executar as operações disponíveis
public class MenuAVL {

    private AVL<Integer> avl; //Árvore avl manipulada pelo menu
    private Scanner scanner; //Scanner para a leitura do teclado

    public MenuAVL(Scanner scanner) {
        avl = new AVL<>();
        this.scanner = scanner;
    }

    //Inicia o menu principal da avl
    public void iniciar() {

        int opcao;

        do {
            exibirMenu();

            System.out.println("Escolha uma opção: ");
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
                    mostrarPreOrdem();
                    break;
                case 5:
                    mostrarEmOrdem();
                    break;
                case 6:
                    mostrarPosOrdem();
                    break;
                case 7:
                    mostrarAltura();
                    break;
                case 8:
                    mostrarTamanho();
                    break;
                case 9:
                    mostrarRaiz();
                    break;
                default:
                    System.out.println("\nOpcao inválida!");
            }

        } while (opcao != 0);
    }

    public void exibirMenu() {

        System.out.println("\n=================================");
        System.out.println("          MENU AVL");
        System.out.println("=================================");
        System.out.println("1 - Inserir elemento");
        System.out.println("2 - Remover elemento");
        System.out.println("3 - Pesquisar elemento");
        System.out.println("4 - Mostrar Pré-Ordem");
        System.out.println("5 - Mostrar Em-Ordem");
        System.out.println("6 - Mostrar Pós-Ordem");
        System.out.println("7 - Mostrar Altura");
        System.out.println("8 - Mostrar Tamanho");
        System.out.println("9 - Mostrar Raiz");
        System.out.println("0 - Voltar");
        System.out.println("=================================");

    }

    //Inseri o novo elemento na avl
    public void inserir() {

        System.out.println("\n======== INSERIR ========");

        //Lê o valor informado pelo usuário
        System.out.println("Digite o valor que deseja inserir: ");
        int valor = scanner.nextInt();

        //Verificar se o valor já exite na árvore
        if (avl.search(valor) != null) {
            System.out.println("\nO valor " + valor + " já existe na árvore.");
        } else {
            //Insere o novo elemento
            avl.insert(valor);
            System.out.println("\nValor inserido com sucesso!");
        }

    }

    public void remover() {

        System.out.println("\n======== REMOVER ========");

        //Lê o valor informado
        System.out.println("Digite o valor que deseja remove: ");
        int valor = scanner.nextInt();

        //Verifica se o elemento existe
        if (avl.search(valor) == null ) {
            System.out.println("\nValor não encontrado.");
        } else {
            //Remove o elemento
            avl.remove(valor);
            System.out.println("\nValor removido com sucesso!");
        }
    }

    public void pesquisar() {

        System.out.println("\n======== PESQUISAR ========");

        //Lê o valor informado pelo usuário
        System.out.println("Digite o valor que deseja pesquisar: ");
        int valor = scanner.nextInt();

        //Procura o elemento na árvore
        BTNode<Integer> resultado = avl.search(valor);

        //Exibe o resultado da pesquisa
        if (resultado == null) {
            System.out.println("\nValor não encontrado.");
        } else {
            System.out.println("\nValor encontrado:" + resultado.getValue());
        }
    }

    //Exibe os elementos da árvore m Pré-Ordem
    public void mostrarPreOrdem() {

        System.out.println("\n======== PRÉ-ORDEM ========");

        //Obtém os elementos da árvore em Pré-Ordem
        Integer[] elementos = avl.preOrder();

        //Verificar se a árvore está vazia
        if (elementos.length == 0) {
            System.out.println("A árvore está vazia");
        } else {
            System.out.println(Arrays.toString(elementos));
        }
    }

    public void mostrarEmOrdem() {

        System.out.println("\n======== EM-ORDEM ========");

        //Obtém os elementos em ordem
        Integer[] elementos = avl.order();
        //Verificar se a árvore está vazia
        if (elementos.length == 0) {
            System.out.println("A árvore está vazia");
        } else {
            System.out.println(Arrays.toString(elementos));
        }
    }

    //Exibe os elementos da árvore em Pós-Ordem
    public void mostrarPosOrdem() {

        System.out.println("\n======== PÓS-ORDEM ========");

        //Obtém os elementos da árvore em Pós-Ordem
        Integer[] elementos = avl.postOrder();
        //Verifica se a árvore está vazia
        if (elementos.length == 0) {
            System.out.println("A árvore está vazia");
        } else {
            System.out.println(Arrays.toString(elementos));
        }
    }

    //Exibe a altura da Árvore AVL
    public void mostrarAltura() {

        System.out.println("\n======== ALTURA ========");
        //Obtém a altura da árvore
        int altura  = avl.height();

        System.out.println("Altura da árvore: " + altura);

    }

    //Exibe a quantidade de elementos presentes
    public void mostrarTamanho() {

        System.out.println("\n======== TAMANHO ========");

        //Obtém a quantidade de elementos da árvore
        int tamanho = avl.size();

        System.out.println("Quantidade de elementos: " + tamanho);
    }

    public void mostrarRaiz() {

        System.out.println("\n======== RAIZ ========");
        //Obtém a raiz da árvore
        BTNode<Integer> raiz = avl.getRoot();
        //Verifica se a árvore etá vazia
        if (raiz == null) {
            System.out.println("A árvore está vazia");
        } else {
            System.out.println("Raiz da árvore: " + raiz.getValue()); //para acessar o valor armazenado no nó
        }
    }

}
