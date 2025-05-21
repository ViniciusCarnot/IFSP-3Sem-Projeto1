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
			
			int j=0;
			for(int i=0; i<tamVetor; i++) {
				if(vetor[i] != null) {
					j++;
				}
			}
			if(j==tamVetor) {
				System.out.println("Limite máximo de funcionarios atingido!");
				return;
			} else if(vetor[numeroFuncional-1] == null) {
				Funcionario f = new Funcionario(numeroFuncional, nome, salario);
				vetor[numeroFuncional-1] = f;
				System.out.println("Funcionario adicionado com sucesso!");
				System.out.println(f);
			} else {
				for(int i=0; i<tamVetor; i++) {
					if(vetor[i] == null) {
						Funcionario f = new Funcionario(i+1, nome, salario);
						vetor[i] = f;
						System.out.println("Funcionario adicionado com sucesso! Porem o numero funcional escolhido, já está sendo usado. O sistema definiu outro automaticamente!");
						System.out.println(f);
						return;
					}
				}
			}	
		} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Erro, o numero funcional escolhido nao existe! Escolha outro e tente novamente!");
		}
	}
		
					
	
	public void atualizar(Integer numeroFuncional, String novoNome, Double novoSalario, Funcionario vetor[], Integer tamVetor) {
		
		try {
			
			for(int i=0; i<tamVetor; i++) {
				if(vetor[i].getNumero_funcional() == numeroFuncional) {
					vetor[i].setNome(novoNome);
					vetor[i].setSalary(novoSalario);
					System.out.println("Dados do funcionario, atualizados com sucesso!");
					System.out.println(vetor[i]);
					return;
				} 
			}
			System.out.println("Erro, o numero funcional digitado nao pertence a nenhum funcionario! Tente novamente!");
			return;
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro, o numero funcional digitado nao existe! Escolha outro e tente novamente!");
		}
		catch(NullPointerException e1) {
			System.out.println("Erro, nao existe funcionario cadastrado nesse numero funcional para ser atualizado! Escolha outro e tente novamente!");
		}
		
	}


	public void deletar(Integer numeroFuncional, Funcionario vetor[], Integer tamVetor) {
		
		try {
			
			for(int i=0; i<tamVetor; i++) {
				if(vetor[i].getNumero_funcional() == numeroFuncional) {
					vetor[i] = null;
					System.out.println("Funcionario deletado com sucesso!");
					return;
				}
			}
			System.out.println("Erro, o numero funcional digitado nao pertence a nenhum funcionario! Tente novamente!");
			return;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro, o numero funcional digitado nao existe! Escolha outro e tente novamente!");
		}
		
	}
	
	
	
	
}
