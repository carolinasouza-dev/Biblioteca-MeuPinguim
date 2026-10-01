package model;

public class Professor extends Usuario {

    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int getLimiteEmprestimo() {
        return 5;
    }
}