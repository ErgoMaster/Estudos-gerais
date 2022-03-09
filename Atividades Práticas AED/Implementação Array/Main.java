public class Main {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(5);

        vetor.setElemento(0, 4);
        vetor.setElemento(1, 18);
        vetor.setElemento(2, 13);
        vetor.setElemento(3, 27);
        vetor.setElemento(4, 40);

        try {
            vetor.imprimirArray();
        } catch (VetorVazioException e) {
            System.out.println("Vetor vazio");
        }
        
        System.out.println("\n" + vetor.getElemento(2)); // return 13 

        Vetor vetor1 = new Vetor(5);

        vetor1.setElemento(0, 2);
        vetor1.setElemento(1, 14);
        vetor1.setElemento(2, 57);
        vetor1.setElemento(3, 38);
        vetor1.setElemento(4, 51);

        try {
            System.out.println("-- Vetor1 antes da atribuição --");
            vetor1.imprimirArray();

            vetor1.assing(vetor);
            System.out.println("-- Vetor1 depois da atribuição --");
            vetor1.imprimirArray();
        } catch (VetorVazioException e) {
            System.out.println("Vetor vazio");
        }
    }
}
