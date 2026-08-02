package Biblioteca_de_Algoritmos.interfaces;

// Interface que define as operações básicas
// de uma Lista Duplamente Encadeada.
public interface DoubleLinkedList<T> {

    // Verifica se a lista está vazia.
    public boolean isEmpty();

    // Retorna a quantidade de elementos da lista.
    public int size();

    // Procura um elemento na lista.
    public T search(T element);

    // Insere um elemento no final da lista.
    public void insert(T element);

    // Remove um elemento da lista.
    public void remove(T element);

    // Retorna todos os elementos da lista em um vetor.
    public T[] toArray();

    // Insere um elemento no início da lista.
    public void insertFirst(T element);

    // Remove o primeiro elemento da lista.
    public void removeFirst();

    // Remove o último elemento da lista.
    public void removeLast();
}