public class Main {
    public static void main(String[] args) {
        Node<Integer> raiz = new Node<Integer>(15);

        raiz.inserirNodeOrdenado(10);
        raiz.inserirNodeOrdenado(20);
        raiz.inserirNodeOrdenado(25);

        ArvoreAVL<Integer> arvore = new ArvoreAVL<>(raiz);
        System.out.println(arvore.verifyAVL());
    }
}
