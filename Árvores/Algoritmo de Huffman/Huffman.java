import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huffman {
    private Node raiz;

    // Irá pegar o texto a ser comprimido e irá montar uma tabela com os nodes que contem o caractere e quantas vezes ele aparece no texto (sua frequencia)
    private PriorityQueue<Node> getTabelaFrequencias(char[] texto) {
        Map<Character, Node> map = new HashMap<>(); // Cria um hashmap para guardar os caracteres e suas respectivas frequencias

        for(char aux : texto) { // Percorre pelo texto
            if(!map.containsKey(aux)) { // Verifica se o caractere está ou não no hashmap
                // Se não estiver, cria um novo node com o caractere passado como argumento no construtor
                map.put(aux, new Node(aux));
            }

            // Foi encontrado um novo caractere, logo deve-se aumentar a frequencia dele em 1
            map.get(aux).aumentarFrequencia();
        }

        // Cria uma fila de prioridade, isto é, uma fila em que os nodes de menor frequência vem primeiro na lista
        return new PriorityQueue<>(map.values()); 
    }

    // Pega um determinado texto e passa de String para um array de caracteres
    private char[] getCharFromString(String texto) {
        char[] mensagem = new char[texto.length()];
        texto.getChars(0, texto.length(), mensagem, 0);
        return mensagem;
    }

    // Cria a arvore binária que será utilizada na compressão do arquivo
    private Node criarArvore(PriorityQueue<Node> fila) {
        while(true) {
            // Pega os dois nodes de menor frequencia da fila
            Node node1 = fila.poll();
            Node node2 = fila.poll();

            // Cria um pai para esses nodes (a frequencia desse pai sera igual a soma das frequencias de seus filhos)
            Node pai = new Node(node1, node2); // Esse pai não corresponderá a nenhum caractere, logo ele recebe '+' como dado

            // verifica se a fila ficou vazia
            if(fila.isEmpty()) {
                // Se está vazia, retorna o node raiz da árvore
                return pai;
            }

            // Se não está vazia, adiciona o node pai de volta na lista para que possa receber um novo pai
            fila.add(pai);
        }
    }

    // Cria um map em que cada caractere ira receber uma String de valores binários que irá representar esse caractere dentro da codificação
    private Map<Character, String> criarCodeMap() {
        Map<Character, String> codemap = new TreeMap<>(); // Cria um map vazio
        raiz.construirCodeMap(codemap, ""); // Inicia a criação do map pela raiz, passando uma String vazia de inicio

        return codemap; // Retorna esse map
    }

    // Para a codificação, devemos pegar essa tabela caractere/binário e passar a sequência para uma String
    private String codificarString(String texto) {
        char[] mensagem = getCharFromString(texto); // Transforma o texto em um array de caracteres
        raiz = criarArvore(getTabelaFrequencias(mensagem)); // Cria a árvore binária
        Map<Character, String> codemap = criarCodeMap(); // Cria o codemap (tabela caractere/binário)

        StringBuilder codigo = new StringBuilder(); // String que representará o código
        for(char aux : mensagem) { // Percorre o texto letra a letra
            codigo.append(codemap.get(aux)); // Pega o valor binário do caractere e o concatena a string do codigo
        }

        return codigo.toString(); // Retorna a string do código
    } 
    
    // Pega o código que está em string e o transforma em um array de booleanos 
    public boolean[] codificarBoolean(String texto) {
        char[] mensagem = getCharFromString(codificarString(texto)); // Transforma o codigo em um array de caracteres
        boolean[] array = new boolean[mensagem.length]; // Array de booleanos que será o resultado final
        int index = 0;

        for(char aux : mensagem) {
            if(aux == '0') { array[index] = false; }
            else { array[index] = true; }

            index++;
        }

        return array;
    }

    /* Pega o array de booleanos e percorre por ele dados dos bits do array. Se for 0, percorre a árvore pelo node da esquerda e caso seja 1,
    percorre a árvore pelo node da direita. Se faz isso até encontrar um node folha e se imprime o valor desse node. Faz essa processo até 
    terminar o array de booleanos */
    public String decodificar(boolean[] array) {
        Node atual = raiz; // Começa pela raiz da árvore
        StringBuilder resultado = new StringBuilder(); // String do texto decodificado

        for(boolean aux : array) { // Percorre o array de booleanos
            // Verifica o valor, caso seja falso (0), vá para o node da esquerda, caso seja true (1), vá para o node da direita
            if(aux == false) { atual = atual.getFilhoEsquerda(); }
            else { atual = atual.getFilhoDireita(); }

            // Verifica se o node atual é folha ou não
            if(atual.ehFolha()) {
                resultado.append(atual.getData()); // Adiciona o caractere a string
                atual = raiz; // Volta para a raiz começar o processo novamente
            }
        }

        return resultado.toString(); // Retorna a string com o texto decodificado
    } 
}
