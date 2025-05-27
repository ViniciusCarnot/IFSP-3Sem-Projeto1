package entities;


import algorithms.OrdenacaoFuncionario;

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
	
	
	
	public void salarioMaiorDezMil(Funcionario vetorFuncionario[], Integer tamVetorFuncionario) {
		
		try {
			
			Funcionario funcionariosMaiorDezMil[] = new Funcionario[tamVetorFuncionario];
			
			for(int i=0; i<tamVetorFuncionario && vetorFuncionario[i] != null; i++) {
				if(vetorFuncionario[i].getSalary() > 10000.0) {
					funcionariosMaiorDezMil[i] = vetorFuncionario[i];
				}
			}
			
			OrdenacaoFuncionario.insertionSortSalarioDecrescente(funcionariosMaiorDezMil);
			
			for(int i = vetorFuncionario.length - 1; i >= 0 && funcionariosMaiorDezMil[i] != null; i--) {
				System.out.println(funcionariosMaiorDezMil[i]);
			}
			
		} 
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} 
		catch(NullPointerException e1) {
			System.out.println(e1.getMessage());
		}
		
		
	}
	
	public void inserir(Integer numeroFuncional, String nome, Double salario, Funcionario vetorFuncionario[], Integer tamVetorFuncionario) {
		
		try {
			
			OrdenacaoFuncionario.insertionSort(vetorFuncionario);
			
			//verificando se existe espaco para adicionar mais funcionarios
			Boolean existeEspaco = false;
			
			for(int i=0; i<tamVetorFuncionario; i++) {
				if(vetorFuncionario[i] ==  null) {
					existeEspaco = true;
					break;
				}
			}
			
			if(existeEspaco == false) {
				System.out.println("Limite máximo de funcionarios atingido!");
				return;
			}
			
			//verificando se o numero funcional escolhido, ja esta sendo usado ou nao
			
			Boolean estaSendoUsado = false;
			
			Integer busca = OrdenacaoFuncionario.buscaBinariaNumeroFuncional(vetorFuncionario, numeroFuncional);
			
			if(busca != -1) {
				estaSendoUsado = true;
			}
			
			
			
			/*
			for(int i=0; i<tamVetorFuncionario && vetorFuncionario[i] != null; i++) {
				if(vetorFuncionario[i].getNumero_funcional() == numeroFuncional) {
					estaSendoUsado = true;
					break;
				}
			}*/
			
			for(int i=0; i<tamVetorFuncionario; i++) {
				if(vetorFuncionario[i] == null) {
					Funcionario f;
					if(estaSendoUsado == false) {
						f = new Funcionario(numeroFuncional, nome, salario);
						vetorFuncionario[i] = f;
						OrdenacaoFuncionario.insertionSort(vetorFuncionario);
						System.out.println("Funcionario adicionado com sucesso!");
					} else {
						int j = i;
						Integer novoNumeroFuncional = 0;
						do {
							novoNumeroFuncional = j+1;
							//verificando se o novo número funcional estabelecido pelo sistema já está sendo usado
							busca = OrdenacaoFuncionario.buscaBinariaNumeroFuncional(vetorFuncionario, novoNumeroFuncional);
							j++;
						} while(busca != -1);
						f = new Funcionario(novoNumeroFuncional, nome, salario);
						vetorFuncionario[i] = f;
						OrdenacaoFuncionario.insertionSort(vetorFuncionario);
						System.out.println("Funcionario adicionado com sucesso! Porem o numero funcional escolhido, já está sendo usado. O sistema definiu outro automaticamente!");
						
					}
					System.out.println(f);
					return;
				}
			}	
			
		} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println(e.getMessage());
		} 
		catch(NullPointerException e1) {
			System.out.println(e1.getMessage());
		}
		
	}
		
					
	
	public void atualizar(Integer numeroFuncional, String novoNome, Double novoSalario, Funcionario vetorFuncionario[], Integer tamVetorFuncionario) {
		
		try {
			
			//verificando se o funcionario existe
			
			Integer busca = OrdenacaoFuncionario.buscaBinariaNumeroFuncional(vetorFuncionario, numeroFuncional);
			
			if(busca == -1) {
				System.out.println("O numero funcional digitado nao pertence a nenhum funcionario! Tente novamente!");
				return;
			} else {
				vetorFuncionario[busca].setNome(novoNome);
				vetorFuncionario[busca].setSalary(novoSalario);
				System.out.println("Dados do funcionario, atualizados com sucesso!");
				System.out.println(vetorFuncionario[busca]);
				return;
			}
			
			/*
			for(int i=0; i<tamVetorFuncionario && vetorFuncionario[i] != null; i++) {
				if(vetorFuncionario[i].getNumero_funcional() == numeroFuncional) {
					vetorFuncionario[i].setNome(novoNome);
					vetorFuncionario[i].setSalary(novoSalario);
					System.out.println("Dados do funcionario, atualizados com sucesso!");
					System.out.println(vetorFuncionario[i]);
					return;
				} 
			}*/
			
			
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
			
			//verificando se o funcionário existe
			
			Integer busca = OrdenacaoFuncionario.buscaBinariaNumeroFuncional(vetorFuncionario, numeroFuncional);
			
			if(busca == -1) {
				System.out.println("Erro, o numero funcional digitado nao pertence a nenhum funcionario! Tente novamente!");
				return;
			} else {
				vetorFuncionario[busca] = null;
				System.out.println("Funcionario deletado com sucesso!");
				OrdenacaoFuncionario.insertionSort(vetorFuncionario);
				return;
			}
			
			/*
			for(int i=0; i<tamVetorFuncionario && vetorFuncionario[i] != null; i++) {
				if(vetorFuncionario[i].getNumero_funcional() == numeroFuncional) {
					vetorFuncionario[i] = null;
					System.out.println("Funcionario deletado com sucesso!");
					Ordenacao.insertionSortFuncionario(vetorFuncionario);
					return;
				}
			}*/
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e1) {
			System.out.println(e1.getMessage());
		}
		
		
	}
	
	
	
	
}
