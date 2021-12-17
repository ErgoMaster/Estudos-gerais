public class Cilindro extends Circulo {
    private double altura;

    public Cilindro(double altura, double raio) {
        super(raio);
        this.altura = altura;
    }
    public Cilindro(double altura, double raio, int x, int y) {
        super(raio, x, y);
        this.altura = altura;
    }

    // Método get
    public double getAltura() { return altura; }

    // Método set
    public void setAltura(double altura) { this.altura = altura; }

    // Métodos para cálculo de área e volume do cilindro
    public double areaCilindro() { return (2 * areaCirculo() + 2 * Math.PI * getRaio() * getAltura()); }
    public double volumeCilindro() { return (areaCirculo() * getAltura()); }

    // Imprimir as informações do cilindro
    public String toString() {
        return super.toString() +
        "\nArea total = " + areaCilindro() +
        "\nVolume = " + volumeCilindro();
    }
}
