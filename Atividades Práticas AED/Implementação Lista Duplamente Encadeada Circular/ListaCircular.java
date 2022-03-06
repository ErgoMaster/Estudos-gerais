import ListaDupla.Element;

public class ListaCircular<T> {
    private Element head;
    private int count;
    
    public ListaParametrizada() {}
    
    public final class Element {
        T data;
        Element next;
        Element prev;
        
        Element(T data, Element prev, Element next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        
        public void inserirDepois(T item) {
            
        }

        public void inserirAntes(T item) {
            
        }
    }
    
    public Element getHead() { return head; }
    
    public boolean estaVazia() { return (head == null); }
    
    public T getPrimeiro() throws ListaVaziaException {
        if(estaVazia()) { throw new ListaVaziaException(); }
        else { return head.data; }
    }

    public T getUltimo() throws ListaVaziaException {
        if(estaVazia()) { throw new ListaVaziaException(); }
        else { return head.prev.data; }
    }
     
    public void inserir(T item) {
        Element temp = new Element(item, head.prev, head);

        head.prev.next = temp;
        head.prev = temp;

        head = temp;
        count++;
    }
    
    public void extrair(Object item) throws ObjetoNaoEncontradoException {
        Element ponteiro = head;
        int aux = 0;
        
        while(aux < count && ponteiro.data != item) {
            ponteiro = ponteiro.next;
            aux++;
        }
        
        if(ponteiro == null && aux == count) { throw new ObjetoNaoEncontradoException(); }
        
        if(ponteiro == head) {
            head = ponteiro.next;
            head.prev = ponteiro.prev;
        } else {
            (ponteiro.prev).next = ponteiro.next;
            (ponteiro.next).prev = ponteiro.prev;
        }
    }
   
    public void imprimirLista() {
        Element temp = head;

        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
