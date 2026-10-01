package model;

public class Dvd extends ItemBiblioteca {
    public Dvd(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return 3;
    }

    @Override
    public double getMultaPorDia() {
        return 2.00;
    }

    @Override
    public String getTipo() {
        return "DVD";
    }
}
