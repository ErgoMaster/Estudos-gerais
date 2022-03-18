public class Main {
    public static void main(String[] args) {
        int tamanho = 5;
        ListaClassificada lista = new ListaClassificada(tamanho);
        
        // Inserir elementos na lista
        System.out.println("-- INSERIR ELEMENTOS NA LISTA --");
        try {
            lista.inserir(2);
            lista.inserir(1);
            lista.inserir(4);
            lista.inserir(5);
            lista.inserir(3); 
        } catch (CountCheioException e) { System.out.println("LISTA CHEIA"); }   

        System.out.println(lista); // Lista: 1 - 2 - 3 - 4 - 5

        // Pesquisar elemento dado seu index
        System.out.println("\n-- MÉTODO GET --");
        System.out.println("Elemento: " + lista.get(1)); // return 2

        // Pesquisar o index de um elemento que esteja na lsita
        System.out.println("\n-- MÉTODO PROCURAR --");
        try { System.out.println("Index do elemento 4: " + lista.procurar(4)); } // return 3
        catch (ObjetoNaoEncontradoException e1) { System.out.println("OBJETO NÃO ENCONTRADO"); }

        // Verificar se um determinado elemento está ou não na lista
        System.out.println("\n-- VERIFICAR ELEMENTO --");
        System.out.println("Elemento 3 está na lista: " + lista.eMembro(3)); // return true
        System.out.println("Elemento 6 está na lista: " + lista.eMembro(6)); // return false

        // Remover elementos na lista
        System.out.println("\n-- REMOVER ELEMENTOS DA LISTA --");
        try {
            lista.remover(4);
            lista.remover(2);
        } catch (ObjetoNaoEncontradoException e) { System.out.println("OBJETO NÃO ENCONTRADO"); } 
        catch (CountVazioException e) { System.out.println("LISTA VAZIA"); }

        System.out.println(lista); // Lista 1 - 3 - 5 - 0 - 0

        // Teste cursor
        System.out.println("\n\n");
        Cursor cursor = new Cursor(0, tamanho);

        // Inserir elementos
        System.out.println("-- INSERIR ELEMENTOS NO CURSOR --");
        try {
            cursor.inserir(1);
            cursor.inserir(2);
            cursor.inserir(3);
        } catch (CountCheioException e) { System.out.println("LISTA CHEIA"); }
        
        System.out.println(cursor); // Cursor: 1 - 2 - 3 - 0 - 0

        // Remover elementos
        System.out.println("\n-- REMOVER ELEMENTOS DO CURSOR --");
        try { cursor.remover(2); } 
        catch (ObjetoNaoEncontradoException e) { System.out.println("OBJETO NÃO ENCONTRADO"); } 
        catch (CountVazioException e) { System.out.println("LISTA VAZIA"); }

        System.out.println(cursor); // Cursor: 1 - 3 - 0 - 0 - 0

        // Adicionar elementos antes
        System.out.println("\n-- INSERIR ANTES --");
        cursor.setOffset(1);
        try { cursor.inserirAntes(5); } 
        catch (IndexOutOfBoundsException e) { System.out.println("INDEX FORA DOS LIMITES"); } 
        catch (CountCheioException e) { System.out.println("LISTA CHEIA"); }

        System.out.println(cursor); // Cursor: 1 - 5 - 3 - 0 - 0

        // Adicionar elementos depois
        System.out.println("\n-- INSERIR DEPOIS --");
        cursor.setOffset(2);
        try { 
            cursor.inserirDepois(4); 
            cursor.inserirDepois(6); 
        } catch (IndexOutOfBoundsException e) { System.out.println("INDEX FORA DOS LIMITES"); } 
        catch (CountCheioException e) { System.out.println("LISTA CHEIA"); }

        System.out.println(cursor); // Cursor: 1 - 5 - 3 - 6 - 4
    }
}