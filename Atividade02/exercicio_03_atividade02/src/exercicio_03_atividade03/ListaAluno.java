package exercicio_03_atividade03;

public class ListaAluno {

    private Node inicio;

    public ListaAluno(){
        this.inicio = null;
    }

    //Inserindo um aluno no final da lista:
    //Recursividade: Nesse método foi utilizado recursividade direta, pois ela chama ela mesma. Nesse caso o atributo "aux" será igual ao próximo elemento até que o próximo
    //elemento seja nulo. O objetivo aqui é chegar até o final da lista através da recursividade.
    public void inserirFinal(Aluno aluno){
        Node novo = new Node();
        novo.setAluno(aluno);
        novo.setProximo(null);

        if (inicio == null){
            inicio = novo;
        }else{
            Node aux;
            aux = inicio;
            aux = recursivaInserirFinal(aux);
            aux.setProximo(novo);
        }
        System.out.println("Aluno inserido no final da lista => Nome: " + novo.getAluno().getNome() + ". RA: " + novo.getAluno().getRA() + ". Turma: " + novo.getAluno().getTurma() + ". Semestre: " + novo.getAluno().getSemestre());
    }

    //Método recursivo direto usado no método inserirFinal
    static public Node recursivaInserirFinal(Node aux){
        if (aux.getProximo() == null){
            return aux;
        }else {
            aux = aux.getProximo();
            return recursivaInserirFinal(aux);
        }
    }

    //Inserindo um aluno no início da lista:
    public void inserirInicio(Aluno aluno){
        Node novo = new Node();
        novo.setAluno(aluno);
        novo.setProximo(inicio);
        inicio = novo;
        System.out.println("Aluno inserido no início da lista => Nome: " + novo.getAluno().getNome() + ". RA: " + novo.getAluno().getRA() + ". Turma: " + novo.getAluno().getTurma() + ". Semestre: " + novo.getAluno().getSemestre());
    }

    //Inserindo um aluno no meio da lista:
    //Recursividade: Nesse método existem duas chamadas recursivas diretas. Uma tem como objetivo definir o "aux2" e a outra o "contador".
    public void adicionarMeio(Aluno aluno){
        Node novo = new Node();
        novo.setAluno(aluno);
        int contador = 1;

        if (inicio == null){
            inserirInicio(aluno);
        }else {
            Node aux = inicio;
            Node aux2 = inicio;
            contador = recursivaMeioContador(aux,contador);
            if (contador % 2 == 0){
                contador = (contador/2);
            }else {
                contador = ((contador/2)+1);
            }
            int contador3 = 1;
            aux2 = recursivaMeioAux2(aux2,contador,contador3);
            Node aux3 = aux2.getProximo();
            aux2.setProximo(novo);
            novo.setProximo(aux3);
        }
        System.out.println("Aluno inserido no meio da lista => Nome: " + novo.getAluno().getNome() + ". RA: " + novo.getAluno().getRA() + ". Turma: " + novo.getAluno().getTurma() + ". Semestre: " + novo.getAluno().getSemestre());
    }


    //Método recursivo direto usado no método adicionarMeio e removerMeio
    static public int recursivaMeioContador(Node aux, int contador){
        if (aux.getProximo() == null){
            return contador;
        }else {
            aux = aux.getProximo();
            contador++;
            return recursivaMeioContador(aux, contador);
        }
    }

    //Método recursivo direto usado no método adicionarMeio e removerMeio
    static public Node recursivaMeioAux2(Node aux2, int contador, int contador3){
        if (contador3 == contador){
            return aux2;
        }else {
            aux2 = aux2.getProximo();
            contador3++;
            return recursivaMeioAux2(aux2,contador,contador3);
        }
    }

    //Removendo um aluno do final da lista:
    //Recursividade: São usados dos métodos recursivos diretos.
    public Aluno removerFinal(){
        Node aux = inicio;
        Node aux2 = inicio;
        Aluno remove;

        if (inicio.getProximo() == null){
            remove = aux.getAluno();
            inicio = null;
        }else {
            aux2 = recursivaRemoverFinal1(aux,aux2);
            aux = recursivaRemoverFinal2(aux);
            remove = aux.getAluno();
            aux2.setProximo(null);
        }
        return remove;
    }

    //Método recursivo direto usado no método removerFinal
    static public Node recursivaRemoverFinal1(Node aux, Node aux2){
        if (aux.getProximo() == null){
            return aux2;
        }else {
            aux2 = aux;
            aux = aux.getProximo();
            return recursivaRemoverFinal1(aux,aux2);
        }
    }

    //Método recursivo direto usado no método removerFinal
    static public Node recursivaRemoverFinal2(Node aux){
        if (aux.getProximo() == null){
            return aux;
        }else {
            aux = aux.getProximo();
            return recursivaRemoverFinal2(aux);
        }
    }

    //Removendo um aluno no início da lista:
    public Aluno removerInicio(){
        Node aux = inicio;
        Aluno aluno = aux.getAluno();
        inicio = aux.getProximo();
        return aluno;
    }

    //Removendo um aluno do meio da lista:
    //Recursividade: Nesse método existem duas chamadas recursivas diretas. Uma tem como objetivo definir o "aux2" e a outra o "contador".
    public Aluno removerMeio() {
        int contador = 1;
        Node aux = inicio;
        Node aux2 = inicio;
        if (inicio.getProximo() == null) {
            Node aux3 = inicio;
            removerInicio();
            return aux3.getAluno();
        } else {
            contador = recursivaMeioContador(aux,contador);
            contador = (contador/2);
            int contador3 = 1;
            aux2 = recursivaMeioAux2(aux2,contador,contador3);
            Node aux3 = aux2.getProximo();
            aux2.setProximo(aux3.getProximo());
            return aux3.getAluno();
        }
    }

    //Percorrendo e apresentando cada um dos elementos da lista.
    //Recursividade: Nesse método existe uma chamada recursiva direta. Ela chama ela mesma e tem como objetivo percorrer toda a lista de alunos.
    public void listar(){
        if (inicio == null){
            System.out.println("A lista está vazia!");
        }else {
            Node aux = inicio;
            System.out.println("Lista de alunos:");
            recursivaListar(aux);
        }
    }

    //Método recursivo direto usado no método listar:
    static public Node recursivaListar(Node aux){
        if (aux.getProximo() == null){
            System.out.println("Aluno: " + aux.getAluno().getNome() + ". RA: " + aux.getAluno().getRA() + ". Turma: " + aux.getAluno().getTurma() + ". Semestre: " + aux.getAluno().getSemestre());
            return aux;
        }else {
            System.out.println("Aluno: " + aux.getAluno().getNome() + ". RA: " + aux.getAluno().getRA() + ". Turma: " + aux.getAluno().getTurma() + ". Semestre: " + aux.getAluno().getSemestre());
            return recursivaListar(aux.getProximo());
        }
    }

    //Verificando se a lista está vazia:
    public boolean isEmpty(){
        if (this.inicio == null){
            return true;
        }else{
            return false;
        }
    }
}

