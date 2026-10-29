package br.escola.bibliohaydee.model;


public class Usuario {
    public static final int LIMITE_PADRAO = 3;
    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos = 0;

    public Usuario(String nomeInformado, String matriculaInformada,
                   String tipoInformado, Integer limiteInformado) {

        if (matriculaInformada == null ||
                matriculaInformada.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (tipoInformado == null ||
                (!tipoInformado.trim().equalsIgnoreCase("ALUNO")
                        && !tipoInformado.trim().equalsIgnoreCase("PROFESSOR"))) {
            throw new IllegalArgumentException(
                    "O tipo deve ser ALUNO ou PROFESSOR.");
        }
        nome = nomeInformado.trim();
        matricula = matriculaInformada;
        tipo = tipoInformado.trim().toUpperCase();
        limiteEmprestimos = limiteInformado;
        emprestimosAtivos = 0;
    }

    public Usuario(String nome, String matricula, String tipo) {
        this(nome, matricula, tipo, LIMITE_PADRAO);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getEmprestimosAtivos() {
        return emprestimosAtivos;
    }
    public static boolean nomeValido(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    public static boolean limiteValido(int limite) {
        return limite >= 1;
    }
    public boolean setNome(String nome) {
        if (!nomeValido(nome)) {
            return false;
        }

        this.nome = nome.trim();
        return true;
    }

    public boolean setLimiteEmprestimos(int limiteEmprestimos) {
        if (!limiteValido(limiteEmprestimos)) {
            return false;
        }

        this.limiteEmprestimos = limiteEmprestimos;
        return true;
    }
}
