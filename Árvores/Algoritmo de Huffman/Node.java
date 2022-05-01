import java.util.Map;

public class Node implements Comparable<Node> {
    private char data;
    private int frequencia = 0;

    private Node filhoEsquerda;
    private Node filhoDireita;

    // Contrutores
    public Node(char data, int frequencia) {
        this.data = data;
        this.frequencia = frequencia;
    }
    public Node(char data) {
        this.data = data;
    }
    public Node(Node filhoEsquerda, Node filhoDireita) {
        this.data = '+';
        this.filhoEsquerda = filhoEsquerda;
        this.filhoDireita = filhoDireita;
    }

    // Incrementa a frequência em 1, usado na hora de criar a tabela de frequências
    public void aumentarFrequencia() {
        frequencia++;
    }

    // Verifica se o node é folha ou não
    public boolean ehFolha() {
        return (filhoEsquerda == null && filhoDireita == null);
    }

    // Constrói o code map usando uma busca em profundidade, em que cada caractere terá sua sequência binária correspondente
    public void construirCodeMap(Map<Character, String> codemap, String codigo) {
        if(this.ehFolha()) { // Verifica se o node atual é folha
            // Se for folha, apenas coloca no codemap o seu valor e o codigo gerado até então
            codemap.put(this.getData(), codigo);
            return;
        }

        /* Se não for folha, continua percorrendo pela árvore, percorrendo para a esquerda, 
        o valor 0 será adicionado ao código, percorrendo para a direita, será o valor 1 */
        if(this.getFilhoEsquerda() != null) { this.filhoEsquerda.construirCodeMap(codemap, codigo + "0"); }
        if(this.getFilhoDireita() != null) { this.filhoDireita.construirCodeMap(codemap, codigo + "1"); }
    } 

    // Métodos get
    public Node getFilhoEsquerda() { return filhoEsquerda; }
    public Node getFilhoDireita() { return filhoDireita; }
    public char getData() { return data; }

    // Retorna a frequência do node
    public int getFrequencia() {
        if(this.ehFolha()) { return frequencia; }

        return this.getFilhoEsquerda().getFrequencia() + this.getFilhoDireita().getFrequencia();
    }

    @Override
    public int compareTo(Node node) {
        return this.getFrequencia() - node.getFrequencia();
    }

    @Override
    public String toString() {
        String aux = data == '\n' ? "\\n" : "" + data;

        return String.format("'%s': %d", aux, this.getFrequencia());
    }
}
