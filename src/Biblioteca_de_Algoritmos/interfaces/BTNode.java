package Biblioteca_de_Algoritmos.interfaces;

/**
 * Nó genérico utilizado pela BST e pela AVL.
 * Os campos "parent" e "height" só são efetivamente usados pela AVL,
 * (para permitir rebalanceamento subindo pela árvore), mas não atrapalham
 * em nada. Normal na BST.
 */
public class BTNode<T> {
    private T value;
    private BTNode<T> left;
    private BTNode<T> right;
    private BTNode<T> parent;
    private int height;

    public BTNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
    }

    public T getValue() { return value; }
    public void setValue(T value) { this.value = value; }

    public BTNode<T> getLeft() { return left; }
    public void setLeft(BTNode<T> left) { this.left = left; }

    public BTNode<T> getRight() { return right; }
    public void setRight(BTNode<T> right) { this.right = right; }

    public BTNode<T> getParent() { return parent; }
    public void setParent(BTNode<T> parent) { this.parent = parent; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
