public class Main {
    public static void main(String[] args) {
        FilaVetor fila = new FilaVetor(5);

        // Enfileirar elementos na fila
        try {
            fila.enfileirar(4);
            fila.enfileirar(6);
            fila.enfileirar(8);
            fila.enfileirar(10);
            fila.enfileirar(12);
        } catch (CountCheioException e) { System.out.println("PILHA CHEIA"); }

        System.out.println("-- ENFILEIRAR ELEMENTOS --");
        System.out.println(fila); // Fila: 4 - 6 - 8 - 10 - 12

        // Desenfileirar a fila
        System.out.println("Elemento removido: " + fila.desenfileirar());
        System.out.println("Elemento removido: " + fila.desenfileirar());

        System.out.println("-- DESENFILEIRAR A FILA --");
        System.out.println(fila); // Fila: 8 - 10 - 12 - null - null

        // Retornar o primeiro elemento da fila
        System.out.println("-- PRIMEIRO ELEMENTO DA FILA --");
        System.out.println(fila.getPrimeiro()); // return 8

        // Remover todos os elementos da fila
        fila.fazVazia();

        System.out.println("-- REMOVER ELEMENTOS DA FILA --");
        System.out.println(fila); // Fila: null - null - null - null - null
    }
}