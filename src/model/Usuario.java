package model;

public abstract class Usuario {
    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public abstract int getLimiteEmprestimo();

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public boolean podeEmprestar() {
        return quantidadeEmprestada < getLimiteEmprestimo();
    }

    public void incrementarEmprestimo() {
        if (podeEmprestar()) {
            quantidadeEmprestada++;
        }
    }

    public void decrementarEmprestimo() {
        if (quantidadeEmprestada > 0) {
            quantidadeEmprestada--;
        }
    }

    @Override
    public String toString() {
        return String.format("Usuário: %s | Itens com ele: %d/%d",
                nome, quantidadeEmprestada, getLimiteEmprestimo());
    }
}