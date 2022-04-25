import java.util.Map;

public class Node implements Comparable<Node> {
    private char data;
    private int count;

    private Node filhoEsquerda;
    private Node filhoDireita;

    public Node(char data) {
        this.data = data;
    }
    public Node(Node filhoEsquerda, Node filhoDireita) {
        this.data = '+';
        this.filhoEsquerda = filhoEsquerda;
        this.filhoDireita = filhoDireita;
    }

    // Métodos get
    public char getData() { return data; }
    public Node getFilhoEsquerda() { return filhoEsquerda; }
    public Node getFilhoDireita() { return filhoDireita; }

    // Verifica se o node é folha ou não
    public boolean ehFolha() { return (filhoEsquerda == null && filhoDireita == null); }

    // Retorna a frequência de um node
    public int getFrequenciaDoNode() {
        if(this.ehFolha()) {
            return this.count;
        } 

        return filhoEsquerda.getFrequenciaDoNode() + filhoDireita.getFrequenciaDoNode();
    }

    public void add() { count++; }

    @Override
    public int compareTo(Node node) { return this.getFrequenciaDoNode() - node.getFrequenciaDoNode(); }

    // Cria um code map para guardar os caracteres e seus representativos binarios
    public void criarCodeMap(Map<Character, String> codemap, String texto) {
        if(this.ehFolha()) {
            codemap.put(getData(), texto);
            return;
        }

        this.filhoEsquerda.criarCodeMap(codemap, texto + "0");
        this.filhoDireita.criarCodeMap(codemap, texto + "1");
    }

    @Override
    public String toString() {
        String aux = data == '\n' ? "\\n" : "" + data;

        return String.format("'%s': %d", aux, getFrequenciaDoNode());
    } 
}
