package exercicio_04_atividade02;

public class Node {

    private Livro livro;
    private Node proximo;

    public Node getProximo() {
        return proximo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}

