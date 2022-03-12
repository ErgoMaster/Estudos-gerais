public class Main {
    public static void main(String[] args) {
        InfixToPosfix programa = new InfixToPosfix("5+6*4/7");
        programa.operate();

        System.out.println("Expressão inicial: " + programa.getExpIn());
        System.out.println("Expressão pósfixa: " + programa.getExpOut());
    }
}
