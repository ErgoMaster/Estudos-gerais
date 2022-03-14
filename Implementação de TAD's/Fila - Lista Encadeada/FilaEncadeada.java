public class FilaEncadeada implements FilaInterface {
    private ListaEncadeada list;

    public FilaEncadeada() {
        list = new ListaEncadeada();
    }

    public void fazVazia() {  list.fazVazia(); }

    public boolean estaVazia() { return (list.estaVazia()); }

    @Override
    public Object getPrimeiro() throws CountVazioException { 
        try { return list.getPrimeiro(); }
        catch(ListaVaziaException e) { throw new CountVazioException(); }
    }

    @Override
    public void enfileirar(Object item) { list.inserirFim(item); }

    @Override
    public Object desenfileirar() throws CountVazioException {
        try { 
            Object obj = list.getPrimeiro();
            list.extrair(obj); 
            return obj;
        } 
        catch (Exception e) { throw new CountVazioException(); } 
    }

    @Override
    public String toString() { return list.toString(); }
}
