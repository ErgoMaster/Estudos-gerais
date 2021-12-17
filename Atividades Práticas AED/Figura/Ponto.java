public class Ponto {
    private int x, y;

    public Ponto() {
        x = 0;
        y = 0;
    }
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Métodos get
    public int getX() { return x; }
    public int getY() { return y; }

    // Métodos set
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    // Método para modificar o ponto
    public void setPonto(int x, int y) { 
        this.x = x;
        this.y = y;
    }

    public String toString() { return "[" + getX() + "," + getY() + "]"; }
}
