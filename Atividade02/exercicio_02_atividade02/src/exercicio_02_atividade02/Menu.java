package exercicio_02_atividade02;

import javax.swing.*;

public class Menu {

    public static void main(String[] args) {
        Lista lista = new Lista();
        int opcao = 0;
        menu(opcao,lista);
    }

    static private int menu(int opcao, Lista lista){
        double temperatura = 0;
        int posicao = 0;
        if(opcao==9){
            return opcao;
        }else{
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Cadastro lista de temperaturas: \n" +
                    "1 - Verificar se a lista está vazia\n" +
                    "2 - Adicionar uma temperatura no início da lista\n" +
                    "3 - Adicionar uma temperatura no final da lista\n" +
                    "4 - Adicionar uma temperatura em uma posição específica\n" +
                    "5 - Remover uma temperatura do início da lista\n" +
                    "6 - Remover uma temperatura do final da lista\n" +
                    "7 - Remover uma temperatura em uma posição específica\n" +
                    "8 - Percorrer e apresentar cada um dos elementos da lista\n" +
                    "9 - Sair"));

            switch (opcao){
                case 1:
                    System.out.println("A lista está vazia? " + lista.isEmpty());
                    break;
                case 2:
                    temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira uma temperatura para adicionar no início da lista: "));
                    lista.inserirInicio(temperatura);
                    break;
                case 3:
                    temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira uma temperatura para adicionar no final da lista: "));
                    lista.inserirFinal(temperatura);
                    break;
                case 4:
                    temperatura = Double.parseDouble(JOptionPane.showInputDialog("Insira uma temperatura para adicionar na lista: "));
                    posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição da lista que deseja adicionar a temperatura: "));
                    lista.inserirPosicao(temperatura,posicao);
                    break;
                case 5:
                    if (!lista.isEmpty()){
                        double t = lista.removerInicio();
                        System.out.println("A temperatura " + t + "ºC foi removida do início lista." );
                    }else {
                        System.out.println("A lista está vazia! A operação não pode ser realizada.");
                    }
                    break;
                case 6:
                    if (!lista.isEmpty()){
                        double t = lista.removerFinal();
                        System.out.println("A temperatura " + t + "ºC foi removida do final da lista." );
                    }else {
                        System.out.println("A lista está vazia! A operação não pode ser realizada.");
                    }
                    break;
                case 7:
                    if (!lista.isEmpty()){
                        posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição da lista que deseja remover a temperatura: "));
                        double t = lista.removerPosicao(posicao);
                    }else {
                        System.out.println("A lista está vazia! A operação não pode ser realizada.");
                    }
                    break;
                case 8:
                    lista.listar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Você saiu do menu!");
            }return menu(opcao,lista);
        }
    }
}

