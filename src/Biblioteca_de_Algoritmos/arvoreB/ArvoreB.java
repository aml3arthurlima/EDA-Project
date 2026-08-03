package Biblioteca_de_Algoritmos.arvoreB;

import java.util.ArrayList;

// Implementação de uma Árvore B.
// Essa estrutura mantém os elementos ordenados
// e balanceados automaticamente.
public class ArvoreB<T extends Comparable<T>> {

    // Referência para a raiz da árvore.
    private Biblioteca_de_Algoritmos.arvoreB.NoArvoreB<T> raiz;

    // Grau mínimo da Árvore B.
    // Define a quantidade mínima e máxima
    // de chaves que cada nó pode armazenar.
    private final int grauMinimo;

    // Quantidade de elementos da árvore.
    private int tamanho;

    // Cria uma nova Árvore B.
    public ArvoreB(int grauMinimo) {

        // Verifica se o grau mínimo é válido.
        // Uma Árvore B deve possuir grau mínimo maior ou igual a 2.
        if (grauMinimo < 2) {
            throw new IllegalArgumentException("O grau mínimo (t) deve ser >= 2.");
        }

        // Armazena o grau mínimo informado.
        this.grauMinimo = grauMinimo;

        // Cria a raiz inicialmente vazia.
        // Como não possui filhos,
        // ela é criada como folha.
        this.raiz = new Biblioteca_de_Algoritmos.arvoreB.NoArvoreB<>(true);

        // Inicializa a quantidade de elementos.
        this.tamanho = 0;
    }

    // Verifica se a árvore está vazia.
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Retorna a quantidade de elementos da árvore.
    public int size() {
        return tamanho;
    }

    // Inicia a busca pela raiz.
    public boolean search(T chave) {
        return search(raiz, chave);
    }

    // Procura uma chave de forma recursiva.
    private boolean search(Biblioteca_de_Algoritmos.arvoreB.NoArvoreB<T> node, T chave) {

        // Começa pela primeira chave do nó.
        int i = 0;

        // Percorre as chaves enquanto
        // a chave procurada for maior.
        while (i < node.chaves.size() &&
                chave.compareTo(node.chaves.get(i)) > 0) {

            i++;
        }

        // Verifica se encontrou a chave.
        if (i < node.chaves.size() &&
                chave.compareTo(node.chaves.get(i)) == 0) {

            return true;
        }

        // Se chegou em uma folha,
        // significa que a chave não existe.
        if (node.folha) {
            return false;
        }

        // Continua a busca no filho correto.
        return search(node.filhos.get(i), chave);
    }

    // Insere uma nova chave na árvore.
    public void insert(T chave) {

        // Verifica se a chave já existe.
        if (search(chave)) {

            // Não permite elementos duplicados.
            return;
        }

        // Guarda a raiz atual.
        NoArvoreB<T> r = raiz;

        // Verifica se a raiz está cheia.
        if (r.chaves.size() == 2 * grauMinimo - 1) {

            // Cria uma nova raiz.
            NoArvoreB<T> novaRaiz = new NoArvoreB<>(false);

            // A antiga raiz passa
            // a ser filha da nova raiz.
            novaRaiz.filhos.add(r);

            // Divide a antiga raiz.
            split(novaRaiz, 0, r);

            // Atualiza a raiz da árvore.
            raiz = novaRaiz;

            // Continua a inserção normalmente.
            insertNaoCheio(raiz, chave);

        } else {

            // Se a raiz ainda possui espaço,
            // basta inserir normalmente.
            insertNaoCheio(r, chave);
        }

        // Atualiza a quantidade de elementos.
        tamanho++;
    }

    // Divide um nó que está cheio.
    // A chave do meio sobe para o nó pai
    // e o nó original é dividido em dois.
    private void split(NoArvoreB<T> pai, int i, NoArvoreB<T> filho) {

        // Obtém o grau mínimo da árvore.
        int t = grauMinimo;

        // Cria um novo nó.
        // Ele terá o mesmo tipo (folha ou interno)
        // do nó que está sendo dividido.
        NoArvoreB<T> novo = new NoArvoreB<>(filho.folha);

        // Copia para o novo nó
        // as últimas (t - 1) chaves do nó cheio.
        for (int j = 0; j < t - 1; j++) {

            novo.chaves.add(filho.chaves.get(j + t));
        }

        // Se o nó não for folha,
        // também é necessário copiar os filhos.
        if (!filho.folha) {

            // Copia os últimos t filhos.
            for (int j = 0; j < t; j++) {

                novo.filhos.add(filho.filhos.get(j + t));
            }
        }

        // Guarda a chave central do nó.
        // Essa chave será promovida para o pai.
        T chaveMeio = filho.chaves.get(t - 1);

        // Remove do nó original
        // todas as chaves que foram movidas.
        for (int j = filho.chaves.size() - 1; j >= t - 1; j--) {

            filho.chaves.remove(j);
        }

        // Se o nó possuir filhos,
        // remove também os filhos transferidos.
        if (!filho.folha) {

            for (int j = filho.filhos.size() - 1; j >= t; j--) {

                filho.filhos.remove(j);
            }
        }

        // Insere o novo nó como filho do pai.
        pai.filhos.add(i + 1, novo);

        // Insere a chave central no pai.
        pai.chaves.add(i, chaveMeio);
    }

    // Insere uma chave em um nó
    // que possui espaço disponível.
    private void insertNaoCheio(NoArvoreB<T> node, T chave) {

        // Começa analisando a última chave do nó.
        int i = node.chaves.size() - 1;

        // Se o nó for folha,
        // a chave será inserida diretamente nele.
        if (node.folha) {

            // Cria uma posição vazia
            // para deslocar os elementos.
            node.chaves.add(null);

            // Enquanto a nova chave for menor,
            // desloca as chaves para a direita.
            while (i >= 0 &&
                    chave.compareTo(node.chaves.get(i)) < 0) {

                node.chaves.set(i + 1,
                        node.chaves.get(i));

                i--;
            }

            // Coloca a nova chave
            // na posição correta.
            node.chaves.set(i + 1, chave);

        } else {

            // Procura em qual filho
            // a nova chave deve ser inserida.
            while (i >= 0 &&
                    chave.compareTo(node.chaves.get(i)) < 0) {

                i--;
            }

            // Avança para o filho correto.
            i++;

            // Verifica se o filho escolhido está cheio.
            if (node.filhos.get(i).chaves.size()
                    == 2 * grauMinimo - 1) {

                // Divide esse filho.
                split(node, i, node.filhos.get(i));

                // Depois da divisão,
                // verifica em qual dos dois filhos
                // a chave deverá continuar.
                if (chave.compareTo(node.chaves.get(i)) > 0) {

                    i++;
                }
            }

            // Continua a inserção
            // de forma recursiva.
            insertNaoCheio(node.filhos.get(i), chave);
        }
    }

    // Retorna a altura da Árvore B.
    public int height() {

        // Inicia o cálculo da altura pela raiz.
        return height(raiz);
    }

    // Calcula a altura da árvore de forma recursiva.
    private int height(NoArvoreB<T> node) {

        // Se o nó for uma folha,
        // sua altura é zero.
        if (node.folha) {
            return 0;
        }

        // Em uma Árvore B todas as folhas
        // ficam obrigatoriamente no mesmo nível.
        // Por isso basta calcular a altura
        // seguindo apenas o primeiro filho.
        return 1 + height(node.filhos.get(0));
    }

    // Exibe a árvore organizada por níveis.
    // Cada linha representa um nível da árvore.
    public void printLevels() {

        // Verifica se a árvore está vazia.
        if (raiz.chaves.isEmpty()) {

            System.out.println("Árvore B vazia.");
            return;
        }

        // Lista que armazenará os nós
        // do nível atual.
        ArrayList<NoArvoreB<T>> nivelAtual = new ArrayList<>();

        // O primeiro nível contém apenas a raiz.
        nivelAtual.add(raiz);

        // Controla o número do nível.
        int nivel = 0;

        // Continua enquanto ainda existirem nós
        // para serem processados.
        while (!nivelAtual.isEmpty()) {

            // Cria a mensagem do nível atual.
            StringBuilder sb = new StringBuilder("Nível " + nivel + ": ");

            // Lista que armazenará os nós
            // do próximo nível.
            ArrayList<NoArvoreB<T>> proximoNivel = new ArrayList<>();

            // Percorre todos os nós
            // do nível atual.
            for (NoArvoreB<T> node : nivelAtual) {

                // Adiciona as chaves do nó
                // na saída.
                sb.append(node.chaves);

                // Adiciona um espaço
                // para separar os nós.
                sb.append("  ");

                // Se o nó possuir filhos,
                // adiciona todos eles
                // para serem processados
                // no próximo nível.
                if (!node.folha) {

                    proximoNivel.addAll(node.filhos);
                }
            }

            // Exibe todas as chaves
            // pertencentes ao nível atual.
            System.out.println(sb.toString().trim());

            // O próximo nível passa
            // a ser o nível atual.
            nivelAtual = proximoNivel;

            // Atualiza o contador de níveis.
            nivel++;
        }
    }
}