package service;

import model.ItemBiblioteca;
import model.Usuario;

public class BibliotecaMeuPinguim {
    private ItemBiblioteca[] acervo;
    private Usuario[] usuarios;
    private int qtdItens;
    private int qtdUsuarios;

    public BibliotecaMeuPinguim(int capacidadeAcervo, int capacidadeUsuarios) {
        this.acervo = new ItemBiblioteca[capacidadeAcervo];
        this.usuarios = new Usuario[capacidadeUsuarios];
        this.qtdItens = 0;
        this.qtdUsuarios = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        System.out.println("===============================================");
        System.out.println("****** Cadastro de Item no Acervo ******");
        System.out.println("===============================================");

        if (qtdItens < acervo.length) {
            acervo[qtdItens] = item;
            qtdItens++;
            System.out.println("Item cadastrado com sucesso: [" + item.getTipo() + "] " + item.getTitulo());
        } else {
            System.out.println("Erro: Acervo cheio!");
        }
        System.out.println("\n");
    }

    public void cadastrarUsuario(Usuario usuario) {
        System.out.println("===============================================");
        System.out.println("****** Cadastro de Usuário ******");
        System.out.println("===============================================");

        if (qtdUsuarios < usuarios.length) {
            usuarios[qtdUsuarios] = usuario;
            qtdUsuarios++;
            System.out.println("Usuário cadastrado: " + usuario.getNome());
        } else {
            System.out.println("Erro: Limite de usuários atingido!");
        }
        System.out.println("\n");
    }

    public boolean emprestar(Usuario usuario, ItemBiblioteca item) {
        System.out.println("===============================================");
        System.out.println("****** Emprestimo de Item do Acervo ******");
        System.out.println("===============================================");

        if (!item.isDisponivel()) {
            System.out.println("Falha no empréstimo: O item '" + item.getTitulo() + "' está emprestado.");
            return false;
        }

        if (!usuario.podeEmprestar()) {
            System.out.println("Falha no empréstimo: " + usuario.getNome() +
                    " atingiu o limite de " + usuario.getLimiteEmprestimo() + " itens.");
            return false;
        }

        item.marcarComoEmprestado();
        usuario.incrementarEmprestimo();

        System.out.println(" [OK] Empréstimo realizado: [" + item.getTipo() + "] '" + item.getTitulo() +
                "' para " + usuario.getNome() +
                " (Prazo: " + item.getPrazoEmprestimo() + " dias)");
        System.out.println("\n");
        return true;
    }

    public boolean devolver(Usuario usuario, ItemBiblioteca item) {
        System.out.println("===============================================");
        System.out.println("****** Devolução de Item no Acervo ******");
        System.out.println("===============================================");

        if (item.isDisponivel()) {
            System.out.println("Falha na devolução: O item '" + item.getTitulo() + "' está no acervo.");
            return false;
        }

        item.marcarComoDevolvido();
        usuario.decrementarEmprestimo();

        System.out.println(" [OK] Devolução realizada com sucesso: [" + item.getTipo() + "] '" + item.getTitulo() + "' por " + usuario.getNome());
        System.out.println("\n");
        return true;
    }

    public void listarAcervo() {
        System.out.println("===============================================");
        System.out.println("****** Lista de Itens no Acervo ******");
        System.out.println("===============================================");

        if (qtdItens == 0) {
            System.out.println("Acervo vazio.");
            return;
        }
        for (int i = 0; i < qtdItens; i++) {
            System.out.println(acervo[i]);
        }
        System.out.println("\n");
    }

    public void listarUsuarios() {
        System.out.println("===============================================");
        System.out.println("****** Lista de Usuários ******");
        System.out.println("===============================================");

        if (qtdUsuarios == 0) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (int i = 0; i < qtdUsuarios; i++) {
            System.out.println(usuarios[i]);
        }
        System.out.println("\n");
    }

    public ItemBiblioteca buscarItem(int codigo) {
        for (int i = 0; i < qtdItens; i++) {
            if (acervo[i].getCodigo() == codigo) {
                return acervo[i];
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String nome) {
        for (int i = 0; i < qtdUsuarios; i++) {
            if (usuarios[i].getNome().equalsIgnoreCase(nome)) {
                return usuarios[i];
            }
        }
        return null;
    }
}