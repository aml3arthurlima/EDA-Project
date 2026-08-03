package Biblioteca_de_Algoritmos.arvoreB;
//imports
import java.util.ArrayList;

public class NoArvoreB<T> {

    // Lista que armazena as chaves do nó.
    // As chaves permanecem sempre ordenadas.
    ArrayList<T> chaves;

    // Lista de filhos do nó.
    // Cada posição representa uma subárvore da Árvore B.
    ArrayList<NoArvoreB<T>> filhos;

    // Indica se o nó é uma folha.
    // true = não possui filhos.
    // false = possui filhos.
    boolean folha;

    // Construtor da classe.
    // Recebe a informação se o nó será folha ou não.
    public NoArvoreB(boolean folha) {

        // Define se o nó é folha.
        this.folha = folha;

        // Inicializa a lista de chaves vazia.
        this.chaves = new ArrayList<>();

        // Inicializa a lista de filhos vazia.
        this.filhos = new ArrayList<>();
    }
}