package model;

public class Professor extends Funcionario{
	private String materia;
	
	public Professor() {
		System.out.println("Professor criado!");
	}

	
	public Professor(String materia) {
		this.materia = materia;
	}
	
	

	public String getMateria() {
		return materia;
	}


	public void setMateria(String materia) {
		this.materia = materia;
	}


	public void exibe() {	
		super.exibe();
		System.out.println("Matéria do professor: " + materia);
	}
}

