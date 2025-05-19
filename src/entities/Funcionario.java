package entities;

public class Funcionario {
	
	private Integer numeroFuncional;
	private String nome;
	private Double salario;
	
	public Funcionario() {
	}

	public Funcionario(Integer numeroFuncional, String nome, Double salario) {
		this.numeroFuncional = numeroFuncional;
		this.nome = nome;
		this.salario = salario;
	}

	public Integer getNumero_funcional() {
		return numeroFuncional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalary() {
		return salario;
	}

	public void setSalary(Double salario) {
		this.salario = salario;
	}
	

	@Override
	public String toString() {
		return "Funcionario [numeroFuncional=" + numeroFuncional + ", nome=" + nome + ", salario=" + salario + "]";
	}
	

	public void inserir(Integer numeroFuncional, String nome, Double salario, Funcionario vetor[], Integer tamVetor) {
		
		try {
			if(vetor[numeroFuncional-1] == null) {
				Funcionario f = new Funcionario(numeroFuncional, nome, salario);
				vetor[numeroFuncional-1] = f;
				System.out.println("Insercao concluida!");
				System.out.println(f);
			} else if(vetor[numeroFuncional-1] != null){
				for(int i=0; i<tamVetor; i++) {
					if(vetor[i] == null) {
						Funcionario f = new Funcionario(i+1, nome, salario);
						vetor[i] = f;
						System.out.println("Insercao concluida! Porem o numero funcional digitado precisou ser alterado!");
						System.out.println(f);
						return;
					}
				}
			} else {
				System.out.println("Limite máximo de funcionarios atingidos!");
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro, tente novamente!" + e.getMessage());
		}
	}
		
					
						
		

	
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}


	public void deletar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
