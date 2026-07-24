package Biblioteca_de_Algoritmos.listadupla;



import Biblioteca_de_Algoritmos.interfaces.DoubleLinkedList;

import java.util.ArrayList;



/**

 * Lista Encadeada dupla.

 * Implementação propria(sem usar java.util.LinkedList).

 */

public class ListaEncadeadaDupla<T> implements DoubleLinkedList<T> {



    /** Nó interno da lista dupla. */

    private static class Node<T> {

        T dado;

        Node<T> anterior;

        Node<T> proximo;



        Node(T dado) {

            this.dado = dado;

            this.anterior = null;

            this.proximo = null;

        }

    }



    private Node<T> inicio;

    private Node<T> fim;

    private int tamanho;



    public ListaEncadeadaDupla() {

        this.inicio = null;

        this.fim = null;

        this.tamanho = 0;

    }



    @Override

    public boolean isEmpty() {

        return inicio == null;

    }



    @Override

    public int size() {

        return tamanho;

    }



    @Override

    public T search(T element) {

        Node<T> atual = inicio;

        while (atual != null) {

            if (atual.dado.equals(element)) {

                return atual.dado;

            }

            atual = atual.proximo;

        }

        return null;

    }



    /** Insere o elemento no final da lista. */

    @Override

    public void insert(T element) {

        Node<T> novo = new Node<>(element);

        if (isEmpty()) {

            inicio = novo;

            fim = novo;

        } else {

            novo.anterior = fim;

            fim.proximo = novo;

            fim = novo;

        }

        tamanho++;

    }



    @Override

    public void insertFirst(T element) {

        Node<T> novo = new Node<>(element);

        if (isEmpty()) {

            inicio = novo;

            fim = novo;

        } else {

            novo.proximo = inicio;

            inicio.anterior = novo;

            inicio = novo;

        }

        tamanho++;

    }



    @Override

    public void removeFirst() {

        if (isEmpty()) {

            return;

        }

        inicio = inicio.proximo;

        if (inicio != null) {

            inicio.anterior = null;

        } else {

            fim = null;

        }

        tamanho--;

    }



    @Override

    public void removeLast() {

        if (isEmpty()) {

            return;

        }

        fim = fim.anterior;

        if (fim != null) {

            fim.proximo = null;

        } else {

            inicio = null;

        }

        tamanho--;

    }



    @Override

    public void remove(T element) {

        Node<T> atual = inicio;

        while (atual != null) {

            if (atual.dado.equals(element)) {

                if (atual == inicio) {

                    removeFirst();

                } else if (atual == fim) {

                    removeLast();

                } else {

                    atual.anterior.proximo = atual.proximo;

                    atual.proximo.anterior = atual.anterior;

                    tamanho--;

                }

                return;

            }

            atual = atual.proximo;

        }

    }

    @Override

    public T[] toArray() {

        ArrayList<T> lista = new ArrayList<>();

        Node<T> atual = inicio;

        while (atual != null) {

            lista.add(atual.dado);

            atual = atual.proximo;

        }

        if (lista.isEmpty()) {

            return (T[]) new Object[0];

        }

        // Usa reflection para criar um vetor com o tipo real dos elementos

        // (ex.: Integer[]), evitando ClassCastException no código que chama.

        T[] array = (T[]) java.lang.reflect.Array.newInstance(lista.get(0).getClass(), lista.size());

        for (int i = 0; i < lista.size(); i++) {

            array[i] = lista.get(i);

        }

        return array;

    }


    @Override

    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        Node<T> atual = inicio;

        while (atual != null) {

            sb.append(atual.dado);

            if (atual.proximo != null) sb.append(" <-> ");

            atual = atual.proximo;

        }

        sb.append("]");

        return sb.toString();

    }

}