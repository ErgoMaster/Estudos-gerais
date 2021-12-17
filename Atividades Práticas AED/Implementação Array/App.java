import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        int tamanho = 5;
        Array vetor =  new Array(tamanho);

        // Atribuindo valores inteiros ao array
        for(int i = 0; i < tamanho; i++) {
            System.out.println("Digite o valor " + (i + 1) + " do vetor");
            int elemento = reader.nextInt();
            vetor.setElemento(i, elemento);
        }

        // Impressão do array
        System.out.println("\nArray completo: ");
        for(int i = 0; i < tamanho; i++) { System.out.println(vetor.getElemento(i)); }

        // Teste para a pesquisa de um elemento pelo seu index
        System.out.println("\nDigite o index do elemento desejado");
        int index = reader.nextInt();
        System.out.println("Elemento: " + vetor.getElemento(index));

        // Teste para a modificação da base do vetor
        System.out.println("\nModificando a base do vetor...");
        System.out.println("Digite o valor da nova base");
        int newBase = reader.nextInt();
        vetor.setBase(newBase);
        System.out.println("Teste com a nova base...");
        System.out.println("Digite o index do elemento desejado");
        int index2 = reader.nextInt();
        System.out.println("Elemento: " + vetor.getElemento(index2));

        // Teste para a modificação do tamamho do vetor
        System.out.println("\nModificando o tamanho do vetor...");
        System.out.println("Digite o valor do novo tamanho");
        int newTamanho = reader.nextInt();
        vetor.setLength(newTamanho);
        System.out.println("Teste com o novo tamanho... "); // Caso o novo tamanho seja maior, os novos elementos serão 0
        for(int i = tamanho; i < newTamanho; i++) { vetor.setElemento(i, 0); }
        System.out.println("\nNovo array completo: ");
        for(int i = 0; i < newTamanho; i++) { System.out.println(vetor.getElemento(i)); }

        reader.close();
    }
}
