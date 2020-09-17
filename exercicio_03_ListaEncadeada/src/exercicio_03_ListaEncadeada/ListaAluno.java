package exercicio_03_ListaEncadeada;

public class ListaAluno {

    private Node inicio;

    public ListaAluno(){
        this.inicio = null;
    }

    //Inserindo um aluno no final da lista:
    public void inserirFinal(Aluno aluno){
        Node novo = new Node();
        novo.setAluno(aluno);
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
        System.out.println("Aluno inserido no final da lista => Nome: " + novo.getAluno().getNome() + ". RA: " + novo.getAluno().getRA() + ". Turma: " + novo.getAluno().getTurma() + ". Semestre: " + novo.getAluno().getSemestre());
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
    public void adicionarMeio(Aluno aluno){
        Node novo = new Node();
        novo.setAluno(aluno);
        int contador = 1;

        if (inicio == null){
            inserirInicio(aluno);
        }else {
            Node aux = inicio;
            Node aux2 = inicio;
            while (aux.getProximo() != null){
                aux = aux.getProximo();
                contador++;
            }
            contador = (contador/2);
            int contador2 = 1;
            while (contador2 < contador){
                aux2 = aux2.getProximo();
                contador2++;
            }
            Node aux3 = aux2.getProximo();
            aux2.setProximo(novo);
            novo.setProximo(aux3);
        }
        System.out.println("Aluno inserido no meio da lista => Nome: " + novo.getAluno().getNome() + ". RA: " + novo.getAluno().getRA() + ". Turma: " + novo.getAluno().getTurma() + ". Semestre: " + novo.getAluno().getSemestre());
    }

    //Removendo um aluno do final da lista:
    public Aluno removerFinal(){
        Node aux = inicio;
        Node aux2 = inicio;
        Aluno remove;

        if (inicio.getProximo() == null){
            remove = aux.getAluno();
            inicio = null;
        }else {
            while ( aux.getProximo() != null){
                aux2 = aux;
                aux = aux.getProximo();
            }
            remove = aux.getAluno();
            aux2.setProximo(null);
        }
        return remove;
    }

    //Removendo um aluno no início da lista:
    public Aluno removerInicio(){
        Node aux = inicio;
        Aluno aluno = aux.getAluno();
        inicio = aux.getProximo();
        return aluno;
    }

    //Removendo um aluno do meio da lista:
    public Aluno removerMeio() {
        int contador = 1;
        Node aux = inicio;
        Node aux2 = inicio;
        if (inicio.getProximo() == null) {
            Node aux3 = inicio;
            removerInicio();
            return aux3.getAluno();
        } else {
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
                contador++;
            }
            contador = (contador / 2);
            int contador2 = 1;
            while (contador2 < contador) {
                aux2 = aux2.getProximo();
                contador2++;
            }
            Node aux3 = aux2.getProximo();
            aux2.setProximo(aux3.getProximo());
            return aux3.getAluno();
        }
    }

    //Percorrendo e apresentando cada um dos elementos da lista.
    public void listar(){
        if (inicio == null){
            System.out.println("A lista está vazia!");
        }else {
            Node aux = inicio;
            System.out.println("Lista de alunos:");
            while (aux != null){
                System.out.println("Aluno: " + aux.getAluno().getNome() + ". RA: " + aux.getAluno().getRA() + ". Turma: " + aux.getAluno().getTurma() + ". Semestre: " + aux.getAluno().getSemestre());
                aux = aux.getProximo();
            }
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

