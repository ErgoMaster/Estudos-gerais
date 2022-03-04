public class ListaDuplamenteEncadeadaParametrizada<T> {
    private T head;
    private T tail;
    
    public ListaDuplamenteEncadeada() {}
    
    public final class Element {
        T data;
        T next, prev;
        
        Element(T data, T prev, T next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        
        public void inserirDepois(T item) {
            Element temp = new Element(item, this, next);
            next = temp;
            
            if(tail == this) { tail = next; }
            else { temp.next.prev = temp; }
        }

        public void inserirAntes(T item) {
            Element temp = new Element(item, prev, this);
            prev = temp;
            
            if(head == this) { head = temp; }
            else { temp.prev.next = temp; }
        }
    }
    
    public T getTail() { return tail; }
    public T getHead() { return head; }
    
    public boolean estaVazia() { return (head == null); }
    
    public T getPrimeiro() throws ListaVaziaException {
        if(estaVazia()) { throw new ListaVaziaException(); }
        else { return head.data; }
    }

    public T getUltimo() throws ListaVaziaException {
        if(estaVazia()) { throw new ListaVaziaException(); }
        else { return tail.data; }
    }
     
    public void inserirInicio(T item) {
        Element temp = new Element(item, null, head);
        
        if(head == null) { temp = tail; }
        else { head.prev = temp; }
        
        head = temp;
    }
    
    public void inserirFim(T item) {
        Element temp = new Element(item, tail, null);
        
        if(head == null) { head = temp; }
        else { tail.next = temp; }
        
        tail = temp;
    }
    
    public void extrair(Object item) throws ObjetoNaoEncontradoException {
        Element ponteiro = head;
        
        while(ponteiro != null && ponteiro.data != item) {
            ponteiro = ponteiro.next;
        }
        
        if(ponteiro == null) { throw new ObjetoNaoEncontradoException(); }
        
        if(ponteiro == head) {
            head = ponteiro.next;
            head.prev = null;
        }
        
        if(ponteiro == tail) {
            tail = ponteiro.prev;
            tail.next = null;
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
