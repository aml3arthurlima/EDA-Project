package Biblioteca_de_Algoritmos.interfaces;

// Interface que define as operações básicas
// de uma Árvore Binária.
public interface BT<T> {

    // Retorna o nó raiz da árvore.
    public BTNode<T> getRoot();

    // Verifica se a árvore está vazia.
    public boolean isEmpty();

    // Retorna a altura da árvore.
    public int height();

    // Procura um elemento na árvore.
    public BTNode<T> search(T elem);

    // Insere um novo elemento na árvore.
    public void insert(T value);

    // Remove um elemento da árvore.
    public void remove(T key);

    // Retorna os elementos em pré-ordem.
    public T[] preOrder();

    // Retorna os elementos em ordem (in-order).
    public T[] order();

    // Retorna os elementos em pós-ordem.
    public T[] postOrder();

    // Retorna a quantidade de elementos da árvore.
    public int size();
}