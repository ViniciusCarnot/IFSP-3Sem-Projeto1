package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		if(dataTermino != null) {
			return "Projeto [nome=" + nome + ", dataInicio=" + dataInicio.format(dtf) + ", dataTermino=" + dataTermino.format(dtf)
					+ ", tempoEstimado(meses)=" + tempoEstimado + ", valorEstimado=" + valorEstimado + ", funcionario="
					+ funcionario + "]";
		} else {
			return "Projeto [nome=" + nome + ", dataInicio=" + dataInicio.format(dtf) + ", dataTermino=em andamento"
			+ ", tempoEstimado(meses)=" + tempoEstimado + ", valorEstimado=" + valorEstimado + ", funcionario="
			+ funcionario + "]";
		}
	}
	
	public void inserirProjetoFinalizado(String nomeProjeto, LocalDate dataInicio, LocalDate dataTermino, Integer tempoEstimado, Double valorEstimado, 
			Funcionario funcionario, Funcionario vetorFuncionario[], Integer tamVetorFuncionario, Projeto projeto, Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
		
		try {
			
			//verificar se existe espaço para armazenar um projeto
			Boolean espacoLivre = false;
			
			for(int i=0; i<tamVetorProjeto; i++) {
				if(vetorProjeto[i] == null) {
					espacoLivre = true;
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
				}	
			}	
		
			//alocando projeto no vetor de projetos
			if(espacoLivre == true && mesmoNome == false && funcionarioExiste == true) {
				Projeto p = new Projeto(nomeProjeto, dataInicio, dataTermino, tempoEstimado, valorEstimado, funcionario);
				for(int i=0; i<tamVetorProjeto; i++) {
					if(vetorProjeto[i] == null) {
							vetorProjeto[i] = p;
							System.out.println("Projeto adicionado com sucesso!");
							System.out.println(p);
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
	
	public void inserirProjetoEmAndamento(String nomeProjeto, LocalDate dataInicio, Integer tempoEstimado, Double valorEstimado, 
			Funcionario funcionario, Funcionario vetorFuncionario[], Integer tamVetorFuncionario, Projeto projeto, Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
	}
	
	
	
}
