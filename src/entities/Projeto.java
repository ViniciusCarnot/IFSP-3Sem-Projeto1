package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Projeto {
	
	private String nome;
	private LocalDate data_inicio;
	private LocalDate data_termino;
	private Integer tempo_estimado;
	private Double valor_estimado;
	
	private Funcionario funcionario;
	
	public Projeto() {
	}

	public Projeto(String nome, LocalDate data_inicio, LocalDate data_termino, Integer tempo_estimado,
			Double valor_estimado, Funcionario funcionario) {
		this.nome = nome;
		this.data_inicio = data_inicio;
		this.data_termino = data_termino;
		this.tempo_estimado = tempo_estimado;
		this.valor_estimado = valor_estimado;
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}

	public LocalDate getData_termino() {
		return data_termino;
	}

	public void setData_termino(LocalDate data_termino) {
		this.data_termino = data_termino;
	}

	public Integer getTempo_estimado() {
		return tempo_estimado;
	}

	public void setTempo_estimado(Integer tempo_estimado) {
		this.tempo_estimado = tempo_estimado;
	}

	public Double getValor_estimado() {
		return valor_estimado;
	}

	public void setValor_estimado(Double valor_estimado) {
		this.valor_estimado = valor_estimado;
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
		if(data_termino != null) {
			return "Projeto [nome=" + nome + ", data_inicio=" + data_inicio.format(dtf) + ", data_termino=" + data_termino.format(dtf)
					+ ", tempo_estimado(meses)=" + tempo_estimado + ", valor_estimado=" + valor_estimado + ", funcionario="
					+ funcionario + "]";
		} else {
			return "Projeto [nome=" + nome + ", data_inicio=" + data_inicio.format(dtf) + ", data_termino=em andamento"
			+ ", tempo_estimado(meses)=" + tempo_estimado + ", valor_estimado=" + valor_estimado + ", funcionario="
			+ funcionario + "]";
		}
	}
	
	
	
	
	
}
