import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huffman {
    private Node raiz;

    // Pega uma string e tranforma em uma cadeia de caracteres
    private char[] stringToChar(String texto) {
        char[] resultado = new char[texto.length()];
        texto.getChars(0, texto.length(), resultado, 0);

        return resultado;
    }

    // retorna a fila de prioridade, isto é, a fila de frequência dos caracteres dentro de um texto
    private PriorityQueue<Node> getFilaDePrioridade(char[] texto) {
        Map<Character, Node> count = new HashMap<>();

        for(char aux : texto) {
            if(!count.containsKey(aux)) {
                count.put(aux, new Node(aux));
            }

            count.get(aux).add();
        }

        return new PriorityQueue<>(count.values());
    }

    // Cria a arvore binaria com as frequencias dos caracteres do texto
    private Node criarArvoreBinaria(PriorityQueue<Node> fila) {
        while(true) {
            // Pega os dois nodes de menor frequencia
            Node node1 = fila.poll();
            Node node2 = fila.poll();

            // Adiciona um pai a eles, com frequência igual a soma das frequências dos filhos
            Node nodePai = new Node(node1, node2);

            // Condição de parada: se a fila ficar vazia, retorna a raiz da arvore
            if(fila.isEmpty()) { return nodePai; }

            // Caso contrário, adiciona o node a fila para que possa receber um node pai
            fila.add(nodePai);
        }
    }

    // Incia a criação do code map a partir do node raiz
    private Map<Character, String> iniciaCodeMap() {
        Map<Character, String> resultado = new TreeMap<>();
        raiz.criarCodeMap(resultado, "");
        return resultado;
    }

    public String codificar(String texto) {
        char[] mensagem = stringToChar(texto); // Pega o texto e transforma em uma cadeia de caracteres
        raiz = criarArvoreBinaria(getFilaDePrioridade(mensagem)); // Cria a arvore binaria passando como parametro a lista de frequencias, dado o texto
        Map<Character, String> codemap = iniciaCodeMap(); // Cria o code map com as informacoes das frequencias de cada caractere

        StringBuilder data = new StringBuilder(); // String para guardar o texto codificado

        for(char aux : mensagem) {
            data.append(codemap.get(aux)); // Pega o codigo gerado dentro do code map de cada caractere do texto
        }

        return data.toString(); // Retorna o texto codificado em binário
    }

    public String decodificar(String texto) {
        Node index = raiz; // O algoritmo irá começar percorrer a árvore a partir da raiz
        char[] textoAux = stringToChar(texto);

        StringBuilder data = new StringBuilder(); // String para guardar o texto decodificado

        for(char aux : textoAux) { 
            if(aux == '0') { index = index.getFilhoEsquerda(); } // Se for igual a 0, percorre a sub arvore da esquerda
            else { index = index.getFilhoDireita(); } // Se for igual a 1, percorre a sub arvore da direita

            if(index.ehFolha()) { // Quando achar uma folha vem para esse if
                data.append(index.getData()); // Pega o valor do node e insere na string
                index = raiz; // Volta a raiz para começar o processo novamente
            }
        }

        return data.toString(); // Retorna o texto decodificado
    }
}
