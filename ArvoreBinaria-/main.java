import java.util.Random;

public class main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        Random random = new Random();

        // Inserindo 20 números na árvore
        for (int i = 0; i < 20; i++) {
            int numeroAleatorio = random.nextInt(101);
            arvore.inserir(numeroAleatorio);
        }

        // Imprimindo em pré-ordem antes da remoção
        System.out.println("Impressão em Pré-ordem (Antes da Remoção):");
        arvore.preOrdem(arvore.raiz);

        // Imprimindo em in-ordem antes da remoção
        System.out.println("\n\nImpressão em In-ordem (Antes da Remoção):");
        arvore.emOrdem(arvore.raiz);

        // Imprimindo em pós-ordem antes da remoção
        System.out.println("\n\nImpressão em Pós-ordem (Antes da Remoção):");
        arvore.posOrdem(arvore.raiz);

        // Imprimindo em nível antes da remoção
        System.out.println("\n\nImpressão em Nível (Antes da Remoção):");
        arvore.nivelOrdem();

        // Removendo elementos aleatórios
        for (int i = 0; i < 5; i++) {
            int numeroAleatorio = random.nextInt(101);
            arvore.remover(numeroAleatorio);
        }

        // Imprimindo em pré-ordem após a remoção
        System.out.println("\n\nImpressão em Pré-ordem (Após a Remoção):");
        arvore.preOrdem(arvore.raiz);

        // Imprimindo em in-ordem após a remoção
        System.out.println("\n\nImpressão em In-ordem (Após a Remoção):");
        arvore.emOrdem(arvore.raiz);

        // Imprimindo em pós-ordem após a remoção
        System.out.println("\n\nImpressão em Pós-ordem (Após a Remoção):");
        arvore.posOrdem(arvore.raiz);

        // Imprimindo em nível após a remoção
        System.out.println("\n\nImpressão em Nível (Após a Remoção):");
        arvore.nivelOrdem();
    }
}
