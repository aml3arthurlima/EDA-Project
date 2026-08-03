package Biblioteca_de_Algoritmos.arvoreBST;

import Biblioteca_de_Algoritmos.interfaces.BT;

import java.util.ArrayList;

// Implementação de uma Árvore Binária de Busca (BST).
// Esta classe também serve como base para a implementação da Árvore AVL.
public class BST<T extends Comparable<T>> implements BT<T> {

    // Referência para a raiz da árvore.
    protected BTNode<T> root;

    // Armazena a quantidade de elementos da árvore.
    protected int size;

    // Cria uma árvore vazia.
    public BST() {

        // Inicializa a raiz como nula.
        this.root = null;

        // Inicializa a quantidade de elementos.
        this.size = 0;
    }

    // Retorna o nó raiz da árvore.
    @Override
    public BTNode<T> getRoot() {
        return root;
    }

    // Verifica se a árvore está vazia.
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // Retorna a altura da árvore.
    @Override
    public int height() {
        return height(root);
    }

    // Calcula a altura da árvore de forma recursiva.
    protected int height(BTNode<T> node) {

        // Se o nó for nulo,
        // a altura é -1.
        if (node == null) {
            return -1;
        }

        // Calcula a altura da subárvore esquerda
        // e da subárvore direita.
        // Retorna a maior delas somando 1,
        // correspondente ao nó atual.
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    // Inicia a busca de um elemento pela raiz.
    @Override
    public BTNode<T> search(T elem) {
        return search(root, elem);
    }

    // Procura um elemento na árvore de forma recursiva.
    protected BTNode<T> search(BTNode<T> node, T elem) {

        // Se o nó for nulo,
        // o elemento não existe.
        if (node == null) {
            return null;
        }

        // Compara o elemento procurado
        // com o valor do nó atual.
        int cmp = elem.compareTo(node.getValue());

        // Se forem iguais,
        // encontrou o elemento.
        if (cmp == 0) {
            return node;
        }

        // Se o elemento for menor,
        // continua a busca na subárvore esquerda.
        else if (cmp < 0) {
            return search(node.getLeft(), elem);
        }

        // Caso contrário,
        // continua a busca na subárvore direita.
        else {
            return search(node.getRight(), elem);
        }
    }

    // Insere um novo elemento na árvore.
    @Override
    public void insert(T value) {

        // Guarda o tamanho atual da árvore.
        int tamanhoAntes = size;

        // Realiza a inserção.
        root = insert(root, value);

        // Se o elemento foi inserido,
        // incrementa a quantidade de elementos.
        if (size == tamanhoAntes) {
            size++;
        }
    }

    // Realiza a inserção recursiva.
    protected BTNode<T> insert(BTNode<T> node, T value) {

        // Se encontrou uma posição vazia,
        // cria um novo nó.
        if (node == null) {
            return new BTNode<>(value);
        }

        // Compara o novo valor
        // com o valor do nó atual.
        int cmp = value.compareTo(node.getValue());

        // Se for menor,
        // insere na subárvore esquerda.
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), value));
        }

        // Se for maior,
        // insere na subárvore direita.
        else if (cmp > 0) {
            node.setRight(insert(node.getRight(), value));
        }

        // Se o valor já existir,
        // não realiza nenhuma inserção.

        // Retorna o nó atualizado.
        return node;
    }
    // Remove um elemento da árvore.
    @Override
    public void remove(T key) {

        // Verifica se o elemento realmente existe.
        if (search(key) != null) {

            // Realiza a remoção.
            root = removeNode(root, key);

            // Atualiza a quantidade de elementos.
            size--;
        }
    }

    // Remove um nó da árvore de forma recursiva.
    protected BTNode<T> removeNode(BTNode<T> node, T key) {

        // Se chegou em um nó nulo,
        // o elemento não foi encontrado.
        if (node == null) {
            return null;
        }

        // Compara a chave procurada
        // com o valor do nó atual.
        int cmp = key.compareTo(node.getValue());

        // Se a chave for menor,
        // continua procurando na subárvore esquerda.
        if (cmp < 0) {

            node.setLeft(removeNode(node.getLeft(), key));

        }

        // Se a chave for maior,
        // continua procurando na subárvore direita.
        else if (cmp > 0) {

            node.setRight(removeNode(node.getRight(), key));

        }

        // Se encontrou o nó,
        // inicia o processo de remoção.
        else {

            // Caso 1:
            // O nó não possui filhos.
            if (node.getLeft() == null && node.getRight() == null) {

                // Basta remover o nó.
                return null;
            }

            // Caso 2:
            // O nó possui somente o filho direito.
            if (node.getLeft() == null) {

                // O filho direito ocupa o lugar do nó removido.
                return node.getRight();
            }

            // Caso 2:
            // O nó possui somente o filho esquerdo.
            if (node.getRight() == null) {

                // O filho esquerdo ocupa o lugar do nó removido.
                return node.getLeft();
            }

            // Caso 3:
            // O nó possui dois filhos.

            // Procura o sucessor em ordem,
            // que é o menor elemento da subárvore direita.
            BTNode<T> sucessor = minNode(node.getRight());

            // Copia o valor do sucessor
            // para o nó que será removido.
            node.setValue(sucessor.getValue());

            // Remove o sucessor da subárvore direita.
            node.setRight(removeMin(node.getRight()));
        }

        // Retorna o nó atualizado.
        return node;
    }

    // Retorna o menor nó de uma subárvore.
    protected BTNode<T> minNode(BTNode<T> node) {

        // Enquanto existir filho esquerdo,
        // continua descendo na árvore.
        while (node.getLeft() != null) {

            node = node.getLeft();
        }

        // O último nó encontrado
        // contém o menor valor.
        return node;
    }

    // Retorna o maior nó de uma subárvore.
    protected BTNode<T> maxNode(BTNode<T> node) {

        // Enquanto existir filho direito,
        // continua descendo na árvore.
        while (node.getRight() != null) {

            node = node.getRight();
        }

        // O último nó encontrado
        // contém o maior valor.
        return node;
    }

    // Remove o menor elemento de uma subárvore.
    protected BTNode<T> removeMin(BTNode<T> node) {

        // Se não existe filho esquerdo,
        // este nó é o menor da subárvore.
        if (node.getLeft() == null) {

            // O filho direito assume o lugar dele.
            return node.getRight();
        }

        // Continua procurando o menor nó
        // na subárvore esquerda.
        node.setLeft(removeMin(node.getLeft()));

        // Retorna o nó atualizado.
        return node;
    }
    // Retorna os elementos da árvore em pré-ordem.
    @Override
    public T[] preOrder() {

        // Cria uma lista para armazenar o percurso.
        ArrayList<T> lista = new ArrayList<>();

        // Inicia o percurso pela raiz.
        preOrder(root, lista);

        // Converte a lista para um vetor.
        return converterParaArray(lista);
    }

    // Percorre a árvore em pré-ordem.
    // Ordem: Raiz -> Esquerda -> Direita.
    private void preOrder(BTNode<T> node, ArrayList<T> lista) {

        // Se o nó for nulo,
        // encerra a recursão.
        if (node == null) {
            return;
        }

        // Visita primeiro a raiz.
        lista.add(node.getValue());

        // Percorre a subárvore esquerda.
        preOrder(node.getLeft(), lista);

        // Percorre a subárvore direita.
        preOrder(node.getRight(), lista);
    }

    // Retorna os elementos da árvore em ordem.
    @Override
    public T[] order() {

        // Cria uma lista para armazenar o percurso.
        ArrayList<T> lista = new ArrayList<>();

        // Inicia o percurso pela raiz.
        order(root, lista);

        // Converte a lista para um vetor.
        return converterParaArray(lista);
    }

    // Percorre a árvore em ordem.
    // Ordem: Esquerda -> Raiz -> Direita.
    private void order(BTNode<T> node, ArrayList<T> lista) {

        // Se o nó for nulo,
        // encerra a recursão.
        if (node == null) {
            return;
        }

        // Percorre a subárvore esquerda.
        order(node.getLeft(), lista);

        // Visita a raiz.
        lista.add(node.getValue());

        // Percorre a subárvore direita.
        order(node.getRight(), lista);
    }

    // Retorna os elementos da árvore em pós-ordem.
    @Override
    public T[] postOrder() {

        // Cria uma lista para armazenar o percurso.
        ArrayList<T> lista = new ArrayList<>();

        // Inicia o percurso pela raiz.
        postOrder(root, lista);

        // Converte a lista para um vetor.
        return converterParaArray(lista);
    }

    // Converte uma ArrayList para um vetor do tipo T[].
    @SuppressWarnings("unchecked")
    private T[] converterParaArray(ArrayList<T> lista) {

        // Se a lista estiver vazia,
        // retorna um vetor vazio.
        if (lista.isEmpty()) {
            return (T[]) new Comparable[0];
        }

        // Cria um vetor do mesmo tipo dos elementos.
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                lista.get(0).getClass(),
                lista.size()
        );

        // Copia cada elemento da lista para o vetor.
        for (int i = 0; i < lista.size(); i++) {
            array[i] = lista.get(i);
        }

        // Retorna o vetor preenchido.
        return array;
    }

    // Percorre a árvore em pós-ordem.
    // Ordem: Esquerda -> Direita -> Raiz.
    private void postOrder(BTNode<T> node, ArrayList<T> lista) {

        // Se o nó for nulo,
        // encerra a recursão.
        if (node == null) {
            return;
        }

        // Percorre a subárvore esquerda.
        postOrder(node.getLeft(), lista);

        // Percorre a subárvore direita.
        postOrder(node.getRight(), lista);

        // Visita a raiz por último.
        lista.add(node.getValue());
    }

    // Retorna a quantidade de elementos da árvore.
    @Override
    public int size() {
        return size;
    }
}
