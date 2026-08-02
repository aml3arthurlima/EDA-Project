package Biblioteca_de_Algoritmos.pilha;

public class Pilha<T> {

    private T[] elementos;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.topo = -1; //Inicia a pilha vazia
        this.elementos = (T[]) new Object[capacidade]; //Cria um vetor generico a parti de um cast
        //criamos um vetor do tipo Object e fazemos a connversão para T[].
    }

    public boolean isEmpty() {//Verifica se a pilha tá vazia
        return topo == -1;
    }

    public boolean isFull() { //Verifica se a pilha tá cheia
        return topo == capacidade - 1;
    }

    public void push(T valor) { //Verifica e a pilha tá cheia e inseri o elemento no topo

        if (isFull()) {
            throw new RuntimeException("Pilha cheia");
            //faz o tratamento de exceção
        }

        topo++; //vai com o topo para o proximo índice do vetor
        elementos[topo] = valor; //adiciona o valor no topo da pilha
    }

    public T top() {//Mostra o topo da pilha

        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
            //tratamento de exceção, verifica se tá cheia a pilha
        }

        return elementos[topo]; //mostra o elemento
    }

    public T pop() { //Remove o elemento do topo

        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia"); //**
            //faz o tratamento de exceção, verifica se a pilha tá vazia
        }

        T valor = elementos[topo]; //guarda o valor no topo da pilha
        elementos[topo] = null; //limpa o topo, remove a referência
        topo--; //volta um íncice

        return valor;
    }
}
