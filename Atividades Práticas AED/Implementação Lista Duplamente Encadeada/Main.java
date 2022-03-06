public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testes da lista duplamente encadeada ---\n");

        ListaDupla lista = new ListaDupla();

        // Inserir um elemento no inicio da lista
        lista.inserirInicio(5);
        lista.inserirInicio(10);
        lista.inserirInicio(9);

        System.out.println("-- INSERIR INICIO --");
        lista.imprimirLista(); // Lista: 9 - 10 - 5
        System.out.print("\n");

        // Inserir um elemento no final da lista
        lista.inserirFim(4);
        lista.inserirFim(8);
        lista.inserirFim(12);

        System.out.println("-- INSERIR FIM --");
        lista.imprimirLista(); // Lista: 9 - 10 - 5 - 4 - 8 - 12
        System.out.print("\n");

        // Imprimir o primeiro elemento da lista
        try {
            System.out.println("-- PRIMEIRO ELEMENTO --");
            System.out.println(lista.getPrimeiro()); // Imprime 9
        } catch (ListaVaziaException e) {
            System.out.println("Lista vazia");
        }

        // Imprimir o ultimo elemento da lista
        try {
            System.out.println("-- ULTIMO ELEMENTO --");
            System.out.println(lista.getUltimo()); // Imprime 12
        } catch (ListaVaziaException e) {
            System.out.println("Lista vazia");
        }

        // Remover um determinado elemento da lista
        try {
            lista.extrair(10);
            lista.extrair(8);

            System.out.println("\n");
            System.out.println("-- REMOVER ELEMENTOS --");
            lista.imprimirLista(); // Lista: 9 - 5 - 4 - 12 
        } catch (ObjetoNaoEncontradoException e) {
            System.out.println("Objeto não encontrado");
        }
    }
}
