public class ListaCircular<T> {
    private Element head;
    private int count;
    
    public ListaCircular() {}
    
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
            Element temp = new Element(item, this, this.next);

            this.next = temp;
            this.next.prev = temp;
        }

        public void inserirAntes(T item) {
            Element temp = new Element(item, this.prev, this);

            if(this == head) { head = temp; }
            
            this.prev.next = temp;
            this.prev = temp;
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
     
    public void inserirInicio(T item) {
        switch(count) {
            case 0: {
                Element temp = new Element(item, null, null);
                head = temp;
                break;
            }
            case 1: {
                Element temp = new Element(item, head, head);
                head.prev = temp;
                head.next = temp;
                head = temp;
                break;
            }
            default: {
                Element temp = new Element(item, head.prev, head);
                head.prev.next = temp;
                head.prev = temp;
                head = temp;
                break;
            }
        }
        
        count++;
    }

    public void inserirFim(T item) {
        switch(count) {
            case 0: {
                Element temp = new Element(item, null, null);
                head = temp;
                break;
            }
            case 1: {
                Element temp = new Element(item, head, head);
                head.prev = temp;
                head.next = temp;
                break;
            }
            default: {
                Element temp = new Element(item, head.prev, head);
                head.prev.next = temp;
                head.prev = temp;
                break;
            }
        }
        
        count++;
    }
    
    public void extrair(Object item) throws ObjetoNaoEncontradoException {
        Element ponteiro = head;
        int aux = 0;
        
        while(aux < count && ponteiro.data != item) {
            ponteiro = ponteiro.next;
            aux++;
        }
        
        if(aux == count) { throw new ObjetoNaoEncontradoException(); }
        
        if(ponteiro == head) {
            head = ponteiro.next;
            head.prev = ponteiro.prev;
        } else {
            (ponteiro.prev).next = ponteiro.next;
            (ponteiro.next).prev = ponteiro.prev;
        }

        count--;
    }
    
    @Override
    public String toString() {
        Element temp = head;
        String lista = "[";

        if(estaVazia()) { 
            lista += " ]"; 
            return lista;
        } else {
            for(int i = 0; i < count; i++) {
                if(temp !=  head.prev) {
                    lista += temp.getData() + " ,";
                    temp = temp.next;
                } else {
                    lista += temp.getData();
                }
            }

            lista += "]";
        }

        return lista;
    }

    public void imprimirLista() {
        Element temp = head;

        for(int i = 0; i < count; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
