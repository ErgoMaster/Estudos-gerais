package Aluno.src;

public class Aluno {
    private String nome;
    private String matricula;
    private String dataNascimento;
    private String CPF;

    // Contrutores
    public Aluno() {}
    public Aluno(String nome, String matricula, String dataNascimento, String CPF) {
        this.nome = nome; 
        this.matricula = matricula; 
        this.dataNascimento = dataNascimento; 
        this.CPF = CPF; 
    }

    // Métodos get
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getDataNascimento() { return dataNascimento; }
    public String getCPF() { return CPF; }

    // Métodos set
    public void setNome(String nome) { this.nome = nome; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    public String toString() {
        return "Nome: " + getNome() +
        "\nMatrícula: " + getMatricula() +
        "\nData de nascimento: " + getDataNascimento() +
        "\nCPF: " + getCPF();
    }
}
