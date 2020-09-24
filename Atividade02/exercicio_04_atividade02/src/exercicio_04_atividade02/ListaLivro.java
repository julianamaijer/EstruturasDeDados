package exercicio_04_atividade02;

public class ListaLivro {

    private Node inicio;

    public ListaLivro(){
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

    //Inserindo um livro no in�cio da lista:
    public void inserirInicio(Livro livro){
        Node novo = new Node();
        novo.setLivro(livro);
        novo.setProximo(inicio);
        inicio = novo;
        System.out.println("Livro " + livro.getTitulo() + " com " + livro.getExemplares() + " exemplares adicionado no in�cio da lista.");
    }

    //Inserindo um livro no final da lista:
    //Recursividade: Nesse m�todo foi utilizado recursividade direta, pois ela chama ela mesma. Nesse caso o atributo "aux" ser� igual ao pr�ximo elemento at� que o pr�ximo
    //elemento seja nulo. O objetivo aqui � chegar at� o final da lista atrav�s da recursividade.
    public void inserirFinal(Livro livro){
        Node novo = new Node();
        novo.setLivro(livro);
        novo.setProximo(null);

        if (inicio == null){
            inicio = novo;
        }else{
            Node aux;
            aux = inicio;
            aux = recursivaInserirFinal(aux);
            aux.setProximo(novo);
            System.out.println("Livro " + livro.getTitulo() + " com " + livro.getExemplares() + " exemplares adicionado no final da lista.");
        }
    }

    //M�todo recursivo direto usado no m�todo inserirFinal
    static public Node recursivaInserirFinal(Node aux){
        if (aux.getProximo() == null){
            return aux;
        }else {
            aux = aux.getProximo();
            return recursivaInserirFinal(aux);
        }
    }

    //Inserir um livro em determinada posi��o da lista:
    //Recursividade: Nesse m�todo existem duas chamadas recursivas diretas. Uma tem como objetivo definir o "contador" e a outra o "aux".
    public void inserirPosicao(Livro livro, int posicao){
        Node novo = new Node();
        novo.setLivro(livro);

        if (posicao == 1){
            inserirInicio(livro);
        }else {
            Node aux = inicio;
            int contadorInserir = 1;
            int contador = 1;
            contadorInserir = recursivaInserirPosicaoContador(aux, contadorInserir, posicao);
            aux = recursivaInserirPosicaoAux(aux, contador, posicao);
            if (contadorInserir == (posicao - 1)){
                novo.setProximo(aux.getProximo());
                aux.setProximo(novo);
                System.out.println("Livro " + livro.getTitulo() + " com " + livro.getExemplares() + " exemplares inserido na posi��o " + posicao + " da lista.");
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

    //Removendo um livro no in�cio da lista:
    public Livro removerInicio(){
        Node aux = inicio;
        Livro livro = aux.getLivro();
        inicio = aux.getProximo();
        return livro;
    }

    //Removendo um livro do final da lista:
    //Recursividade: S�o usados dos m�todos recursivos diretos.
    public Livro removerFinal(){
        Node aux = inicio;
        Node aux2 = inicio;
        Livro remove;

        if (inicio.getProximo() == null){
            remove = aux.getLivro();
            inicio = null;
        }else {
            aux2 = recursivaRemoverFinal1(aux,aux2);
            aux = recursivaRemoverFinal2(aux);
            remove = aux.getLivro();
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
    public Livro removerPosicao(int posicao){
        Node aux = inicio;
        Livro remove = null;

        if (posicao == 1){
            remove = aux.getLivro();
            inicio = aux.getProximo();
            System.out.println("O livro " + remove.getTitulo() + " foi removido da posi��o " + posicao + " da lista." );
        }else {
            int contador = 1;
            int contadorRemover = 1;
            Node aux2 = inicio.getProximo();
            contador = recursivaRemoverPosicao3(aux,contador,posicao,aux2);
            aux = recursivaRemoverPosicao1(aux,contadorRemover,posicao);
            aux2 = recursivaRemoverPosicao2(aux,contadorRemover,posicao,aux2);
            if (contador == (posicao - 1) && aux2 != null){
                remove = aux2.getLivro(); //erro
                aux.setProximo(aux2.getProximo());
                System.out.println("O livro " + remove.getTitulo() + " foi removido da posi��o " + posicao + " da lista." );
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
    //Recursividade: Nesse m�todo existe uma chamada recursiva direta. Ela chama ela mesma e tem como objetivo percorrer toda a lista de livros.
    public void listar(){
        if (inicio == null){
            System.out.println("A lista est� vazia!");
        }else {
            Node aux = inicio;
            System.out.println("Lista de livros:");
            recursivaListar(aux);
        }
    }

    //M�todo recursivo direto usado no m�todo listar:
    static public Node recursivaListar(Node aux){
        if (aux.getProximo() == null){
            System.out.println("Livro: " + aux.getLivro().getTitulo() + ", exemplares: " + aux.getLivro().getExemplares());
            return aux;
        }else {
            System.out.println("Livro: " + aux.getLivro().getTitulo() + ", exemplares: " + aux.getLivro().getExemplares());
            return recursivaListar(aux.getProximo());
        }
    }



}
