public class Main {
    public static void main(String[] args) {
        InfixToPrefix programa = new InfixToPrefix("(7+2)*1");
        programa.operate();

        System.out.println("Expressão inicial: " + programa.getExpIn());
        System.out.println("Expressão préfixa: " + programa.getExpOut());
    }
}
