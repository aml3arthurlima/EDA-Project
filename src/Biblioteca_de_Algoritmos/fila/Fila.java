package Biblioteca_de_Algoritmos.fila;

public class Fila<T> {

    private T[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;
    private int capacidade;

    @SuppressWarnings("unchecked")// Oculta o aviso do cast para vetor genérico, ao converter Object[] para T[].
    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = (T[])new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.quantidade = 0;
    }

    //Metodo que verifica se a fila está vazia
    public boolean isEmpty() {
        return quantidade == 0;
    }

    //Metodo que verifica se a fila está cheia
    public boolean isFull() {
        return quantidade == capacidade;
    }

    //Metodo responsável por inserir um elemento ao final da fila
    public void enqueue(T elemento) {
        //Não permite a inserção se a fila estiver cheia
        if (isFull()) {
            throw new RuntimeException("Fila cheia!");
        }
        elementos[fim] = elemento; //Insere o elemento na posição indicada por "fim".
        //Avança o índice de fim.
        //O operador % transforma a fila em circular,
        //fazendo o índice voltar para o início do vetor
        //quando alcançar a sua última posição.
        fim = (fim + 1) % capacidade;
        quantidade++; //Atualiza a quantidade de elementos
    }

    //Metodo que remove o primeiro elemento da fila
    public T dequeue() {
        //Não permite remover elementos de uma fila vazia
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        T removido = elementos[inicio]; //Guarda o elemento que será removido
        elementos[inicio] = null; //Remove a referência do objeto do vetor
        inicio = (inicio + 1) % capacidade; //O início passa a apontar para o próximo elemento
        quantidade--; //atualiza quantidade
        return removido;
    }

    //Retorna o primeiro elemento da fila
    public T head(){
        //Não é possível consultar uma fila vazia
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        return elementos[inicio];
    }

    //Retorna a quantidade atual dos elementos da lista
    public int size() {
        return quantidade;
    }

}
