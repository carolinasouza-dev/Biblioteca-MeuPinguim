package model;

public class Livro extends ItemBiblioteca {

    public Livro(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return 14;
    }

    @Override
    public double getMultaPorDia() {
        return 0.50;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
}