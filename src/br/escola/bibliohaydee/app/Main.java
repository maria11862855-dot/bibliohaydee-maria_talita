package br.escola.bibliohaydee.app;
import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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
    }

}
