package Biblioteca_de_Algoritmos.listaEncadeada;

import Biblioteca_de_Algoritmos.interfaces.LinkedList;

public class ListaEncadeada<T> implements LinkedList<T>{

    private No<T> head;
    private int tamanho;

    public ListaEncadeada() {
        head = null;
        tamanho = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public T search(T elemento) {
        //Começa a busca pelo primeiro nó
        No<T> atual = head;
        //Percorre a lista até encontrar o elemento ou chegar ao final
        while (atual != null) {

            if (atual.dado.equals(elemento)) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }

    @Override
    public void insert(T elemento) {

        No<T> novo = new No<>(elemento);

        //Se a lista estiver vazia, o novo nó será o primeiro
        if (isEmpty()) {
            head = novo;
        } else {
            //Percorrer até o último nó
            No<T> atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo; //Liga o último nó ao novo
        }
        tamanho++;
    }

    @Override
    public void remove(T elemento) {

        if (isEmpty()) {
            return;
        }
        //Caso o elemento esteja no primeiro nó
        if (head.dado.equals(elemento)) {
            head = head.proximo;
            tamanho--;
            return;
        }

        No<T> anterior = head;
        No<T> atual = head.proximo;

        //Procure o elemento na lista
        while (atual != null ) {
            if(atual.dado.equals(elemento)) {
                //Remove o nó ligado o anterior ao próximo
                anterior.proximo = atual.proximo;
                tamanho--;
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }


    @Override
    @SuppressWarnings("unchecked") //Oculta o aviso do cast para vetor genérico
    public T[] toArray() {

        T[] vetor = (T[]) new Object[tamanho];
        No<T> atual = head;
        int i = 0;

        //Copia todos os elementos da lista para o vetor
        while (atual != null) {
            vetor[i] = atual.dado;
            atual = atual.proximo;
            i++;
        }
        return vetor;
    }
}
