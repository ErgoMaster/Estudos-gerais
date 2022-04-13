import FilaEncadeada.CountVazioException;

public class Main {
    public static void main(String[] args) {
        Node<Integer> raiz = new Node<Integer>(6);

        // Inserindo elementos na arvore
        raiz.inserirNodeOrdenado(9);
        raiz.inserirNodeOrdenado(3);
        raiz.inserirNodeOrdenado(8);
        raiz.inserirNodeOrdenado(1);

        // Teste da arvore em ordem crescente
        System.out.println("-- ORDEM CRESCENTE --");
        raiz.imprimeOrdemCrescente();
        System.out.println("\n");

        // Teste da arvore em ordem decrescente
        System.out.println("-- ORDEM DECRESCENTE --");
        raiz.imprimeOrdemDecrescente();
        System.out.println("\n");

        // Teste da arvore em pre ordem
        System.out.println("-- PRE ORDEM --");
        raiz.imprimeEmPreOrdem();
        System.out.println("\n");

        // Teste da arvore em pos ordem
        System.out.println("-- POS ORDEM --");
        raiz.imprimeEmPosOrdem();
        System.out.println("\n");

        // Teste da arvore em largura
        System.out.println("-- LARGURA --");
        raiz.imprimeEmLargura(); 
        System.out.println("\n");

        // Teste da arvore em largura usando recursao
        System.out.println("-- LARGURA RECURSIVO --");
        raiz.imprimeEmLarguraRecursivo(); 
        System.out.println("\n");

        // Teste da arvore em largura invertido
        System.out.println("-- LARGURA INVERTIDO --");
        raiz.imprimeEmLarguraInvertido();
        System.out.println("\n");

        // Altura da arvore
        System.out.println("-- ALTURA DA ARVORE --");
        System.out.println("Altura: " + raiz.calcularAltura());
        System.out.print("\n");

        // Altura da arvore em largura
        System.out.println("-- ALTURA DA ARVORE EM LARGURA --");
        System.out.println("Altura: " + raiz.calcularAlturaEmLargura());
        System.out.println("\n");
    }
}
