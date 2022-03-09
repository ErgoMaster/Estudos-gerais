import javax.swing.JOptionPane;

public class Nota {
    public static void main (String arg[]) {
        double nota1, nota2, nota3, media;

        nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota"));
        nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota"));
        nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a terceira nota"));
        media = (nota1 + nota2 + nota3) / 3;

        JOptionPane.showMessageDialog(null, "A média é igual a " + media, "Resultado", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}
