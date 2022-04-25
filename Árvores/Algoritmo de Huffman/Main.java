import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Huffman programa = new Huffman();
        StringBuilder texto0 = new StringBuilder();
        StringBuilder texto1 = new StringBuilder();
        String textoCodificado = null;
        String textoDecodificado = null;
        int tamanhoDoTexto = 0;
        int tamanhoDoTextoCodificado = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            String linha;

            while((linha = reader.readLine()) != null) {
                texto0.append(linha);
            }

            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("textCodificado.txt"));
            textoCodificado = programa.codificar(texto0.toString());
            tamanhoDoTexto = texto0.length() * 8;
            tamanhoDoTextoCodificado = textoCodificado.length();

            writer.write(textoCodificado);
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        } 

        System.out.println("Texto inicial:\n\n" + texto0);
        System.out.println("\nTexto Codificado:\n\n" + textoCodificado);
        System.out.println("\nTamanho do texto inicial: " + tamanhoDoTexto);
        System.out.println("Tamanho do texto codificado: " + tamanhoDoTextoCodificado);
        System.out.println("Texto diminuído em: " + (100 - (tamanhoDoTextoCodificado * 100 / tamanhoDoTexto)) + "%");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("textCodificado.txt"));
            String linha;

            while((linha = reader.readLine()) != null) {
                texto1.append(linha);
            }

            textoDecodificado = programa.decodificar(texto1.toString());
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n================================================");
        System.out.println("\nTexto Codificado:\n\n" + textoCodificado);
        System.out.println("\nTexto Decodificado:\n\n" + textoDecodificado);
    }
}