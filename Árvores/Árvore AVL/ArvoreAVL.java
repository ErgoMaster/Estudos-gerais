import java.util.LinkedList;
import java.util.Queue;

public class ArvoreAVL<T> {
    private Node<T> raiz;

    // Construtor
    public ArvoreAVL(Node<T> raiz) {
        this.raiz = raiz;
    }

    // Métodos get
    public Node<T> getRaiz() { return raiz; }

    // Verifica se é uma árvore avl
    public boolean verifyAVL() {
        boolean resultado = true;

        Queue fila = new LinkedList<Node<T>>();
        fila.add(raiz);

        while(!fila.isEmpty()) {
            Node<T> node = null;
            node = (Node<T>) fila.poll();

            int balanceamento = 0;

            if(node.getFilhoEsquerda() != null) { fila.add(node.getFilhoEsquerda()); }
            if(node.getFilhoDireita() != null) { fila.add(node.getFilhoDireita()); }

            if(!node.ehFolha()) { 
                if(node.getFilhoEsquerda() == null) { balanceamento =  -(node.getFilhoDireita().calcularAlturaEmLargura() + 1); } 
                else { balanceamento = (node.getFilhoEsquerda().calcularAlturaEmLargura() + 1); }
            }

            if(balanceamento < -1 || balanceamento > 1) { 
                resultado = false; 
                fila.clear();
            }
        }

        return resultado;
    }

    // Cosntruir a árvore AVL
    public void inserirNode(T valor) {

    }
}