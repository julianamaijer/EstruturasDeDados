package exercicio_02_ListaEncadeada;

public class Lista {

    private Node inicio;

    public Lista(){
        this.inicio = null;
    }

    //Verificando se a lista est� vazia:
    public boolean isEmpty(){
        if (this.inicio == null){
            return true;
        }else{
            return false;
        }
    }

    //Inserindo uma temperatura no in�cio da lista:
    public void inserirInicio(double temperatura){
        Node novo = new Node();
        novo.setTemperatura(temperatura);
        novo.setProximo(inicio);
        inicio = novo;
        System.out.println("A temperatura " + inicio.getTemperatura() + "�C foi adicionada no in�cio da lista.");
    }

    //Inserindo uma temperatura no final da lista:
    public void inserirFinal(double temperatura){
        Node novo = new Node();
        novo.setTemperatura(temperatura);
        novo.setProximo(null);

        if (inicio == null){
            inicio = novo;
        }else{
            Node aux;
            aux = inicio;
            while (aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(novo);
        }
        System.out.println("A temperatura " + novo.getTemperatura() + "�C foi adicionada no final da lista.");
    }

    //Inserir uma temperatura em determinada posi��o da lista:
    public void inserirPosicao(double temperatura, int posicao){
        Node novo = new Node();
        novo.setTemperatura(temperatura);

        if (posicao == 1){
            inserirInicio(temperatura);
        }else {
            Node aux = inicio;
            int contador = 1;
            while (aux.getProximo() != null && contador < (posicao - 1)){
                aux = aux.getProximo();
                contador++;
            }
            if (contador == (posicao - 1)){
                novo.setProximo(aux.getProximo());
                aux.setProximo(novo);
            }else {
                System.out.println("Posi��o inv�lida!");
            }
        }
        if (posicao > 1 ){
            System.out.println("A temperatura " + novo.getTemperatura() + "�C foi adicionada na posi��o " + posicao + " da lista.");
        }
    }

    //Removendo uma temperatura no in�cio da lista:
    public double removerInicio(){
        Node aux = inicio;
        double temperatura = aux.getTemperatura();
        inicio = aux.getProximo();
        return temperatura;
    }

    //Removendo uma temperatura do final da lista:
    public double removerFinal(){
        Node aux = inicio;
        Node aux2 = inicio;
        double remove;

        if (inicio.getProximo() == null){
            remove = aux.getTemperatura();
            inicio = null;
        }else {
            while ( aux.getProximo() != null){
                aux2 = aux;
                aux = aux.getProximo();
            }
            remove = aux.getTemperatura();
            aux2.setProximo(null);
        }
        return remove;
    }

    //Removendo uma posi��o espec�fica:
    public double removerPosicao(int posicao){
        Node aux = inicio;
        double remove = 0;

        if (posicao == 1){
            remove = aux.getTemperatura();
            inicio = aux.getProximo();
            System.out.println("A temperatura " + remove + "�C foi removida da posi��o " + posicao + " da lista." );
        }else {
            int contador = 1;
            Node aux2 = inicio.getProximo();
            while (aux.getProximo() != null && contador < (posicao - 1)){
                aux = aux.getProximo();
                aux2 = aux.getProximo();
                contador++;
            }
            if (contador == (posicao - 1) && aux2 != null){
                remove = aux2.getTemperatura();
                aux.setProximo(aux2.getProximo());
                System.out.println("A temperatura " + remove + "�C foi removida da posi��o " + posicao + " da lista." );
            }else{
                System.out.println("Posi��o inv�lida!");
            }
        }
        return remove;
    }

    //Percorrendo e apresentando cada um dos elementos da lista.
    public void listar(){
        if (inicio == null){
            System.out.println("A lista est� vazia!");
        }else {
            Node aux = inicio;
            System.out.println("Lista de temperaturas:");
            while (aux != null){
                System.out.println("Temperatura: " + aux.getTemperatura() + "�C.");
                aux = aux.getProximo();
            }
        }
    }
}