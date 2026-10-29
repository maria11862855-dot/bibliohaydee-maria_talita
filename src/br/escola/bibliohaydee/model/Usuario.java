package br.escola.bibliohaydee.model;

public class Usuario {
    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos = 0;

    public Usuario(String nomeInformado, String matriculaInformada,
                   String tipoInformado, Integer limiteInformado)
    {

  if(matriculaInformada == null ||
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
}


