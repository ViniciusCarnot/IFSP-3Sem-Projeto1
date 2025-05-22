package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import algorithms.OrdenacaoPorNome;

public class Projeto {
	
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private Integer tempoEstimado;
	private Double valorEstimado;
	
	private Funcionario funcionario;
	
	public Projeto() {
	}

	public Projeto(String nome, LocalDate dataInicio, LocalDate dataTermino, Integer tempoEstimado,
			Double valorEstimado, Funcionario funcionario) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.tempoEstimado = tempoEstimado;
		this.valorEstimado = valorEstimado;
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getData_inicio() {
		return dataInicio;
	}

	public void setData_inicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getData_termino() {
		return dataTermino;
	}

	public void setData_termino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Integer getTempo_estimado() {
		return tempoEstimado;
	}

	public void setTempo_estimado(Integer tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public Double getValor_estimado() {
		return valorEstimado;
	}

	public void setValor_estimado(Double valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public String toString() {
		if(nome == null) {
			return "null";
			
		} else {
			
			if(dataTermino != null) {
				return "Projeto [nome=" + nome + ", dataInicio=" + dataInicio.format(dtf) + ", dataTermino=" + dataTermino.format(dtf)
						+ ", tempoEstimado(meses)=" + tempoEstimado + ", valorEstimado=" + valorEstimado + ", funcionario="
						+ funcionario + "]";
			} 
			else {
				return "Projeto [nome=" + nome + ", dataInicio=" + dataInicio.format(dtf) + ", dataTermino=em andamento"
				+ ", tempoEstimado(meses)=" + tempoEstimado + ", valorEstimado=" + valorEstimado + ", funcionario="
				+ funcionario + "]";
			}
		}
	}
	
	public void inserirProjeto(String nomeProjeto, LocalDate dataInicio, LocalDate dataTermino, Integer tempoEstimado, Double valorEstimado, 
			Integer numeroFuncional, Funcionario vetorFuncionario[], Integer tamVetorFuncionario, Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
		
		try {
			
			OrdenacaoPorNome.insertionSort(vetorProjeto);
			
			//verificar se existe espaço para armazenar um projeto
			Boolean espacoLivre = false;
			Integer indEspacoLivre = null;
			
			for(int i=0; i<tamVetorProjeto; i++) {
				if(vetorProjeto[i] == null) {
					espacoLivre = true;
					indEspacoLivre = i;
					break;
				}
			}
			
			if(espacoLivre == false) {
				System.out.println("Nao existe espaco para armazenar mais projetos!");
				return;
			}
			
			
			//verificar se existe um projeto criado com o mesmo nome
			Boolean mesmoNome = false;
			
			for(int i=0; vetorProjeto[i] != null; i++) {
				if(nomeProjeto.equals(vetorProjeto[i].getNome())) {
					mesmoNome = true;
					System.out.println("Ja existe outro projeto de mesmo nome! Escolha outro nome e tente novamente!");
					return;
				}
			}
				
			//verificar se o funcionario responsavel pelo projeto, existe
			Boolean funcionarioExiste = false;
			
			for(int i=0; i < tamVetorFuncionario && funcionarioExiste != true; i++) {
				if(vetorFuncionario[i] == null && funcionarioExiste != true || funcionario == null) {
					System.out.println("O funcionario digitado nao existe, logo o projeto nao pode ser adicionado!");
					return;
				} else if(funcionario.getNumero_funcional() == vetorFuncionario[i].getNumero_funcional()) {
					funcionarioExiste = true;
					break;
				}	
			}	
		
			//alocando projeto no vetor de projetos
			
		/*  // 1 VERSÃO
			if(espacoLivre == true && mesmoNome == false && funcionarioExiste == true) {
				Projeto p = new Projeto(nomeProjeto, dataInicio, dataTermino, tempoEstimado, valorEstimado, funcionario);
				for(int i=0; i<tamVetorProjeto; i++) {
					if(vetorProjeto[i] == null) {
							vetorProjeto[i] = p;
							OrdenacaoPorNome.insertionSort(vetorProjeto);
							System.out.println("Projeto adicionado com sucesso!");
							System.out.println(p);
							return;
					}
				}
			}*/
			
			// 2 VERSÃO
			Projeto p = new Projeto(nomeProjeto, dataInicio, dataTermino, 
					tempoEstimado, valorEstimado, vetorFuncionario[numeroFuncional]);
			vetorProjeto[indEspacoLivre] = p;
			System.out.println("Projeto adicionado com sucesso!");
			System.out.println(p);
			return;				
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(NullPointerException e1) {
			System.out.println("Erro: " + e1.getMessage());
		}
		
	}
	
	
	public void atualizarProjeto(String nomeProjeto, LocalDate dataInicio, LocalDate dataTermino, Integer tempoEstimado, Double valorEstimado, 
			Integer numeroFuncional, Funcionario vetorFuncionario[], Integer tamVetorFuncionario, Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
		try {
			
			//verificar se o projeto existe
			Boolean projetoExiste = false;
			
			for(int i=0; vetorProjeto[i] != null; i++) {
				if(nomeProjeto.equals(vetorProjeto[i].getNome())) {
					projetoExiste = true;
					break;
				}
			}
			
			if(projetoExiste == false) {
				System.out.println("Não foi encontrado o projeto digitado! Verique se o nome do projeto esta escrito corretamente e tente de novo!");
				return;
			}
			
			//verificar se o novo funcionario, existe
			Boolean funcionarioExiste = false;
			
		/*	// 1 VERSÃO
			for(int i=0; i < tamVetorFuncionario && funcionarioExiste != true; i++) {
				if(vetorFuncionario[i] == null && funcionarioExiste != true || funcionario == null) {
					System.out.println("O novo funcionario digitado nao existe, logo o projeto nao pode ser atualizado!");
					return;
				} else if(funcionario.getNumero_funcional() == vetorFuncionario[i].getNumero_funcional()) {
					funcionarioExiste = true;
					break;
				}	
			}*/	
			
			// 2 VERSÃO
			Integer indFuncionario = null;
			for(int i=0; i < tamVetorFuncionario && vetorFuncionario[i] != null; i++) {
				if(vetorFuncionario[i].getNumero_funcional() == numeroFuncional) {
					funcionarioExiste = true;
					indFuncionario = i;
					break;
				}
			}
			
			if(funcionarioExiste == false) {
				System.out.println("O novo funcionario digitado nao existe, logo o projeto nao pode ser atualizado!");
				return;
			}
			
			
			//atualizando projeto
			if(projetoExiste == true && funcionarioExiste == true) {
				for(int i=0; i<tamVetorProjeto; i++) {
					if(vetorProjeto[i].getNome().equals(nomeProjeto)) {
						vetorProjeto[i].setData_inicio(dataInicio);
						vetorProjeto[i].setTempo_estimado(tempoEstimado);
						vetorProjeto[i].setValor_estimado(valorEstimado);
						vetorProjeto[i].setFuncionario(vetorFuncionario[indFuncionario]);
						if(dataTermino != null) {
							vetorProjeto[i].setData_termino(dataTermino);
						} else {
							vetorProjeto[i].setData_termino(null);
						}
							System.out.println("Projeto atualizado com sucesso!");
							System.out.println(vetorProjeto[i]);
							return;
					}
				}
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(NullPointerException e1) {
			System.out.println("Erro: " + e1.getMessage());
		}
		
	}
	
	public void deletarProjeto(String nomeProjeto, Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
		try {
			
			//verificar se o projeto existe
			Boolean projetoExiste = false;
			Integer indProjetoExiste = null;
			
			for(int i=0; i < tamVetorProjeto && vetorProjeto[i] != null; i++) {
				if(nomeProjeto.equals(vetorProjeto[i].getNome())) {
					projetoExiste = true;
					indProjetoExiste = i;
					break;
				}
			}
			
			if(projetoExiste == false) {
				System.out.println("Não foi encontrado o projeto digitado! Verique se o nome do projeto esta escrito corretamente e tente de novo!");
				return;
			}
			
			//deletar projeto do vetor de projeto
			
		/*  // 1 VERSÃO	
			if(projetoExiste == true) {
				for(int i=0; i<tamVetorProjeto; i++) {
					if(nomeProjeto.equals(vetorProjeto[i].getNome())) {
							vetorProjeto[i] = null;
							System.out.println("Projeto deletado com sucesso!");
							OrdenacaoPorNome.insertionSort(vetorProjeto);
							return;
					}
				}
			}*/
			
			// 2 VERSÃO
			vetorProjeto[indProjetoExiste] =  null;
			System.out.println("Projeto deletado com sucesso!");
			OrdenacaoPorNome.insertionSort(vetorProjeto);
			return;
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(NullPointerException e1) {
			System.out.println("Erro: " + e1.getMessage());
		}
		
		
		}
	
}
