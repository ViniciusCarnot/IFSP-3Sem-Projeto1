package entities;

import algorithms.Ordenacao;

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
		if(numeroFuncional == null) {
			return "null";
		} else {
			return "Funcionario [numeroFuncional=" + numeroFuncional + ", nome=" + nome + ", salario=" + salario + "]";
		}
		
	}
	

	public void inserir(Integer numeroFuncional, String nome, Double salario, Funcionario vetorFuncionario[], Integer tamVetorFuncionario) {
		
		try {
			
			Ordenacao.insertionSortFuncionario(vetorFuncionario);
			
			//verificando se existe espaco para adicionar mais funcionarios
			Boolean existeEspaco = false;
			
			for(int i=0; i<tamVetorFuncionario; i++) {
				if(vetorFuncionario[i] ==  null) {
					existeEspaco = true;
				}
			}
			
			if(existeEspaco == false) {
				System.out.println("Limite máximo de funcionarios atingido!");
				return;
			}
			
			//verificando se o numero funcional escolhido, ja esta sendo usado ou nao
			Boolean estaSendoUsado = false;
			
			for(int i=0; i<tamVetorFuncionario && vetorFuncionario[i] != null; i++) {
				if(vetorFuncionario[i].getNumero_funcional() == numeroFuncional) {
					estaSendoUsado = true;
				}
			}
			
			for(int i=0; i<tamVetorFuncionario; i++) {
				if(vetorFuncionario[i] == null) {
					Funcionario f;
					if(estaSendoUsado == false) {
						f = new Funcionario(numeroFuncional, nome, salario);
						vetorFuncionario[i] = f;
						Ordenacao.insertionSortFuncionario(vetorFuncionario);
						System.out.println("Funcionario adicionado com sucesso!");
					} else {
						f = new Funcionario(i + 1, nome, salario);
						vetorFuncionario[i] = f;
						Ordenacao.insertionSortFuncionario(vetorFuncionario);
						System.out.println("Funcionario adicionado com sucesso! Porem o numero funcional escolhido, já está sendo usado. O sistema definiu outro automaticamente!");
						
					}
					System.out.println(f);
					return;
				}
			}	
			
		} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Erro, o numero funcional escolhido nao existe! Escolha outro e tente novamente!");
		} 
		catch(NullPointerException e1) {
			System.out.println(e1.getMessage());
		}
		
	}
		
					
	
	public void atualizar(Integer numeroFuncional, String novoNome, Double novoSalario, Funcionario vetorFuncionario[], Integer tamVetorFuncionario) {
		
		try {
			
			//Ordenacao.insertionSortFuncionario(vetorFuncionario);
			
			for(int i=0; i<tamVetorFuncionario && vetorFuncionario[i] != null; i++) {
				if(vetorFuncionario[i].getNumero_funcional() == numeroFuncional && vetorFuncionario[i].getNumero_funcional() != null) {
					vetorFuncionario[i].setNome(novoNome);
					vetorFuncionario[i].setSalary(novoSalario);
					System.out.println("Dados do funcionario, atualizados com sucesso!");
					System.out.println(vetorFuncionario[i]);
					return;
				} 
			}
			
			System.out.println("O numero funcional digitado nao pertence a nenhum funcionario! Tente novamente!");
			return;
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e1) {
			System.out.println(e1.getMessage());
		}
		
	}


	public void deletar(Integer numeroFuncional, Funcionario vetorFuncionario[], Integer tamVetorFuncionario) {
		
		try {
			
			for(int i=0; i<tamVetorFuncionario; i++) {
				if(vetorFuncionario[i].getNumero_funcional() == numeroFuncional) {
					vetorFuncionario[i] = null;
					System.out.println("Funcionario deletado com sucesso!");
					Ordenacao.insertionSortFuncionario(vetorFuncionario);
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
