import FilaEncadeada.*;

public class Node<T> {
    private T valor;
    private Node<T> filhoEsquerda;
    private Node<T> filhoDireita;

    // Construtores
    public Node(T valor) {
        this.valor = valor;
    } 
    public Node(T valor, Node<T> filhoEsquerda, Node<T> filhoDireita) {
        this.valor = valor;
        this.filhoEsquerda = filhoEsquerda;
        this.filhoDireita = filhoDireita;
    }

    // Métodos get
    public T getValor() { return valor; }
    public Node<T> getFilhoEsquerda() { return filhoEsquerda; }
    public Node<T> getFilhoDireita() { return filhoDireita; }

    // Métodos set
    public void setValor(T valor) { this.valor = valor; }
    public void setFilhoEsquerda(Node<T> filhoEsquerda) { this.filhoEsquerda = filhoEsquerda; }
    public void setFilhoDireita(Node<T> filhoDireita) { this.filhoDireita = filhoDireita; }

    // Verifica se o node é folha
    public boolean ehFolha() {
        return (getFilhoEsquerda() == null && getFilhoDireita() == null);
    }

    // Retorna a altura do node
    public int calcularAlturaEmLargura() {
        FilaEncadeada filaObjetos = new FilaEncadeada();
        FilaEncadeada filaDistancias = new FilaEncadeada();

        filaObjetos.enfileirar(this);
        filaDistancias.enfileirar(0);

        int alturaMaxima = 0;

        while(!filaObjetos.estaVazia()) {
            Node<T> node = null;
            try { node = (Node<T>) filaObjetos.desenfileirar(); } 
            catch (CountVazioException e) { e.printStackTrace(); }

            int distanciaPai = 0;
            try { distanciaPai = (int) filaDistancias.desenfileirar(); } 
            catch (CountVazioException e) { e.printStackTrace(); }

            if(node.getFilhoEsquerda() != null) {
                filaObjetos.enfileirar(node.getFilhoEsquerda());
                filaDistancias.enfileirar(distanciaPai + 1);
            }
            if(node.getFilhoDireita() != null) {
                filaObjetos.enfileirar(node.getFilhoDireita());
                filaDistancias.enfileirar(distanciaPai + 1);
            } 

            if(distanciaPai > alturaMaxima) { alturaMaxima = distanciaPai; }
        }

        return alturaMaxima;
    }

    // Construir uma árvore binária que não é avl
    public boolean inserirNodeOrdenado(T valor) {
        if(valor.toString().compareTo(getValor().toString()) < 0) {
            if(getFilhoEsquerda() != null) {
                return this.getFilhoEsquerda().inserirNodeOrdenado(valor);
            } else {
                this.setFilhoEsquerda(new Node<T>(valor));
                return true;
            }
        } else {
            if(getFilhoDireita() != null) {
                return this.getFilhoDireita().inserirNodeOrdenado(valor);
            } else {
                this.setFilhoDireita(new Node<T>(valor));
                return true;
            }
        }
    }

    // Construir árvore binária que já é avl
}
