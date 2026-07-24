package Biblioteca_de_Algoritmos.interfaces;

/**
 * Interface para Lista Simplesmente Encadeada (Parte 3 do projeto).
 */
public interface LinkedList<T> {
    public boolean isEmpty();
    public int size();
    public T search(T element);
    public void insert(T element);
    public void remove(T element);
    public T[] toArray();
}
