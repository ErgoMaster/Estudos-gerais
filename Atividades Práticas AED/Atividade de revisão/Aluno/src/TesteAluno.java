package Aluno.src;

import javax.swing.JOptionPane;

public class TesteAluno {
    public static void main(String[] args) {
        String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno");
        String matriculaAluno = JOptionPane.showInputDialog("Digite a matricula do aluno");
        String CPFAluno = JOptionPane.showInputDialog("Digite o CPF do aluno");
        String dataNascimentoAluno = JOptionPane.showInputDialog("Digite a data de nascimento do aluno");

        Aluno alunoA = new Aluno(nomeAluno, matriculaAluno, dataNascimentoAluno, CPFAluno);

        JOptionPane.showMessageDialog(null, alunoA.toString(), "Dados do aluno", JOptionPane.PLAIN_MESSAGE); 
    }
}
