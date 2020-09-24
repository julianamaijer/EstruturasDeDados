package exercicio_02_atividade02;

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
    //Recursividade: Nesse m�todo foi utilizado recursividade direta, pois ela chama ela mesma. Nesse caso o atributo "aux" ser� igual ao pr�ximo elemento at� que o pr�ximo
    //elemento seja nulo. O objetivo aqui � chegar at� o final da lista atrav�s da recursividade.
    public void inserirFinal(double temperatura){
        Node novo = new Node();
        novo.setTemperatura(temperatura);
        novo.setProximo(null);
        if (inicio == null){
            inicio = novo;
        }else{
            Node aux;
            aux = inicio;
            aux = recursivaInserirFinal(aux);
            aux.setProximo(novo);
        }
        System.out.println("A temperatura " + novo.getTemperatura() + "�C foi adicionada no final da lista.");
    }

    //M�todo recursivo direto usado no m�todo inserirFinal
    static public Node recursivaInserirFinal(Node aux){
        if (aux.getProximo() == null){
            return aux;
        }else {
           return recursivaInserirFinal(aux.getProximo());
        }
    }

    //Inserir uma temperatura em determinada posi��o da lista:
    //Recursividade: Nesse m�todo existem duas chamadas recursivas diretas. Uma tem como objetivo definir o "contador" e a outra o "aux".
    public void inserirPosicao(double temperatura, int posicao){
        Node novo = new Node();
        novo.setTemperatura(temperatura);

        if (posicao == 1){
            inserirInicio(temperatura);
        }else {
            Node aux = inicio;
            int contadorInserir = 1;
            int contador = 1;
            contadorInserir = recursivaInserirPosicaoContador(aux, contadorInserir, posicao);
            aux = recursivaInserirPosicaoAux(aux, contador, posicao);
            if (contadorInserir == (posicao - 1)){
                novo.setProximo(aux.getProximo());
                aux.setProximo(novo);
                System.out.println("A temperatura " + novo.getTemperatura() + "�C foi adicionada na posi��o " + posicao + " da lista.");
            }else {
                System.out.println("Posi��o inv�lida!");
            }
        }
    }

    //M�todo recursivo direto usado no m�todo inserirPosicao
    static public Node recursivaInserirPosicaoAux(Node aux, int contador, int posicao){
        if (aux.getProximo() == null || contador == (posicao - 1)){
            return aux;
        }else {
            contador++;
            return recursivaInserirPosicaoAux(aux.getProximo(), contador, posicao);
        }
    }

    //M�todo recursivo direto usado no m�todo inserirPosicao
    static public int recursivaInserirPosicaoContador(Node aux, int contadorInserir, int posicao){
        if (aux.getProximo() == null || contadorInserir == (posicao - 1)){
            return contadorInserir;
        }else {
            aux = aux.getProximo();
            contadorInserir++;
            return recursivaInserirPosicaoContador(aux, contadorInserir, posicao);
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
    //Recursividade: Nesse m�todo existem duas chamadas recursivas diretas. Uma tem como objetivo definir o "aux" e a outra o "aux2".
    public double removerFinal(){
        Node aux = inicio;
        Node aux2 = inicio;
        double remove;

        if (inicio.getProximo() == null){
            remove = aux.getTemperatura();
            inicio = null;
        }else {
            aux2 = recursivaRemoverFinal1(aux, aux2);
            aux = recursivaRemoverFinal2(aux);
            remove = aux.getTemperatura();
            aux2.setProximo(null);
        }
        return remove;
    }

    //M�todo recursivo direto usado no m�todo removerFinal
    static public Node recursivaRemoverFinal1(Node aux, Node aux2){
        if (aux.getProximo() == null){
            return aux2;
        }else {
            aux2 = aux;
            aux = aux.getProximo();
            return recursivaRemoverFinal1(aux,aux2);
        }
    }


    //M�todo recursivo direto usado no m�todo removerFinal
    static public Node recursivaRemoverFinal2(Node aux){
        if (aux.getProximo() == null){
            return aux;
        }else {
            aux = aux.getProximo();
            return recursivaRemoverFinal2(aux);
        }
    }

    //Removendo uma posi��o espec�fica:
    //Recursividade: Nesse m�todo existem tr�s chamadas recursivas diretas. Uma tem como objetivo definir o "aux", a outra o "aux2" e a outra o "contador.
    public double removerPosicao(int posicao){
        Node aux = inicio;
        double remove = 0;

        if (posicao == 1){
            remove = aux.getTemperatura();
            inicio = aux.getProximo();
            System.out.println("A temperatura " + remove + "�C foi removida da posi��o " + posicao + " da lista." );
        }else {
            int contador = 1;
            int contadorRemover = 1;
            Node aux2 = inicio.getProximo();
            contador = recursivaRemoverPosicao3(aux,contador,posicao,aux2);
            aux = recursivaRemoverPosicao1(aux,contadorRemover,posicao);
            aux2 = recursivaRemoverPosicao2(aux,contadorRemover,posicao,aux2);
            if (contador == (posicao - 1) && aux2 != null){
                remove = aux2.getTemperatura(); //erro
                aux.setProximo(aux2.getProximo());
                System.out.println("A temperatura " + remove + "�C foi removida da posi��o " + posicao + " da lista." );
            }else{
                System.out.println("Posi��o inv�lida!");
            }
        }
        return remove;
    }

    //M�todo recursivo direto usado no m�todo removerPosicao:
    static public Node recursivaRemoverPosicao1(Node aux, int contadorRemover, int posicao){
        if (aux.getProximo() == null || contadorRemover == (posicao - 1)){
            return aux;
        }else {
            contadorRemover++;
            return recursivaRemoverPosicao1(aux.getProximo(), contadorRemover, posicao);
        }
    }

    //M�todo recursivo direto usado no m�todo removerPosicao:
    static public Node recursivaRemoverPosicao2(Node aux, int contadorRemover, int posicao, Node aux2){
        if (aux.getProximo() == null || contadorRemover == (posicao - 1)){
            return aux2;
        }else {
            aux = aux.getProximo();
            aux2 = aux2.getProximo();
            contadorRemover++;
            return recursivaRemoverPosicao2(aux, contadorRemover, posicao, aux2);
        }
    }

    //M�todo recursivo direto usado no m�todo removerPosicao:
    static public int recursivaRemoverPosicao3(Node aux, int contador, int posicao, Node aux2){
        if (aux.getProximo() == null || contador == (posicao - 1)){
            return contador;
        }else {
            aux = aux.getProximo();
            aux2 = aux2.getProximo();
            contador++;
            return recursivaRemoverPosicao3(aux, contador, posicao, aux2);
        }
    }

    //Percorrendo e apresentando cada um dos elementos da lista.
    //Recursividade: Nesse m�todo existe uma chamada recursiva direta. Ela chama ela mesma e tem como objetivo percorrer toda a lista de temperaturas.
    public void listar(){
        if (inicio == null){
            System.out.println("A lista est� vazia!");
        }else {
            Node aux = inicio;
            System.out.println("Lista de temperaturas:");
            recursivaListar(aux);
        }
    }

    //M�todo recursivo direto usado no m�todo listar:
    static public Node recursivaListar(Node aux){
        if (aux.getProximo() == null){
            System.out.println("Temperatura: " + aux.getTemperatura() + "�C.");
            return aux;
        }else {
            System.out.println("Temperatura: " + aux.getTemperatura() + "�C.");
            return recursivaListar(aux.getProximo());
        }
    }
}
