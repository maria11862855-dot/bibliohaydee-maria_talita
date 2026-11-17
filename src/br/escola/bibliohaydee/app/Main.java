package br.escola.bibliohaydee.app;
import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
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
        Autor machado = autor;

        Autor graciliano = new Autor();
        graciliano.setNome("Graciliano Ramos");
        graciliano.setNacionalidade("Brasileiro");
        graciliano.setAnoNascimento(1892);

        Autor aluisio = new Autor();
        aluisio.setNome("Aluísio Azevedo");
        aluisio.setNacionalidade("Brasileiro");
        aluisio.setAnoNascimento(1857);

        Autor jorge = new Autor();
        jorge.setNome("Jorge Amado");
        jorge.setNacionalidade("Brasileiro");
        jorge.setAnoNascimento(1912);

        livros.add(new Livro("Memórias Póstumas de Brás Cubas",
                "978-1", machado, 1881, "Romance"));

        livros.add(new Livro("Quincas Borba",
                "978-2", machado, 1891, "Romance"));

        livros.add(new Livro("Vidas Secas",
                "978-3", graciliano, 1938, "Romance"));

        livros.add(new Livro("O Cortiço",
                "978-4", aluisio, 1890, "Romance"));

        livros.add(new Livro("Capitães da Areia",
                "978-5", jorge, 1937, "Romance"));
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
        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA HAYDEE =====");
            System.out.println("1 - Pesquisar por título");
            System.out.println("2 - Pesquisar por autor");
            System.out.println("3 - Gerar relatório do acervo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    pesquisarPorTitulo(livros, scanner);
                    break;

                case 2:
                    pesquisarPorAutor(livros, scanner);
                    break;

                case 3:
                    gerarRelatorio(livros);
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

                scanner.close();
            }
    private static void pesquisarPorTitulo(
            List<Livro> livros, Scanner scanner) {

        System.out.print("Digite parte do título: ");
        String termo = scanner.nextLine();

        if (termo.isBlank()) {
            System.out.println("Digite um título válido.");
            return;
        }

        termo = termo.trim().toLowerCase();

        boolean encontrou = false;

        for (Livro l : livros) {
            String titulo = l.getTitulo().trim().toLowerCase();

            if (titulo.contains(termo)) {
                System.out.println(l);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro encontrado.");
        }
    }
    private static void pesquisarPorAutor(
            List<Livro> livros, Scanner scanner) {

        System.out.print("Digite o nome do autor: ");
        String termo = scanner.nextLine();

        if (termo.isBlank()) {
            System.out.println("Digite um nome válido.");
            return;
        }

        termo = termo.trim().toLowerCase();

        boolean encontrou = false;

        for (Livro l : livros) {
            String nomeAutor = l.getAutor().getNome()
                    .trim().toLowerCase();

            boolean corresponde = nomeAutor.equals(termo);

            String[] partesNome = nomeAutor.split("\\s+");
            for (String parte : partesNome) {
                if (parte.equals(termo)) {
                    corresponde = true;
                }
            }

            if (corresponde) {
                System.out.println(l);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Autor não encontrado.");
        }
    }
    private static void gerarRelatorio(List<Livro> livros) {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append("===== RELATÓRIO DO ACERVO =====\n");
        if (livros.isEmpty()) {
            relatorio.append("Não há livros no acervo.\n");
        }
        else {
            for (int i = 0; i < livros.size(); i++) {
                Livro l = livros.get(i);
                relatorio.append(i + 1)
                        .append(" - ")
                        .append(l.getTitulo())
                        .append(" | Autor: ")
                        .append(l.getAutor().getNome())
                        .append(" | Disponível: ")
                        .append(l.isDisponivel())
                        .append("\n");
            }
            relatorio.append("Total de livros: ")
                    .append(livros.size())
                    .append("\n");
        }
        System.out.println(relatorio.toString());
    }
        }








