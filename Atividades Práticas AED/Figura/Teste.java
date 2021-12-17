import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        System.out.println("Digite as coordenadas do centro do cilindro\nX:");
        int x = reader.nextInt();
        System.out.println("Y:");
        int y = reader.nextInt();

        // Teste do círculo
        System.out.println("\nDigite o raio do circulo");
        double raio = reader.nextDouble();
        Circulo circulo = new Circulo(raio, x, y);
        System.out.println(circulo.toString());

        // Teste do cilindro
        System.out.println("\nDigite a altura do cilindro");
        double altura = reader.nextDouble();
        Cilindro cilindro = new Cilindro(altura, raio);
        System.out.println(cilindro.toString());

        reader.close();
    }
}
