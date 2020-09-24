package exercicio_03_atividade03;

import javax.swing.*;

public class Menu {
    public static void main(String[] args) {
        ListaAluno lista = new ListaAluno();
        int opcao = 0;
        menu(opcao, lista);
    }

    static private int menu(int opcao, ListaAluno lista) {
        int RA;
        String nome;
        String turma;
        String semestre;
        if (opcao == 9) {
            return opcao;
        } else {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Cadastro lista de alunos: \n" +
                    "1 - Adicionar um aluno no final da lista\n" +
                    "2 - Adicionar um aluno no início da lista\n" +
                    "3 - Adicionar um aluno no meio da lista\n" +
                    "4 - Remover um aluno do final da lista\n" +
                    "5 - Remover um aluno do início da lista\n" +
                    "6 - Remover um aluno do meio da lista\n" +
                    "7 - Apresentar cada um dos elementos da lista\n" +
                    "9 - Sair"));
            switch (opcao) {
                case 1:
                    Aluno aluno = new Aluno();
                    nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
                    RA = Integer.parseInt(JOptionPane.showInputDialog("Insira o RA do aluno: "));
                    turma = JOptionPane.showInputDialog("Insira a turma do aluno: ");
                    semestre = JOptionPane.showInputDialog("Insira o semestre do aluno: ");
                    aluno.setNome(nome);
                    aluno.setRA(RA);
                    aluno.setTurma(turma);
                    aluno.setSemestre(semestre);
                    lista.inserirFinal(aluno);
                    break;
                case 2:
                    Aluno aluno2 = new Aluno();
                    nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
                    RA = Integer.parseInt(JOptionPane.showInputDialog("Insira o RA do aluno: "));
                    turma = JOptionPane.showInputDialog("Insira a turma do aluno: ");
                    semestre = JOptionPane.showInputDialog("Insira o semestre do aluno: ");
                    aluno2.setNome(nome);
                    aluno2.setRA(RA);
                    aluno2.setTurma(turma);
                    aluno2.setSemestre(semestre);
                    lista.inserirInicio(aluno2);
                    break;
                case 3:
                    Aluno aluno3 = new Aluno();
                    nome = JOptionPane.showInputDialog("Insira o nome do aluno: ");
                    RA = Integer.parseInt(JOptionPane.showInputDialog("Insira o RA do aluno: "));
                    turma = JOptionPane.showInputDialog("Insira a turma do aluno: ");
                    semestre = JOptionPane.showInputDialog("Insira o semestre do aluno: ");
                    aluno3.setNome(nome);
                    aluno3.setRA(RA);
                    aluno3.setTurma(turma);
                    aluno3.setSemestre(semestre);
                    lista.adicionarMeio(aluno3);
                    break;
                case 4:
                    if (!lista.isEmpty()) {
                        Aluno a = lista.removerFinal();
                        System.out.println("O aluno " + a.getNome() + " de RA " + a.getRA() + " da turma " + a.getTurma() + " do semestre " + a.getSemestre() + " foi removido do final da lista.");
                    } else {
                        System.out.println("A lista está vazia! A operação não pode ser realizada.");
                    }
                    break;
                case 5:
                    if (!lista.isEmpty()) {
                        Aluno a = lista.removerInicio();
                        System.out.println("O aluno " + a.getNome() + " de RA " + a.getRA() + " da turma " + a.getTurma() + " do semestre " + a.getSemestre() + " foi removido do início da lista.");
                    } else {
                        System.out.println("A lista está vazia! A operação não pode ser realizada.");
                    }
                    break;
                case 6:
                    if (!lista.isEmpty()) {
                        Aluno a = lista.removerMeio();
                        System.out.println("O aluno " + a.getNome() + " de RA " + a.getRA() + " da turma " + a.getTurma() + " do semestre " + a.getSemestre() + " foi removido do meio da lista.");
                    } else {
                        System.out.println("A lista está vazia! A operação não pode ser realizada.");
                    }
                    break;
                case 7:
                    lista.listar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Você saiu do menu!");
                    break;
            }return menu(opcao, lista);
        }
    }
}
