package model;

public class Funcionario {
	private String nome;
	private String cpf;
	private double salario;
	
	public Funcionario() {
		System.out.println("Funcionário criado! ");
	}
	public Funcionario(String nome, String cpf, String salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = 0;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void exibe() {
		System.out.println("Nome do funcionário: " + nome);
		System.out.println("CPF do funcionário: " + cpf);
		System.out.println("Salário do funcionário: " + salario);
	}
}

