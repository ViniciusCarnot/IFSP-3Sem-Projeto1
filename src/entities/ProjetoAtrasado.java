package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import algorithms.OrdenacaoProjetoAtrasado;

public class ProjetoAtrasado extends Projeto {
	
	private String nome;
	private String estado;
	private Integer tempoAtraso;
	
	public ProjetoAtrasado() {
	}

	public ProjetoAtrasado(String nome, String estado, Integer tempoAtraso) {
		this.nome = nome;
		this.estado = estado;
		this.tempoAtraso = tempoAtraso;
	}

	public String getNome() {
		return nome;
	}

	public String getEstado() {
		return estado;
	}

	public Integer getTempoAtraso() {
		return tempoAtraso;
	}

	@Override
	public String toString() {
		return nome + ", " + tempoAtraso + " dias de atraso, " + estado;
	}
	
	
	public void imprimirInformacoes(Projeto vetorProjeto[], Integer tamVetorProjeto) {
		
		try {
			
			ProjetoAtrasado vetorProjetosAtrasados[] = new ProjetoAtrasado[tamVetorProjeto];
			
			LocalDate dataDeRefernciaAtual = LocalDate.parse("13/08/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			for(int i=0; i < tamVetorProjeto && vetorProjeto[i] != null; i++) {
				
				LocalDate dataTerminoEsperada = vetorProjeto[i].getData_inicio().plusMonths(vetorProjeto[i].getTempo_estimado());
				
				//projetos finalizados
				if(vetorProjeto[i].getData_termino() != null) {
					Duration d01 = Duration.between(vetorProjeto[i].getData_inicio().atTime(0, 0), vetorProjeto[i].getData_termino().atTime(0, 0));
					Integer duracaoTotal = (int) (d01.toDaysPart());
					 
					//projetos finalizados com atraso
					//se a dataTermino for depois da dataTerminoEsperada, significa que ele foi finalizado com atraso
					if(vetorProjeto[i].getData_termino().isAfter(dataTerminoEsperada)) {
						Duration d02 = Duration.between(vetorProjeto[i].getData_inicio().atTime(0, 0), dataTerminoEsperada.atTime(0, 0));
						Integer duracaoEsperada = (int) (d02.toDaysPart());
						ProjetoAtrasado pa = new ProjetoAtrasado(vetorProjeto[i].getNome(), "finalizado", duracaoTotal - duracaoEsperada);
						vetorProjetosAtrasados[i] = pa;
					}
					else {
						continue;
					}
				} 
				//projetos em andamento
				else {
					Duration d03 = Duration.between(vetorProjeto[i].getData_inicio().atTime(0, 0), dataDeRefernciaAtual.atTime(0, 0));
					Integer duracaoAteDataDeRefernciaAtual = (int) (d03.toDaysPart());
					
					//projetos em andamento atrasados 
					//se a dataTerminoEsperada for antes da dataDeRefernciaAtual, significa que o projeto está em atraso
					if(dataTerminoEsperada.isBefore(dataDeRefernciaAtual) == true) {
						Duration d04 = Duration.between(vetorProjeto[i].getData_inicio().atTime(0, 0), dataTerminoEsperada.atTime(0, 0));
						Integer duracaoEsperada = (int) (d04.toDaysPart());
						ProjetoAtrasado pa = new ProjetoAtrasado(vetorProjeto[i].getNome(), "em andamento", duracaoAteDataDeRefernciaAtual - duracaoEsperada);
						vetorProjetosAtrasados[i] = pa;
					}
					else {
						continue;
					}
				}
			}
			
			//ordenando vetor pelo tempo de atraso em ordem
			OrdenacaoProjetoAtrasado.insertionSortTempoDeAtraso(vetorProjetosAtrasados);
			
			//printando vetor resultante
			for(int i=0; i < tamVetorProjeto && vetorProjetosAtrasados[i] != null; i++) {
				System.out.println(vetorProjetosAtrasados[i]);
			}
			
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(NullPointerException e1) {
			System.out.println("Erro: " + e1.getMessage());
		}
	}
	
	
}
