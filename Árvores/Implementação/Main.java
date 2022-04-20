public class Main {
    public static void main(String[] args) {
        Node<Integer> raiz = new Node<Integer>(6);

        // Inserindo elementos na arvore
        raiz.inserirNodeOrdenado(9);
        raiz.inserirNodeOrdenado(3);
        raiz.inserirNodeOrdenado(8);
        raiz.inserirNodeOrdenado(1);
        raiz.inserirNodeOrdenado(15);
        raiz.inserirNodeOrdenado(7);

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

        // Pesquisar um valor dentro da arvore
        System.out.println("-- PESQUEISAR VALOR --");
        System.out.println("Pesquisa 2 (não tem): " + raiz.pesquisarValor(2).getValor()); // -1
        System.out.println("Pesquisa 3 (tem): " + raiz.pesquisarValor(3).getValor()); // 3
        System.out.print("\n");

        // Verificar a quantidade de nos folhas que a arvore possui
        System.out.println("-- NÚMERO DE NÓS FOLHAS --");
        System.out.print("Total: " + raiz.calcularNumeroNodesFolhas());
        System.out.print("\n");
    }
}
