public class ListaParametrizada<T> {
    private Element head;
    private Element tail;
    
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
        
        public Object getData() { return data; }
        
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
    
    public Element getTail() { return tail; }
    public Element getHead() { return head; }
    
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
        
        if(head == null) { tail = temp; }
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
   
    @Override
    public String toString() {
        Element temp = head;
        String lista = "[";

        if(estaVazia()) { 
            lista += " ]"; 
            return lista;
        } else {
            while(temp != null) {
                if(temp != tail) { lista = lista + temp.getData() + ", "; } 
                else { lista += temp.getData(); } 
                
                temp = temp.next;
            }

            lista += "]";
        }

        return lista;
    }
}
