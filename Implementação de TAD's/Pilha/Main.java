public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testes da pilha ---\n");

        PilhaEncadeada pilha = new PilhaEncadeada();

        // Inserir um elemento na pilha
        pilha.push(5);
        pilha.push(10);
        pilha.push(9);

        System.out.println("-- INSERIR ELEMENTOS --");
        System.out.println(pilha); // Pilha: 9 - 10 - 5

        // Imprimir o topo da pilha
        try {
            System.out.println("-- ELEMENTO DO TOPO --");
            System.out.println(pilha.getTop()); // Imprime 9
        } catch (CountVazioException e) {
            System.out.println("Pilha vazia");
        }

        // Remover um elemento da pilha
        try {
            System.out.println("-- REMOVER UM ELEMENTO --");
            System.out.println("Elemento removido: " + pilha.pop());
        } catch (CountVazioException e) {
            System.out.println("Pilha vazia");
        }

        // Imprimir a pilha após o comando pop
        System.out.println("-- PILHA APÓS O POP --");
        System.out.println(pilha);
    }
}
