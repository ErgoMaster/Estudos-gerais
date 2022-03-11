public class FilaEncadeada {
    private ListaEncadeada list;
    //private int count;

    public FilaEncadeada() {
        list = new ListaEncadeada();
        //count = 0;
    }

    public void fazVazia() { 
        list.fazVazia(); 
        //count = 0;
    }

    public boolean estaVazia() { return (list.estaVazia()); }

    public Object getPrimeiro() throws CountVazioException { 
        try { return list.getPrimeiro(); }
        catch(ListaVaziaException e) { throw new CountVazioException(); }
    }

    public void enfileirar(Object item) {  
        list.inserirFim(item); 
        //count++; 
    }

    public void desenfileirar() throws CountVazioException {
        try { list.extrair(list.getPrimeiro()); } 
        catch (ObjetoNaoEncontradoException e) { System.out.println("ELEMENTO NÃO ENCONTRADO"); } 
        catch (Exception e) { throw new CountVazioException(); }
    }

    public void imprimirFila() {
        list.imprimirLista();
    }
}
