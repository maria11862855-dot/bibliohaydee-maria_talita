package br.escola.bibliohaydee.app;
import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileiro");
        autor.setAnoNascimento(1839);

        autores.add(autor);

        Livro livro = new Livro(
                "Dom Casmurro",
                "978-85-359-0277-5",
                autor,
                1899,
                "Romance"
        );
        Livro livroSemGenero = new Livro(
                "Dom Casmurro",
                "978-85-359-0277-5",
                autor,
                1899
        );

        System.out.println("Gênero do livro: " + livroSemGenero.getGenero());

        livros.add(livro);

        System.out.println("===== AUTORES =====");

        for (Autor a : autores) {
            System.out.println(a);
        }

        System.out.println("\n===== ACERVO =====");

        if (livros.isEmpty()) {
            System.out.println("O acervo está vazio.");
        } else {
            for (Livro l : livros) {
                System.out.println(l);
            }
        }


        List<Usuario> usuarios = new ArrayList<>();
        String nome;


        do {
            System.out.print("\nDigite o nome: ");
            nome = scanner.nextLine();


            if (nome.trim().isEmpty()) {
                System.out.println(
                        "O nome não pode ser vazio.");
            }
        } while (nome.trim().isEmpty());


        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();


        String tipo;


        do {
            System.out.print(
                    "Digite o tipo (ALUNO ou PROFESSOR): ");


            tipo = scanner.nextLine().trim().toUpperCase();


            if (!tipo.equals("ALUNO")
                    && !tipo.equals("PROFESSOR")) {
                System.out.println(
                        "Tipo inválido. Digite ALUNO ou PROFESSOR.");
            }
        } while (!tipo.equals("ALUNO")
                && !tipo.equals("PROFESSOR"));


        System.out.print("Definir o limite? (S/N): ");
        String resposta = scanner.nextLine().trim().toUpperCase();

        Usuario usuario;

        if (resposta.equals("S")) {
            System.out.print("Digite o limite de empréstimos: ");
            Integer limite = Integer.parseInt(scanner.nextLine());

            usuario = new Usuario(nome, matricula, tipo, limite);
        } else {
            usuario = new Usuario(nome, matricula, tipo);
        }

        usuarios.add(usuario);


        System.out.println("\nUsuário cadastrado com sucesso!");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite de empréstimos: "
                + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: "
                + usuario.getEmprestimosAtivos());

        System.out.print("\nDigite a matrícula do usuário que deseja atualizar: ");
        String matriculaBusca = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(usuarios, matriculaBusca);

        if (usuarioEncontrado == null) {
            System.out.println("Usuário não localizado. Nenhuma alteração feita.");
        } else {
            System.out.println("\nUsuário encontrado:");
            System.out.println("Nome: " + usuarioEncontrado.getNome());
            System.out.println("Matrícula: " + usuarioEncontrado.getMatricula());
            System.out.println("Tipo: " + usuarioEncontrado.getTipo());
            System.out.println("Limite: " + usuarioEncontrado.getLimiteEmprestimos());

            System.out.println("\nO que deseja atualizar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Limite de empréstimos");
            System.out.print("Escolha: ");

            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();

                if (usuarioEncontrado.setNome(novoNome)) {
                    System.out.println("Nome atualizado com sucesso!");
                } else {
                    System.out.println("Nome inválido. Nenhuma alteração feita.");
                }

            } else if (opcao.equals("2")) {
                System.out.print("Digite o novo limite: ");
                String entradaLimite = scanner.nextLine();

                try {
                    int novoLimite = Integer.parseInt(entradaLimite);

                    if (usuarioEncontrado.setLimiteEmprestimos(novoLimite)) {
                        System.out.println("Limite atualizado com sucesso!");
                    } else {
                        System.out.println("Limite inválido. Nenhuma alteração feita.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Digite um número válido. Nenhuma alteração feita.");
                }

            } else {
                System.out.println("Opção inválida. Nenhuma alteração feita.");
            }
        }
        List<Usuario> usuarios = new ArrayList<>();



            String nome;

            do {
                System.out.print("\nDigite o nome: ");
                nome = scanner.nextLine();

                if (nome.trim().isEmpty()) {
                    System.out.println(
                            "O nome não pode ser vazio.");
                }
            } while (nome.trim().isEmpty());

            System.out.print("Digite a matrícula: ");
            String matricula = scanner.nextLine();

            String tipo;

            do {
                System.out.print(
                        "Digite o tipo (ALUNO ou PROFESSOR): ");

                tipo = scanner.nextLine().trim().toUpperCase();

}
