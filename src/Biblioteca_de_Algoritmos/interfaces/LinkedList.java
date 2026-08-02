package Biblioteca_de_Algoritmos.interfaces;

public interface LinkedList<T> {

    public boolean isEmpty();

    public int size();

    public T search(T elemento);

    public void insert(T elemento);

    public void remove(T elemento);

    public T[] toArray();
}
