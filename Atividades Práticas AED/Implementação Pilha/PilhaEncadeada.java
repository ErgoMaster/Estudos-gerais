public class PilhaEncadeada implements PilhaInterface {
    private ListaEncadeada lista;
    private int count;
    
    public PilhaEncadeada() {
        lista = new ListaEncadeada();
        count = 0;
    }
    
    @Override
    public void fazVazia() {
        lista.fazVazia();
        count = 0;
    }
    
    @Override
    public boolean estaVazia() { return (count == 0); }
    
    @Override
    public void push(Object item) {
        lista.inserirInicio(item);
        count++;
    }
    
    @Override
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
    
    @Override
    public Object getTop() throws CountVazioException {
        if(estaVazia()) { throw new CountVazioException(); }
        
        try {
            return lista.getPrimeiro();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public void imprimirPilha() {
        lista.imprimirLista();
    }
}
