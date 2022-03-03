public class ListaEncadeada {
    private Element head;
    private Element tail;
    
    public ListaEncadeada() {}
    
    public final class Element { 
        Object data;
        Element next;

        Element (Object data, Element next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() { return data; }
        public Element getNext() { return next; }

        public void inserirDepois(Object item) {
            next = new Element(item, next);

            if(tail == this) { tail = next; }
        }

        public void inserirAntes(Object item) {
            Element temp = new Element(item, this);

            if(this == head) { head = temp; }
            else {
                Element tempAnterior = head;

                while(tempAnterior != null && tempAnterior != this) {
                    tempAnterior = tempAnterior.next;
                }

                tempAnterior.next = temp;
            }
        }
    }
    
    public void fazVazia() {
        head = null;
        tail = null;
    }
    
    public Element getHead() { return head; }
    public Element getTail() { return tail; }
    
    public boolean estaVazia() { return (head == null); }
    
    public Object getPrimeiro() throws ListaVaziaException {
        if (head == null) { throw new ListaVaziaException(); }
        else { return head.data; }
    }

    public Object getUltimo() throws ListaVaziaException {
        if (tail == null) { throw new ListaVaziaException(); }
        else { return tail.data; }
    }
    
    public void inserirInicio(Object item) {
        Element temp = new Element(item, head);
        
        if(estaVazia()) { tail = temp; }
        head = temp;
    }
    
    public void inserirFim(Object item) {
        Element temp = new Element(item, null);
        
        if(estaVazia()) { head = temp; }
        else { tail.next = temp; }
        
        tail = temp;
    }
    
    public void atribuir(ListaEncadeada lista1) {
        if(this != lista1) {
            this.fazVazia();
            
            for(Element i = lista1.head; i != null; i = i.next) {
                this.inserirFim(i.data);
            }
        }
    }
    
    public void extrair(Object item) throws ObjetoNaoEncontradoException {
        Element ponteiro = head;
        Element ponteiroAnterior = null;
        
        while(ponteiro != null && ponteiro.data != item) {
            ponteiroAnterior = ponteiro;
            ponteiro = ponteiro.next;
        }
        
        if(ponteiro == null) { throw new ObjetoNaoEncontradoException(); }

        if(ponteiro == head) { head = ponteiro.next; } 
        else { ponteiroAnterior.next = ponteiro.next; }

        if(ponteiro == tail) { tail = ponteiroAnterior; }
    }

    public void imprimirLista() {
        Element temp = head;

        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
