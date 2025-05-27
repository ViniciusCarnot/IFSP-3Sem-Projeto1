package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import algorithms.OrdenacaoFuncionario;
import algorithms.OrdenacaoProjeto;

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
	
	public void imprimirFuncionariosResponsaveisPorProjetosEmAndamento(Projeto vetorProjeto[], Integer tamVetorProjeto, Integer tamVetorFuncionario) {
		
		try {
			
			Funcionario vetorFuncionariosResponsaveis[] = new Funcionario[tamVetorFuncionario];
			Funcionario vetorResultante[] = new Funcionario[tamVetorFuncionario];
			
			//armazenando funcionarios responsáveis por projetos em andamento, *tem repetição de funcionários
			for(int i=0; i < tamVetorProjeto && vetorProjeto[i] != null; i++) {
				//projetos em andamento
				if(vetorProjeto[i].getData_termino() == null) {
					
					vetorFuncionariosResponsaveis[i] = vetorProjeto[i].getFuncionario();
					
				} else {
					continue;
				}
			}
			
			//ordenando vetorFuncionariosResponsaveis
			OrdenacaoFuncionario.insertionSort(vetorFuncionariosResponsaveis);
			
			//armazenando funcionarios responsáveis por projetos em andamento, *sem repetição de funcionários
			for(int i=0; i < tamVetorFuncionario && vetorFuncionariosResponsaveis[i] != null; i++) {
				
				//se isso acontecer, siginifica que o funcionario do vetorFuncionariosResponsaveis ainda não foi adicionado no vetorResultante
				if(OrdenacaoFuncionario.buscaBinariaNumeroFuncional(vetorResultante, vetorFuncionariosResponsaveis[i].getNumero_funcional()) == -1) {
					vetorResultante[i] = vetorFuncionariosResponsaveis[i];
					OrdenacaoFuncionario.insertionSort(vetorResultante);
				}
				
			}
			
			//ordenando vetorResultante
			OrdenacaoFuncionario.insertionSort(vetorResultante);
			
			//printando vetor resultante
			for(int i=0; i < tamVetorFuncionario && vetorResultante[i] != null; i++) {
				System.out.println(vetorResultante[i]);
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(NullPointerException e1) {
			System.out.println("Erro: " + e1.getMessage());
		}
		
		
	}
	
	public void projetosEmAndamentoMaisDe500Mil(Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
		try {
			
			//projetos em andamento, data de termino = null
			
			Projeto vetorProjetosEmAndamento[] = new Projeto[tamVetorProjeto];
			
			int j=0;
			for(int i=0; i < tamVetorProjeto && vetorProjeto[i] != null; i++) {
				if(vetorProjeto[i].getData_termino() == null && vetorProjeto[i].getValor_estimado() > 500000.0) {
					vetorProjetosEmAndamento[j] = vetorProjeto[i];
					j++;
				}
			}
			
			OrdenacaoProjeto.shellSort(vetorProjetosEmAndamento);
			
			for(int i=0; i < tamVetorProjeto && vetorProjetosEmAndamento[i] != null; i++) {
				System.out.println(vetorProjetosEmAndamento[i]);
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(NullPointerException e1) {
			System.out.println("Erro: " + e1.getMessage());
		}
	}
	
	
	
		
	
	public void inserirProjeto(String nomeProjeto, LocalDate dataInicio, LocalDate dataTermino, Integer tempoEstimado, Double valorEstimado, 
			Integer numeroFuncional, Funcionario vetorFuncionario[], Integer tamVetorFuncionario, Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
		
		try {
			
			
			
			OrdenacaoProjeto.insertionSort(vetorProjeto);
			
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
			Integer indFuncionario = null;
			
			for(int i=0; i<tamVetorFuncionario && vetorFuncionario[i] != null; i++) {
				if(numeroFuncional == vetorFuncionario[i].getNumero_funcional()) {
					funcionarioExiste = true;
					indFuncionario = i;
					break;
				}
			}
			
			if(funcionarioExiste == false) {
				System.out.println("O funcionario digitado nao existe, logo o projeto nao pode ser adicionado!");
				return;
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
					tempoEstimado, valorEstimado, vetorFuncionario[indFuncionario]);
			vetorProjeto[indEspacoLivre] = p;
			System.out.println("Projeto adicionado com sucesso!");
			OrdenacaoProjeto.insertionSort(vetorProjeto);
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
			Integer indProjetoExistente = null;
			
			for(int i=0; i<tamVetorProjeto && vetorProjeto[i] != null; i++) {
				if(nomeProjeto.equals(vetorProjeto[i].getNome())) {
					projetoExiste = true;
					indProjetoExistente = i;
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
				vetorProjeto[indProjetoExistente].setData_inicio(dataInicio);
				vetorProjeto[indProjetoExistente].setTempo_estimado(tempoEstimado);
				vetorProjeto[indProjetoExistente].setValor_estimado(valorEstimado);
				vetorProjeto[indProjetoExistente].setFuncionario(vetorFuncionario[indFuncionario]);
				if(dataTermino != null) {
					vetorProjeto[indProjetoExistente].setData_termino(dataTermino);
				} else {
					vetorProjeto[indProjetoExistente].setData_termino(null);
				}
				System.out.println("Projeto atualizado com sucesso!");
				System.out.println(vetorProjeto[indProjetoExistente]);
				return;
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
			OrdenacaoProjeto.insertionSort(vetorProjeto);
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
