import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.List;

    class Arvore {
        No raiz;

        public Arvore() {
            raiz = null;
        }

        void inserir(int chave) {
            raiz = inserirRec(raiz, chave);
        }

        No inserirRec(No raiz, int chave) {
            if (raiz == null) {
                raiz = new No(chave);
                return raiz;
            }

            if (chave < raiz.valor)
                raiz.esquerda = inserirRec(raiz.esquerda, chave);
            else if (chave > raiz.valor)
                raiz.direita = inserirRec(raiz.direita, chave);

            return raiz;
        }

        void remover(int chave) {
            raiz = removerRec(raiz, chave);
        }

        No removerRec(No raiz, int chave) {
            if (raiz == null)
                return raiz;

            if (chave < raiz.valor)
                raiz.esquerda = removerRec(raiz.esquerda, chave);
            else if (chave > raiz.valor)
                raiz.direita = removerRec(raiz.direita, chave);
            else {

                if (raiz.esquerda == null)
                    return raiz.direita;
                else if (raiz.direita == null)
                    return raiz.esquerda;

                raiz.valor = menorValor(raiz.direita);

                raiz.direita = removerRec(raiz.direita, raiz.valor);
            }

            return raiz;
        }

        int menorValor(No raiz) {
            int menorValor = raiz.valor;
            while (raiz.esquerda != null) {
                menorValor = raiz.esquerda.valor;
                raiz = raiz.esquerda;
            }
            return menorValor;
        }

        void preOrdem(No raiz) {
            if (raiz != null) {
                System.out.print(raiz.valor + " ");
                preOrdem(raiz.esquerda);
                preOrdem(raiz.direita);
            }
        }

        void emOrdem(No raiz) {
            if (raiz != null) {
                emOrdem(raiz.esquerda);
                System.out.print(raiz.valor + " ");
                emOrdem(raiz.direita);
            }
        }

        void posOrdem(No raiz) {
            if (raiz != null) {
                posOrdem(raiz.esquerda);
                posOrdem(raiz.direita);
                System.out.print(raiz.valor + " ");
            }
        }

        void nivelOrdem() {
            if (raiz == null)
                return;

            Queue<No> fila = new LinkedList<>();
            fila.add(raiz);

            while (!fila.isEmpty()) {
                No no = fila.poll();
                System.out.print(no.valor + " ");

                if (no.esquerda != null)
                    fila.add(no.esquerda);

                if (no.direita != null)
                    fila.add(no.direita);
            }
        }
    }

