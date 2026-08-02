package Biblioteca_de_Algoritmos.interfaces;

// Classe que representa um nó da
// Árvore Binária de Busca (BST)
// e da Árvore AVL.
public class BTNode<T> {

    // Armazena o valor do nó.
    private T value;

    // Referência para o filho esquerdo.
    private BTNode<T> left;

    // Referência para o filho direito.
    private BTNode<T> right;

    // Referência para o nó pai.
    // Utilizado principalmente na AVL.
    private BTNode<T> parent;

    // Armazena a altura do nó.
    // Utilizada para o balanceamento da AVL.
    private int height;

    // Cria um novo nó da árvore.
    public BTNode(T value) {

        // Define o valor armazenado.
        this.value = value;

        // Inicializa o filho esquerdo.
        this.left = null;

        // Inicializa o filho direito.
        this.right = null;

        // Inicializa o nó pai.
        this.parent = null;

        // Inicializa a altura do nó.
        this.height = 0;
    }

    // Retorna o valor do nó.
    public T getValue() {
        return value;
    }

    // Altera o valor do nó.
    public void setValue(T value) {
        this.value = value;
    }

    // Retorna o filho esquerdo.
    public BTNode<T> getLeft() {
        return left;
    }

    // Define o filho esquerdo.
    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    // Retorna o filho direito.
    public BTNode<T> getRight() {
        return right;
    }

    // Define o filho direito.
    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    // Retorna o nó pai.
    public BTNode<T> getParent() {
        return parent;
    }

    // Define o nó pai.
    public void setParent(BTNode<T> parent) {
        this.parent = parent;
    }

    // Retorna a altura do nó.
    public int getHeight() {
        return height;
    }

    // Define a altura do nó.
    public void setHeight(int height) {
        this.height = height;
    }

    // Retorna o valor do nó em formato de texto.
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}