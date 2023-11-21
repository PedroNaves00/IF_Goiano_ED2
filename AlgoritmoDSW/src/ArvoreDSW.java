import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArvoreDSW {
    Node raiz;

    public ArvoreDSW() {
        raiz = null;
    }

    // Função para inserir um novo nó na árvore
    private Node inserir(Node raiz, int dado) {
        if (raiz == null) {
            raiz = new Node(dado);
            return raiz;
        }

        // Inserção recursiva
        if (dado < raiz.data)
            raiz.left = inserir(raiz.left, dado);
        else if (dado > raiz.data)
            raiz.right = inserir(raiz.right, dado);

        return raiz;
    }

    // Função para transformar a árvore em uma lista
    private List<Integer> arvoreParaLista(Node raiz) {
        List<Integer> lista = new ArrayList<>();
        if (raiz != null) {
            lista.addAll(arvoreParaLista(raiz.left));
            lista.add(raiz.data);
            lista.addAll(arvoreParaLista(raiz.right));
        }
        return lista;
    }

    // Função para realizar rotações para equilibrar a lista
    private List<Integer> realizarRotacoesParaEquilibrar(List<Integer> lista) {
        List<Integer> listaEquilibrada = new ArrayList<>();
        while (!lista.isEmpty()) {
            if (lista.size() > 1) {
                int no1 = lista.remove(0);
                int no2 = lista.remove(0);
                listaEquilibrada.add(no2);
                listaEquilibrada.add(no1);
            } else {
                listaEquilibrada.add(lista.remove(0));
            }
        }
        return listaEquilibrada;
    }

    // Função para reconstruir a árvore a partir da lista balanceada
    private Node reconstruirArvore(List<Integer> lista) {
        if (lista.isEmpty()) {
            return null;
        } else {
            int valorRaiz = lista.remove(0);
            Node arvore = new Node(valorRaiz);
            while (!lista.isEmpty()) {
                int valorNo = lista.remove(0);
                arvore = inserir(arvore, valorNo);
            }
            return arvore;
        }
    }

    // Função para imprimir a lista
    private void imprimirLista(List<Integer> lista) {
        for (Integer valor : lista) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    // Função para imprimir a árvore em ordem
    private void imprimirArvore(Node raiz) {
        if (raiz != null) {
            imprimirArvore(raiz.left);
            System.out.print(raiz.data + " ");
            imprimirArvore(raiz.right);
        }
    }

    // Função para gerar números aleatórios e inseri-los na árvore
    private void gerarNumerosAleatorios(int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int numeroAleatorio = rand.nextInt(101); // Gera números aleatórios de 0 a 100
            raiz = inserir(raiz, numeroAleatorio);
        }
    }

    public static void main(String[] args) {
        ArvoreDSW arvore = new ArvoreDSW();
        arvore.gerarNumerosAleatorios(100); // Cria inicialmente uma árvore com 100 números aleatórios

        System.out.println("Árvore original em ordem:");
        arvore.imprimirArvore(arvore.raiz);

        // Adiciona mais 20 números à árvore
        for (int i = 0; i < 20; i++) {
            int numeroAleatorio = new Random().nextInt(101);
            arvore.raiz = arvore.inserir(arvore.raiz, numeroAleatorio);
        }

        System.out.println("\nÁrvore com 120 números em ordem:");
        arvore.imprimirArvore(arvore.raiz);

        // Aplicando o Algoritmo DSW
        List<Integer> listaEquilibrada = arvore.realizarRotacoesParaEquilibrar(arvore.arvoreParaLista(arvore.raiz));

        System.out.println("\nLista equilibrada após as rotações:");
        arvore.imprimirLista(listaEquilibrada);

        Node arvoreBalanceada = arvore.reconstruirArvore(listaEquilibrada);

        System.out.println("\nÁrvore balanceada em ordem:");
        arvore.imprimirArvore(arvoreBalanceada);
    }
}
