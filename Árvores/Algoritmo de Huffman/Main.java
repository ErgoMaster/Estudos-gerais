import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Huffman programa = new Huffman();
        String texto = ""; // Texto para ler do arquivo e ser codificado
        String textoCodificado = ""; // Texto codificado antes de ir para o arquivo

        // Lê do arquivo txt o texto que será codificado
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Texto.txt"));
            String aux;

            while((aux = reader.readLine()) != null) {
                texto += aux;
            }
            
            reader.close();
            System.out.println("\nTexto inicial: " + texto);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Array de booleanos que irá representar o texto codificado
        boolean[] codigo = programa.codificarBoolean(texto);

        // Pega o array e constroi a string (para proposito de apresentar na tela antes de passar para o arquivo)
        for(boolean aux : codigo) { // Percorre o array
            // False = "0" / True = "1"
            if(aux == false) { textoCodificado += "0"; } 
            else { textoCodificado += "1"; }
        } 

        System.out.println("\n\nTexto codificado: " + textoCodificado);

        // Escreve em outro arquivo esse array de booleanos
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("TextoCodificado.bin"));
            writer.writeObject(codigo);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Impressão do resultado da compressão
        System.out.println("\n\nTamanho do texto incial: " + texto.length() * 8);
        System.out.println("Tamanho do texto codificado: " + textoCodificado.length());
        System.out.println("Taxa de redução: " + (100 - (textoCodificado.length() * 100 / (texto.length() * 8))) + "%");
        System.out.println("\n==================================================\n");

        // Lê o arquivo codificado 
        boolean[] codigo1 = null;
        String textoCodificado1 = "";

        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream("TextoCodificado.bin"));
            codigo1 = (boolean[]) reader.readObject();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Pega o array e constroi a string (para proposito de apresentar na tela antes de pegar do arquivo)
        for(boolean aux : codigo1) { // Percorre o array
            // False = "0" / True = "1"
            if(aux == false) { textoCodificado1 += "0"; } 
            else { textoCodificado1 += "1"; }
        } 

        // Decodificação
        String textoDecodificado1 = programa.decodificar(codigo1);
        System.out.println("Texto codificado: " + textoCodificado1);
        System.out.println("\n\nTexto decodificado: " + textoDecodificado1 + "\n");
    }
}
