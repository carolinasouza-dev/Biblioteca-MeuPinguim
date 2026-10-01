package model;

public class Revista extends ItemBiblioteca {

    public Revista(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return 7;
    }

    @Override
    public double getMultaPorDia() {
        return 1.00;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }
}