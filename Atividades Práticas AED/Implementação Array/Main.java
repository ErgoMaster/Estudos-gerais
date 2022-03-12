public class Main {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(5);

        vetor.setElemento(0, 4);
        vetor.setElemento(1, 18);
        vetor.setElemento(2, 13);
        vetor.setElemento(3, 27);
        vetor.setElemento(4, 40);

        System.out.println(vetor);
        
        System.out.println("\n" + vetor.getElemento(2)); // return 13 

        Vetor vetor1 = new Vetor(5);

        vetor1.setElemento(0, 2);
        vetor1.setElemento(1, 14);
        vetor1.setElemento(2, 57);
        vetor1.setElemento(3, 38);
        vetor1.setElemento(4, 51);

        System.out.println("-- Vetor1 antes da atribuição --");
        System.out.println(vetor);

        vetor1.assing(vetor);
        System.out.println("-- Vetor1 depois da atribuição --");
        System.out.println(vetor1);
    }
}
