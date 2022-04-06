public class Main {
    public static void main(String[] args) {
        Node<Integer> raiz_1 = new Node<Integer>(5);
        Node<Integer> raiz_2 = new Node<Integer>(5);

        // Teste da arvore em ordem crescente
        raiz_1.inserirNodeOrdenado(6);
        raiz_1.imprimeOrdemCrescente();
        System.out.println();

        raiz_1.inserirNodeOrdenado(3);
        raiz_1.imprimeOrdemCrescente();
        System.out.println();

        raiz_1.inserirNodeOrdenado(8);
        raiz_1.imprimeOrdemCrescente();
        System.out.println();

        raiz_1.inserirNodeOrdenado(1);
        raiz_1.imprimeOrdemCrescente();
        System.out.println();

        System.out.println("\n");

        // Teste da arvore em ordem decrescente
        raiz_2.inserirNodeOrdenado(6);
        raiz_2.imprimeOrdemDecrescente();
        System.out.println();

        raiz_2.inserirNodeOrdenado(3);
        raiz_2.imprimeOrdemDecrescente();
        System.out.println();

        raiz_2.inserirNodeOrdenado(8);
        raiz_2.imprimeOrdemDecrescente();
        System.out.println();

        raiz_2.inserirNodeOrdenado(1);
        raiz_2.imprimeOrdemDecrescente();
        System.out.println();
    }
}
