package Biblioteca_de_Algoritmos.interfaces;

//
//Interface para Árvore Binária de Busca (Parte 5 do projeto).

public interface BT<T> {
    public BTNode<T> getRoot();
    public boolean isEmpty();
    public int height();
    public BTNode<T> search(T elem);
    public void insert(T value);
    public void remove(T key);
    public T[] preOrder();
    public T[] order();
    public T[] postOrder();
    public int size();
}
