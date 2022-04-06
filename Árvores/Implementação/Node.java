public class Node<T> {
    private T valor;
    private Node<T> filho_esq, filho_dir;

    // Construtores
    public Node(T valor) {
        this.valor = valor;
    }
    public Node(T valor, Node<T> filho_esq, Node<T> filho_dir) {
        this.valor = valor;
        this.filho_dir = filho_dir;
        this.filho_esq = filho_esq;
    }

    // Métodos get
    public T getValor() { return valor; }
    public Node<T> getFilhoEsq() { return filho_esq; }
    public Node<T> getFilhoDir() { return filho_dir; }

    // Métodos set
    public void setValor(T valor) { this.valor = valor; }
    public void setFilhoEsq(Node<T> filho_esq) { this.filho_esq = filho_esq; }
    public void setFilhoDir(Node<T> filho_dir) { this.filho_dir = filho_dir; }

    public boolean inserirNodeOrdenado(T valor) {
        if(valor.toString().compareTo(getValor().toString()) < 0) {
            if(getFilhoEsq() != null) {
                return this.getFilhoEsq().inserirNodeOrdenado(valor);
            } else {
                this.setFilhoEsq(new Node<T>(valor));
                return true;
            }
        } else {
            if(getFilhoDir() != null) {
                return this.getFilhoDir().inserirNodeOrdenado(valor);
            } else {
                this.setFilhoDir(new Node<T>(valor));
                return true;
            }
        }
    }

    protected void imprimeOrdemCrescente() {        
        if(this.getFilhoEsq() != null) { this.getFilhoEsq().imprimeOrdemCrescente(); }

        System.out.print(this.getValor() + " ");

        if(this.getFilhoDir() != null) { this.getFilhoDir().imprimeOrdemCrescente(); }
    }

    protected void imprimeOrdemDecrescente() {        
        if(this.getFilhoDir() != null) { this.getFilhoDir().imprimeOrdemDecrescente(); }

        System.out.print(this.getValor() + " ");

        if(this.getFilhoEsq() != null) { this.getFilhoEsq().imprimeOrdemDecrescente(); }
    }
}