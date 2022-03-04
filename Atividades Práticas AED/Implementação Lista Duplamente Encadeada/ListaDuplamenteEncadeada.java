public class ListaDuplamenteEncadeada {
    private Element head;
    private Element tail;
    
    public ListaDuplamenteEncadeada() {}
    
    public final class Element {
        Object data;
        Element next, prev;
        
        Element(Object data, Element prev, Element next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        
        public void inserirDepois(Object item) {
            Element temp = new Element(item, this, next);
            next = temp;
            
            if(tail == this) { tail = next; }
            else { temp.next.prev = temp; }
        }

        public void inserirAntes(Object item) {
            Element temp = new Element(item, prev, this);
            prev = temp;
            
            if(head == this) { head = temp; }
            else { temp.prev.next = temp; }
        }
    }
    
    public Element getTail() { return tail; }
    public Element getHead() { return head; }
    
    public boolean estaVazia() { return (head == null); }
    
    public Object getPrimeiro() throws ListaVaziaException {
        if(estaVazia()) { throw new ListaVaziaException(); }
        else { return head.data; }
    }

    public Object getUltimo() throws ListaVaziaException {
        if(estaVazia()) { throw new ListaVaziaException(); }
        else { return tail.data; }
    }
     
    public void inserirInicio(Object item) {
        Element temp = new Element(item, null, head);
        
        if(head == null) { temp = tail; }
        else { head.prev = temp; }
        
        head = temp;
    }
    
    public void inserirFim(Object item) {
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
