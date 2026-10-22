package br.escola.bibliohaydee.app;
import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();

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

            System.out.print("Digite o limite de empréstimos: ");
            Integer limite = Integer.parseInt(scanner.nextLine());

            Usuario usuario = new Usuario(
                    nome, matricula, tipo, limite);

            usuarios.add(usuario);

            System.out.println("\nUsuário cadastrado com sucesso!");
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Matrícula: " + usuario.getMatricula());
            System.out.println("Tipo: " + usuario.getTipo());
            System.out.println("Limite de empréstimos: "
                    + usuario.getLimiteEmprestimos());
            System.out.println("Empréstimos ativos: "
                    + usuario.getEmprestimosAtivos());

            scanner.close();
        }
    }







