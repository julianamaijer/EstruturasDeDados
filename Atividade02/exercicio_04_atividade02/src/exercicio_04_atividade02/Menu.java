package exercicio_04_atividade02;

import javax.swing.*;

public class Menu {

    public static void main(String[] args) {
        ListaLivro listaLivro = new ListaLivro();
        int opcao = 0;
        menu(opcao,listaLivro);
    }

    static private int menu(int opcao, ListaLivro listaLivro){
        String titulo;
        int exemplares;
        int posicao;
        if (opcao == 9){
            return opcao;
        }else {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Cadastro lista de livros: \n" +
                    "1 - Verificar se a lista est� vazia\n" +
                    "2 - Adicionar um livro no in�cio da lista\n" +
                    "3 - Adicionar um livro no final da lista\n" +
                    "4 - Adicionar um livro em uma determinada posi��o da lista\n" +
                    "5 - Remover um livro do in�cio da lista\n" +
                    "6 - Remover um livro do final da lista\n" +
                    "7 - Remover um livro de uma determinada posi��o da lista\n" +
                    "8 - Percorrer e mostrar todos os livros da lista\n" +
                    "9 - Sair"));
            switch (opcao){
                case 1:
                    System.out.println("A lista est� vazia? " + listaLivro.isEmpty());
                    break;
                case 2:
                    Livro livro = new Livro();
                    titulo = JOptionPane.showInputDialog("Insira o t�tulo do livro: ");
                    exemplares = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de exemplares do livro: "));
                    livro.setTitulo(titulo);
                    livro.setExemplares(exemplares);
                    listaLivro.inserirInicio(livro);
                    break;
                case 3:
                    Livro livro2 = new Livro();
                    titulo = JOptionPane.showInputDialog("Insira o t�tulo do livro: ");
                    exemplares = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de exemplares do livro: "));
                    livro2.setTitulo(titulo);
                    livro2.setExemplares(exemplares);
                    listaLivro.inserirFinal(livro2);
                    break;
                case 4:
                    Livro livro3 = new Livro();
                    posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posi��o que deseja adicionar o livro: "));
                    titulo = JOptionPane.showInputDialog("Insira o t�tulo do livro: ");
                    exemplares = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de exemplares do livro: "));
                    livro3.setTitulo(titulo);
                    livro3.setExemplares(exemplares);
                    listaLivro.inserirPosicao(livro3,posicao);
                    break;
                case 5:
                    if (!listaLivro.isEmpty()) {
                        Livro l = listaLivro.removerInicio();
                        System.out.println("O livro " + l.getTitulo() + " com " + l.getExemplares() + " exemplares foi removido do in�cio da lista.");
                    } else {
                        System.out.println("A lista est� vazia! A opera��o n�o pode ser realizada.");
                    }
                    break;
                case 6:
                    if (!listaLivro.isEmpty()) {
                        Livro l = listaLivro.removerFinal();
                        System.out.println("O livro " + l.getTitulo() + " com " + l.getExemplares() + " exemplares foi removido do final da lista.");
                    } else {
                        System.out.println("A lista est� vazia! A opera��o n�o pode ser realizada.");
                    }
                    break;
                case 7:
                    if (!listaLivro.isEmpty()){
                        posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posi��o da lista que deseja remover o livro: "));
                        Livro l = listaLivro.removerPosicao(posicao);
                    }else {
                        System.out.println("A lista est� vazia! A opera��o n�o pode ser realizada.");
                    }
                    break;
                case 8:
                    listaLivro.listar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Voc� saiu do menu!");
                    break;
            }
        }return menu(opcao,listaLivro);
    }
}

