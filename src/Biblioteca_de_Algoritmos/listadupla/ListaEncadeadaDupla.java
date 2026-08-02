package Biblioteca_de_Algoritmos.listadupla;

import Biblioteca_de_Algoritmos.interfaces.DoubleLinkedList;
import java.util.ArrayList;

// Implementação de uma Lista Duplamente Encadeada.
public class ListaEncadeadaDupla<T> implements DoubleLinkedList<T> {

    // Classe interna que representa um nó da lista.
    private static class Node<T> {

        // Armazena o valor do nó.
        T dado;

        // Referência para o nó anterior.
        Node<T> anterior;

        // Referência para o próximo nó.
        Node<T> proximo;

        // Cria um novo nó da lista.
        Node(T dado) {

            // Armazena o elemento recebido.
            this.dado = dado;

            // Inicializa o nó anterior.
            this.anterior = null;

            // Inicializa o próximo nó.
            this.proximo = null;
        }
    }

    // Referência para o primeiro nó da lista.
    private Node<T> inicio;

    // Referência para o último nó da lista.
    private Node<T> fim;

    // Quantidade de elementos da lista.
    private int tamanho;

    // Cria uma lista vazia.
    public ListaEncadeadaDupla() {

        // Inicializa o início da lista.
        this.inicio = null;

        // Inicializa o fim da lista.
        this.fim = null;

        // Inicializa a quantidade de elementos.
        this.tamanho = 0;
    }

    // Verifica se a lista está vazia.
    @Override
    public boolean isEmpty() {
        return inicio == null;
    }

    // Retorna a quantidade de elementos da lista.
    @Override
    public int size() {
        return tamanho;
    }

    // Procura um elemento na lista.
    @Override
    public T search(T element) {

        // Começa a busca pelo primeiro nó.
        Node<T> atual = inicio;

        // Percorre toda a lista.
        while (atual != null) {

            // Verifica se encontrou o elemento.
            if (atual.dado.equals(element)) {
                return atual.dado;
            }

            // Avança para o próximo nó.
            atual = atual.proximo;
        }

        // Retorna nulo caso o elemento não exista.
        return null;
    }

    // Insere um elemento no final da lista.
    @Override
    public void insert(T element) {

        // Cria um novo nó.
        Node<T> novo = new Node<>(element);

        // Verifica se a lista está vazia.
        if (isEmpty()) {

            // O novo nó será o início e o fim.
            inicio = novo;
            fim = novo;

        } else {

            // Liga o novo nó ao último elemento.
            novo.anterior = fim;

            // O último nó passa a apontar para o novo.
            fim.proximo = novo;

            // Atualiza o fim da lista.
            fim = novo;
        }

        // Incrementa a quantidade de elementos.
        tamanho++;
    }

    // Insere um elemento no início da lista.
    @Override
    public void insertFirst(T element) {

        // Cria um novo nó.
        Node<T> novo = new Node<>(element);

        // Verifica se a lista está vazia.
        if (isEmpty()) {

            // O novo nó será o início e o fim.
            inicio = novo;
            fim = novo;

        } else {

            // Liga o novo nó ao antigo início.
            novo.proximo = inicio;

            // O antigo início aponta para o novo.
            inicio.anterior = novo;

            // Atualiza o início da lista.
            inicio = novo;
        }

        // Incrementa a quantidade de elementos.
        tamanho++;
    }

    // Remove o primeiro elemento da lista.
    @Override
    public void removeFirst() {

        // Verifica se a lista está vazia.
        if (isEmpty()) {
            return;
        }

        // Avança o início para o próximo nó.
        inicio = inicio.proximo;

        // Verifica se ainda existem elementos.
        if (inicio != null) {

            // Remove a referência para o nó anterior.
            inicio.anterior = null;

        } else {

            // Se a lista ficou vazia,
            // o fim também passa a ser nulo.
            fim = null;
        }

        // Decrementa a quantidade de elementos.
        tamanho--;
    }

    // Remove o último elemento da lista.
    @Override
    public void removeLast() {

        // Verifica se a lista está vazia.
        if (isEmpty()) {
            return;
        }

        // Move o fim para o nó anterior.
        fim = fim.anterior;

        // Verifica se ainda existem elementos.
        if (fim != null) {

            // Remove a referência para o próximo nó.
            fim.proximo = null;

        } else {

            // Se a lista ficou vazia,
            // o início também passa a ser nulo.
            inicio = null;
        }

        // Decrementa a quantidade de elementos.
        tamanho--;
    }

    // Remove um elemento específico da lista.
    @Override
    public void remove(T element) {

        // Começa a busca pelo primeiro nó.
        Node<T> atual = inicio;

        // Percorre toda a lista.
        while (atual != null) {

            // Verifica se encontrou o elemento.
            if (atual.dado.equals(element)) {

                // Se for o primeiro nó.
                if (atual == inicio) {

                    removeFirst();

                    // Se for o último nó.
                } else if (atual == fim) {

                    removeLast();

                } else {

                    // Liga o nó anterior ao próximo.
                    atual.anterior.proximo = atual.proximo;

                    // Liga o próximo ao nó anterior.
                    atual.proximo.anterior = atual.anterior;

                    // Atualiza a quantidade de elementos.
                    tamanho--;
                }

                return;
            }

            // Avança para o próximo nó.
            atual = atual.proximo;
        }
    }

    // Converte a lista em um vetor.
    @Override
    public T[] toArray() {

        // Cria uma lista auxiliar.
        ArrayList<T> lista = new ArrayList<>();

        // Começa pelo primeiro nó.
        Node<T> atual = inicio;

        // Copia todos os elementos.
        while (atual != null) {

            lista.add(atual.dado);

            atual = atual.proximo;
        }

        // Retorna um vetor vazio caso a lista esteja vazia.
        if (lista.isEmpty()) {
            return (T[]) new Object[0];
        }

        // Cria um vetor do mesmo tipo dos elementos.
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                lista.get(0).getClass(),
                lista.size()
        );

        // Copia os elementos para o vetor.
        for (int i = 0; i < lista.size(); i++) {
            array[i] = lista.get(i);
        }

        // Retorna o vetor.
        return array;
    }

    // Retorna a lista em formato de texto.
    @Override
    public String toString() {

        // Cria a representação da lista.
        StringBuilder sb = new StringBuilder("[");

        // Começa pelo primeiro nó.
        Node<T> atual = inicio;

        // Percorre toda a lista.
        while (atual != null) {

            // Adiciona o elemento.
            sb.append(atual.dado);

            // Adiciona o símbolo entre os nós.
            if (atual.proximo != null) {
                sb.append(" <-> ");
            }

            // Avança para o próximo nó.
            atual = atual.proximo;
        }

        // Fecha a representação.
        sb.append("]");

        // Retorna a lista em formato de texto.
        return sb.toString();
    }
}