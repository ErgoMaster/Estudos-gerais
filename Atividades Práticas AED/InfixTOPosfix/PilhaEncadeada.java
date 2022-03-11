public class PilhaEncadeada {
    private ListaEncadeada lista;
    private int count;
    
    public PilhaEncadeada() {
        lista = new ListaEncadeada();
        count = 0;
    }
    
    public void fazVazia() {
        lista.fazVazia();
        count = 0;
    }
    
    public boolean estaVazia() { return (count == 0); }
    
    public void push(Object item) {
        lista.inserirInicio(item);
        count++;
    }
    
    public Object pop() throws CountVazioException {
        if(estaVazia()) { throw new CountVazioException(); }
        
        try {
            Object item = lista.getPrimeiro();
            lista.extrair(item);
            count--;
            
            return item;
        } catch(Exception e) {
            return null;
        }
    }
    
    public Object getTop() throws CountVazioException {
        if(estaVazia()) { throw new CountVazioException(); }
        
        try {
            return lista.getPrimeiro();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void imprimirPilha() {
        lista.imprimirLista();
    }
}