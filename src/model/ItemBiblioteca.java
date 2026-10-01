package model;

public abstract class ItemBiblioteca {
    private int codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true; // Todo item nasce disponível
    }

    public abstract int getPrazoEmprestimo();
    public abstract double getMultaPorDia();

    // Método abstrato para obter o tipo do item (ex: Livro, Revista, DVD)
    public abstract String getTipo();

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void marcarComoEmprestado() {
        this.disponivel = false;
    }

    public void marcarComoDevolvido() {
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s) - Status: %s - Prazo: %d dias - Multa/dia: R$ %.2f",
                codigo, titulo, getTipo(), (disponivel ? "Disponível" : "Emprestado"),
                getPrazoEmprestimo(), getMultaPorDia());
    }
}