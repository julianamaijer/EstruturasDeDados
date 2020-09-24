package exercicio_03_atividade03;

public class Aluno {

    private int RA;
    private String nome;
    private String turma;
    private String semestre;

    public String getNome() {
        return nome;
    }

    public int getRA() {
        return RA;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getTurma() {
        return turma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

}
