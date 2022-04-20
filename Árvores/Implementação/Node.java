import java.util.Stack;
import FilaEncadeada.CountVazioException;
import FilaEncadeada.FilaEncadeada;

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

    protected void imprimeEmPreOrdem() {
        System.out.print(this.getValor() + " ");

        if(this.getFilhoEsq() != null) { this.getFilhoEsq().imprimeEmPreOrdem(); }
        if(this.getFilhoDir() != null) { this.getFilhoDir().imprimeEmPreOrdem(); }
    }

    protected void imprimeEmPosOrdem() {
        if(this.getFilhoEsq() != null) { this.getFilhoEsq().imprimeEmPosOrdem(); }
        if(this.getFilhoDir() != null) { this.getFilhoDir().imprimeEmPosOrdem(); }

        System.out.print(this.getValor() + " ");
    }

    protected void imprimeEmLargura() {
        FilaEncadeada fila = new FilaEncadeada();
        fila.enfileirar(this);

        while(!fila.estaVazia()) {
            Node<T> node = null;
            try { node = (Node<T>) fila.desenfileirar(); } 
            catch (CountVazioException e) { e.printStackTrace(); }
            

            if(node.getFilhoEsq() != null) { fila.enfileirar(node.getFilhoEsq()); }
            if(node.getFilhoDir() != null) { fila.enfileirar(node.getFilhoDir()); }

            System.out.print(node.getValor() + " ");
        }
    }

    protected void imprimeEmLarguraRecursivo() {
        FilaEncadeada fila = new FilaEncadeada();
        fila.enfileirar(this);
        imprimeEmLarguraRecursivo(fila);
    }

    private void imprimeEmLarguraRecursivo(FilaEncadeada fila) {
        Node<T> node = null;
        try { node = (Node<T>) fila.desenfileirar(); } 
        catch (CountVazioException e) { e.printStackTrace(); }

        if(node.getFilhoEsq() != null) { fila.enfileirar(node.getFilhoEsq()); }
        if(node.getFilhoDir() != null) { fila.enfileirar(node.getFilhoDir()); }

        System.out.print(node.getValor() + " ");

        if(!fila.estaVazia()) {
            this.imprimeEmLarguraRecursivo(fila);
        }
    }

    protected void imprimeEmLarguraInvertido() {
        FilaEncadeada fila = new FilaEncadeada();
        Stack<T> pilha = new Stack<T>();

        fila.enfileirar(this);

        while(!fila.estaVazia()) {
            Node<T> node = null;
            try { node = (Node<T>) fila.desenfileirar(); } 
            catch (CountVazioException e) { e.printStackTrace(); }

            if(node.getFilhoEsq() != null) { fila.enfileirar(node.getFilhoEsq()); }
            if(node.getFilhoDir() != null) { fila.enfileirar(node.getFilhoDir()); }

            pilha.push(node.getValor());
        }

        imprimePilha(pilha);
    }

    private void imprimePilha(Stack<T> pilha) {
        while(!pilha.empty()) {
            System.out.print(pilha.pop() + " ");
        }
    }

    protected int calcularAltura() {
        int alturaFilhoEsquerda = 0;
        int alturaFilhoDireita = 0;

        if(this.getFilhoEsq() != null) { alturaFilhoEsquerda = this.getFilhoEsq().calcularAltura() + 1; }
        if(this.getFilhoDir() != null) { alturaFilhoDireita = this.getFilhoDir().calcularAltura() + 1; }

        if(alturaFilhoEsquerda > alturaFilhoDireita) { return alturaFilhoEsquerda; }
        else { return alturaFilhoDireita; }
    }

    protected int calcularAlturaEmLargura() {
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

            if(node.getFilhoEsq() != null) {
                filaObjetos.enfileirar(node.getFilhoEsq());
                filaDistancias.enfileirar(distanciaPai + 1);
            }
            if(node.getFilhoDir() != null) {
                filaObjetos.enfileirar(node.getFilhoDir());
                filaDistancias.enfileirar(distanciaPai + 1);
            } 

            if(distanciaPai > alturaMaxima) { alturaMaxima = distanciaPai; }
        }

        return alturaMaxima;
    }

    protected Node<T> pesquisarValor(T valor) {
        int comparacao = valor.toString().compareTo(this.getValor().toString());
        Node<T> temp;

        if(comparacao < 0) {
            if(this.getFilhoEsq() != null) { temp = this.getFilhoEsq().pesquisarValor(valor); } 
            else { temp = null; }
        } else if(comparacao > 0) {
            if(this.getFilhoDir() != null) { temp = this.getFilhoDir().pesquisarValor(valor); } 
            else { temp = null; }
        } else {
            temp = this;
        }

        if(temp == null) { temp = (Node<T>) new Node<Integer>(-1); }

        return temp;
    }

    protected int calcularNumeroNodesFolhas() {
        int totalEsq = 0;
        int totalDir = 0;
        boolean ehFolha = true;

        if(this.getFilhoEsq() != null) { 
            totalEsq = this.getFilhoEsq().calcularNumeroNodesFolhas(); 
            ehFolha = false;
        }
        if(this.getFilhoDir() != null) { 
            totalDir = this.getFilhoDir().calcularNumeroNodesFolhas(); 
            ehFolha = false;
        }

        if(ehFolha) { return 1; }
        else { return (totalDir + totalEsq); }
    }

    protected boolean removerNode(T valor, Node<T> nodePai) {
        boolean resultado = false;
        int comparacao = valor.toString().compareTo(this.getValor().toString());
        
        if(comparacao < 0) {
            if(this.getFilhoEsq() != null) { return this.getFilhoEsq().removerNode(valor, this); } 
            else { resultado = false; }
        }
        if(comparacao > 0) {
            if(this.getFilhoDir() != null) { return this.getFilhoDir().removerNode(valor, this); } 
            else { resultado = false; }
        } else {

        }


        return resultado;
    }

    private void setFilhoNode(Node<T> nodePai, Node<T> novoNode) {
        if(nodePai.getFilhoEsq() == this) { nodePai.setFilhoEsq(novoNode); }
        if(nodePai.getFilhoDir() == this) { nodePai.setFilhoDir(novoNode); }
    }

    private Node<T> nodeComMaiorValor() {
        if(this.getFilhoDir() != null) { return this.getFilhoDir().nodeComMaiorValor(); } 
        else { return this; }
    }

    private Node<T> nodeComMenorValor() {
        if(this.getFilhoEsq() != null) { return this.getFilhoEsq().nodeComMenorValor(); } 
        else { return this; }
    }

    private Node<T> acharPai(Node<T> nodeFilho) {
        if(this.getFilhoEsq() == nodeFilho || this.getFilhoDir() == nodeFilho) { 
            return this; 
        } else {
            if(nodeFilho.getValor().toString().compareTo(this.getValor().toString()) > 0) {
                
            }
        }
    } 
}