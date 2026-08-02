package Biblioteca_de_Algoritmos.arvoreBST;

import Biblioteca_de_Algoritmos.interfaces.BT;
import Biblioteca_de_Algoritmos.interfaces.BTNode;

import java.util.ArrayList;


//Árvore Binária de Busca
//Serve também de base para a AVL.

public class BST<T extends Comparable<T>> implements BT<T> {

    protected BTNode<T> root;
    protected int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public BTNode<T> getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int height() {
        return height(root);
    }

    protected int height(BTNode<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    @Override
    public BTNode<T> search(T elem) {
        return search(root, elem);
    }

    protected BTNode<T> search(BTNode<T> node, T elem) {
        if (node == null) {
            return null;
        }
        int cmp = elem.compareTo(node.getValue());
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return search(node.getLeft(), elem);
        } else {
            return search(node.getRight(), elem);
        }
    }

    @Override
    public void insert(T value) {
        int tamanhoAntes = size;
        root = insert(root, value);
        if (size == tamanhoAntes) {
            size++;
        }
    }

    protected BTNode<T> insert(BTNode<T> node, T value) {
        if (node == null) {
            return new BTNode<>(value);
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (cmp > 0) {
            node.setRight(insert(node.getRight(), value));
        }
        // se cmp == 0 (chave duplicada) não faz nada
        return node;
    }

    @Override
    public void remove(T key) {
        if (search(key) != null) {
            root = removeNode(root, key);
            size--;
        }
    }

    protected BTNode<T> removeNode(BTNode<T> node, T key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(removeNode(node.getLeft(), key));
        } else if (cmp > 0) {
            node.setRight(removeNode(node.getRight(), key));
        } else {
            // Caso 1: nó folha
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            // Caso 2: um único filho
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            // Caso 3: dois filhos -> sucessor em ordem (mínimo da subárvore direita)
            BTNode<T> sucessor = minNode(node.getRight());
            node.setValue(sucessor.getValue());
            node.setRight(removeMin(node.getRight()));
        }
        return node;
    }

    protected BTNode<T> minNode(BTNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    protected BTNode<T> maxNode(BTNode<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    protected BTNode<T> removeMin(BTNode<T> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(removeMin(node.getLeft()));
        return node;
    }

    @Override
    public T[] preOrder() {
        ArrayList<T> lista = new ArrayList<>();
        preOrder(root, lista);
        return converterParaArray(lista);
    }

    private void preOrder(BTNode<T> node, ArrayList<T> lista) {
        if (node == null) return;
        lista.add(node.getValue());
        preOrder(node.getLeft(), lista);
        preOrder(node.getRight(), lista);
    }

    @Override
    public T[] order() {
        ArrayList<T> lista = new ArrayList<>();
        order(root, lista);
        return converterParaArray(lista);
    }

    private void order(BTNode<T> node, ArrayList<T> lista) {
        if (node == null) return;
        order(node.getLeft(), lista);
        lista.add(node.getValue());
        order(node.getRight(), lista);
    }

    @Override
    public T[] postOrder() {
        ArrayList<T> lista = new ArrayList<>();
        postOrder(root, lista);
        return converterParaArray(lista);
    }


     // Converte a ArrayList<T> interna para um vetor T[] de verdade.
     //Não é possível simplesmente fazer "(T[]) lista.toArray()" aqui porque,
     //como T é limitado por Comparable<T>, essa expressão seria compilada
     //como um cast para Comparable[], e o objeto devolvido por
     //ArrayList.toArray() é sempre um Object[] puro — o que causaria
     //ClassCastException em tempo de execução. Por isso usar reflection
     //para criar um vetor com o tipo de tempo de execução correto.

    @SuppressWarnings("unchecked")
    private T[] converterParaArray(ArrayList<T> lista) {
        if (lista.isEmpty()) {
            return (T[]) new Comparable[0];
        }
        T[] array = (T[]) java.lang.reflect.Array.newInstance(lista.get(0).getClass(), lista.size());
        for (int i = 0; i < lista.size(); i++) {
            array[i] = lista.get(i);
        }
        return array;
    }

    private void postOrder(BTNode<T> node, ArrayList<T> lista) {
        if (node == null) return;
        postOrder(node.getLeft(), lista);
        postOrder(node.getRight(), lista);
        lista.add(node.getValue());
    }

    @Override
    public int size() {
        return size;
    }
}
