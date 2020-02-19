package model;

public class Aluno {
	private String numeroMatricula;
	private String nomeAluno;
	private char sexo;
	private Data dataNascimento;
	
	public Aluno() {
	}

	public Aluno(String numeroMatricula, String nomeAluno, char sexo, Data dataNascimento) {
		this.numeroMatricula = numeroMatricula;
		this.nomeAluno = nomeAluno;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
