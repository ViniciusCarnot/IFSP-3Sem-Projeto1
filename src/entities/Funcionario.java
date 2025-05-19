package entities;

public class Funcionario {
	
	private Integer numero_funcional;
	private String nome;
	private Double salary;
	
	public Funcionario() {
	}

	public Funcionario(Integer numero_funcional, String nome, Double salary) {
		this.numero_funcional = numero_funcional;
		this.nome = nome;
		this.salary = salary;
	}

	public Integer getNumero_funcional() {
		return numero_funcional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Funcionario [numero_funcional=" + numero_funcional + ", nome=" + nome + ", salary=" + salary + "]";
	}
	
	
	
	
}
