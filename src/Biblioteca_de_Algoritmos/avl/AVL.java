package Biblioteca_de_Algoritmos.avl;

import Biblioteca_de_Algoritmos.arvoreBST.BST;
import Biblioteca_de_Algoritmos.arvoreBST.BTNode;

public class AVL<T extends Comparable<T>> extends BST<T>{
    //**
    public AVL() {
        super();
    }

    //Metodo responsável por calcular o fator de balanceamento de um nó
    private int calculateBalance(BTNode<T> node) {
        if (node == null) {
            return 0; //Se o nó não existir o balanceamento é zero
        }
        //retorna a altura(esquerda) - altura(direita)
        return height(node.getLeft()) - height(node.getRight());
    }

    //Atualiza a altura de um nó
    private void updateHeight(BTNode<T> node) {

        if (node != null) {
            int alturaEsquerda = height(node.getLeft()); //Calcula a altura da subárvore esquerda
            int alturaDireita = height(node.getRight()); //Calcula a altura da subárvore direita
                                //**
            // A altura do nó é a maior altura entre os filhos + 1.
            node.setHeight(Math.max(alturaEsquerda, alturaDireita) + 1);
        }


    }

    //Realiza uma rotação simples para a direita
    //utilizada quando a árvore fica desbalanceada para a esquerda (caso Esquerda-Esquerda).
    private BTNode<T> rightRotation(BTNode<T> y) {

        //O filho esquerdo de y (root) será a nova raiz da subárvore
        BTNode<T> x = y.getLeft();
        //Guarda temporariamente a subárvore direita de x
        BTNode<T>  T2 =  x.getRight();
        //Faz a rotação
        x.setRight(y);
        y.setLeft(T2);
        //Atualiza as alturas dos nós modificados.
        updateHeight(y);
        updateHeight(x);
        //Retorna a nova raiz da subárvore
        return x;
    }

    //Realiza uma rotação simples para a direita
    //utilizada quando a árvore fica desbalanceada para a direita (caso Direita-Direita).
    private BTNode<T> leftRotation(BTNode<T> x) {

        //O filho direito de x será a nova raiz da subárvore
        BTNode<T> y = x.getRight();
        //Guarda temporariamente a subárvore esquerda de y.
        BTNode<T> T2 = y.getLeft();
        //Realiza a rotação
        y.setLeft(x);
        x.setRight(T2);
        //Atualiza as alturas dos nós modificados
        updateHeight(x);
        updateHeight(y);
        //Retorna a nova raiz da subárvore
        return y;

    }

    /* Rebalanceia uma subárvore caso ela esteja desbalanceada
    O fator de balanceamento determina qual dos quatro casos da AVL ocorreu:
    LL( Esquerda - Esquerda)
    RR (Direita - Direita)
    LR (Esquerda - Direita)
    RF (Direita - Esquerda)
    Quando é indentificado o caso, então se aplica a rotação adequada e retorna a nova raiz da subárvore.
     */
    private BTNode<T> rebalance(BTNode<T> node) {

        //Calcula o fator de balanceamento
        int balance = calculateBalance(node);

        //Caso LL
        if (balance > 1 && calculateBalance(node.getLeft()) >= 0) {
            return rightRotation(node);
        }
        //Caso LR
        if (balance > 1 && calculateBalance(node.getLeft()) < 0 ) {
            //Primeiro gira o filho para a esquerda
            node.setLeft(leftRotation(node.getLeft()));
            //Depois gira o próprio nó para a direita.
            return rightRotation(node);
        }
        //Caso RR
        if (balance < -1 && calculateBalance(node.getRight()) <= 0 ) {
            return leftRotation(node);
        }
        //Caso RL
        if (balance < -1 && calculateBalance(node.getRight()) > 0 ) {
            //Primeiro gira o filho para a esquerda
            node.setRight(rightRotation(node.getRight()));
            //Depois gira o próprio nó para a esquerda
            return leftRotation(node);
        }
        //Se já estiver balanceado, não faz nenhuma alteração
        return node;
    }

    @Override
    public void insert(T value) {
        int tamanhoAntes = size;
        root = insert(root, value);

        //Atualiza o tamanho apenas quando um novo elemento realmente foi inserido.
        if (size == tamanhoAntes) {
            size++;
        }
    }

    //Insere recursivamente um elemento na árvore AVL
    @Override
    protected BTNode<T> insert(BTNode<T> node, T value) {

        //Caso base: encontrou uma posição vazia para inserir o novo nó
        if (node == null) {
            return new BTNode<> (value);
        }
        //Compara o valor informado com o valor do nó atual.
        int comparacao = value.compareTo(node.getValue());

        //Se o valor for menor, continua a inserção na subárvore esquerda
        if (comparacao < 0 ) {
            node.setLeft(insert(node.getLeft(), value));
        }
        //Se o valor for maior, continua a inserção na subárvore direita
        else if (comparacao > 0) {
            node.setRight(insert(node.getRight(), value));
        }

        //Se o valor já existir, não insere novamente
        else {
            return node;
        }

        //Atualiza a altura do nó após a inserção
        updateHeight(node);
        //Rebalanceia a árvore, caso necessário.
        return rebalance(node);
    }

    //Remove um elemento da árvore AVL e após isso ela é rebalanceada
    @Override
    public void remove(T key) {
        if (search(key) != null) {
            root = removeNode(root, key);
            size--;
        }
    }

    //Remove recursivamente um elemento da árvore AVL
    //Após a remoção, atualiza a altura dos nós e rebalanceia a árvore, se for necessário

    @Override
    protected BTNode<T> removeNode(BTNode<T> node, T key) {

        //Se o nó não existir, não há o que remover
        if (node == null) {
            return null;
        }

        int comparacao = key.compareTo(node.getValue());

        //Continua procurando na subárvore esquerda
        if (comparacao < 0) {
            node.setLeft(removeNode(node.getLeft(), key));
        }
        //Continua procurando na subárvore direita
        else if (comparacao > 0) {
            node.setRight(removeNode(node.getRight(), key));
        }

        //Encontrou o nó
        else {
            //Caso 1: nó folha
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            //Caso 2: possui apenas filho direito
            if (node.getLeft() == null) {
                return node.getRight();
            }
            //Caso 3: possui apenas filho esquerdo
            if (node.getRight() == null) {
                return node.getLeft();
            }
            //Caso 4: possui dois filhos
            BTNode<T> sucessor = minNode(node.getRight());
            node.setValue(sucessor.getValue());
            node.setRight(removeMin(node.getRight()));
        }
        //Atualiza a altura do nó
        updateHeight(node);
        //Rebalanceia a árvore
        return rebalance(node);

    }

}
