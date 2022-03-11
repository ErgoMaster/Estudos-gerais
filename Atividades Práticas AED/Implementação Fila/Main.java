public class Main {
    public static void main(String[] args) {
        FilaEncadeada queue = new FilaEncadeada();

        System.out.println("-- ENFILEIRAR ELEMENTOS NA FILA --");
        queue.enfileirar(5);
        queue.enfileirar(6);
        queue.enfileirar(7);
        queue.enfileirar(9);

        queue.imprimirFila(); // Fila: 5 - 6 - 7 - 9

        System.out.println("-- PRIMEIRO ELEMENTO DA FILA --");
        try { System.out.println(queue.getPrimeiro()); } 
        catch (CountVazioException e) { System.out.println("FILA VAZIA"); }
        
        System.out.println("-- DESENFILEIRAR FILA --");
        try {
            queue.desenfileirar();
            queue.desenfileirar();
        } catch (CountVazioException e) { System.out.println("FILA VAZIA"); }
        
        queue.imprimirFila(); // Fila: 7 - 9
    }
}