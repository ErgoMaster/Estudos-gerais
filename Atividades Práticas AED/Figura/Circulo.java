public class Circulo extends Ponto {
    private double raio;

    public Circulo(double raio) { this.raio = raio; }
    public Circulo(double raio, int x, int y) { 
        super(x, y);
        this.raio = raio; 
    }

    // Método get:
    public double getRaio() { return raio; }

    // Método set:
    public void setRaio(double raio) { this.raio = raio; }

    // Calcular área do círculo:
    public double areaCirculo() { return (Math.PI * raio * raio); }

    // Imprimir informações do círculo:
    public String toString() {
        return "Centro = " + super.toString() +
        "\nRaio = " + getRaio(); 
    }
}
