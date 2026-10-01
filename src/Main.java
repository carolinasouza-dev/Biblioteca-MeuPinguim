import model.*;
import service.BibliotecaMeuPinguim;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BibliotecaMeuPinguim biblioteca = new BibliotecaMeuPinguim(10, 10);
        Scanner scanner = new Scanner(System.in);

        // --- DADOS PARA O CENÁRIO DE TESTE INICIAL ---
        System.out.println("=== INICIALIZANDO DADOS DE TESTE ===");

        ItemBiblioteca livro1 = new Livro(101, "Java: Como Programar");
        ItemBiblioteca livro2 = new Livro(102, "Estruturas de Dados com Javascript");
        ItemBiblioteca livro3 = new Livro(103, "Engenharia de Software");
        ItemBiblioteca revista1 = new Revista(201, "Veja");
        ItemBiblioteca revista2 = new Revista(202, "Capricho");

        // Cad. usuários
        Usuario aluno1 = new Aluno("Carolina de Souza");
        Usuario professor = new Professor("Dumbo");

        biblioteca.cadastrarUsuario(aluno1);
        biblioteca.cadastrarUsuario(professor);

        // Cad. Acervo
        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(livro3);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);

        System.out.println("\n=== EXECUTANDO CENÁRIO DE TESTE REQUISITADO ===");
        // Empréstimos para aluno1 até atingir o limite
        biblioteca.emprestar(aluno1, livro1);   // (1/3)
        biblioteca.emprestar(aluno1, livro2);   // (2/3)
        biblioteca.emprestar(aluno1, revista1); //  (3/3 - Limite atingido)

        // Tentativa de empréstimo recusada por limite atingido
        System.out.println("\nTentando realizar empréstimo além do limite para " + aluno1.getNome() + ":");
        biblioteca.emprestar(aluno1, livro3);   // Deve falhar!


        // --- MENU INTERATIVO DE TERMINAL ---
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n\n===============================================");
            System.out.println("****** Biblioteca Meu Pinguim ******");
            System.out.println("===============================================");
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar Acervo");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Cadastrar Usuário");
            System.out.println("4. Cadastrar Item no Acervo");
            System.out.println("5. Realizar Empréstimo");
            System.out.println("6. Realizar Devolução");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer do teclado
            } else {
                System.out.println("Opção inválida! Digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    biblioteca.listarAcervo();
                    break;

                case 2:
                    biblioteca.listarUsuarios();
                    break;

                case 3:
                    System.out.println("\n-- Cadastrar Usuário --");
                    System.out.print("Nome do usuário: ");
                    String nomeNovo = scanner.nextLine();

                    System.out.println("Tipo de Usuário:");
                    System.out.println("1. Aluno");
                    System.out.println("2. Professor");
                    System.out.print("Informe o numero: ");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoUsuario == 1) {
                        biblioteca.cadastrarUsuario(new Aluno(nomeNovo));
                    } else if (tipoUsuario == 2) {
                        biblioteca.cadastrarUsuario(new Professor(nomeNovo));
                    } else {
                        System.out.println("Tipo de usuário inválido! Cadastro cancelado.");
                    }
                    break;

                case 4:
                    System.out.println("\n-- Cadastrar Item --");
                    System.out.print("Código do item: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Título do item: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Tipo de Item:");
                    System.out.println("1. Livro");
                    System.out.println("2. Revista");
                    System.out.println("3. DVD");
                    System.out.print("Informe o numero: ");
                    int tipoItem = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoItem == 1) {
                        biblioteca.cadastrarItem(new Livro(codigo, titulo));
                    } else if (tipoItem == 2) {
                        biblioteca.cadastrarItem(new Revista(codigo, titulo));
                    } else if (tipoItem == 3) {
                        biblioteca.cadastrarItem(new Dvd(codigo, titulo));
                    } else {
                        System.out.println("Tipo de item inválido! Cadastro cancelado.");
                    }
                    break;

                case 5:
                    System.out.print("Nome do usuário: ");
                    String nomeEmp = scanner.nextLine();
                    Usuario uEmp = biblioteca.buscarUsuario(nomeEmp);

                    if (uEmp == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.print("Código do item: ");
                    int codEmp = scanner.nextInt();
                    scanner.nextLine();
                    ItemBiblioteca iEmp = biblioteca.buscarItem(codEmp);

                    if (iEmp == null) {
                        System.out.println("Item não encontrado.");
                        break;
                    }

                    biblioteca.emprestar(uEmp, iEmp);
                    break;

                case 6:
                    System.out.print("Nome do usuário: ");
                    String nomeDev = scanner.nextLine();
                    Usuario uDev = biblioteca.buscarUsuario(nomeDev);

                    if (uDev == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.print("Código do item: ");
                    int codDev = scanner.nextInt();
                    scanner.nextLine();
                    ItemBiblioteca iDev = biblioteca.buscarItem(codDev);

                    if (iDev == null) {
                        System.out.println("Item não encontrado.");
                        break;
                    }

                    biblioteca.devolver(uDev, iDev);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }

        scanner.close();
    }
}