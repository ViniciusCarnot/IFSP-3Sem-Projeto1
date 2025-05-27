package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import algorithms.OrdenacaoProjeto;
import entities.Funcionario;
import entities.Projeto;

public class ProgramaTeste {

	public static void main(String[] args) {
		
		/*Pessoa pessoas[] = {
	            new Pessoa("Carlos"),
	            new Pessoa(null),
	            new Pessoa("Ana"),
	            new Pessoa("beatriz"),
	            new Pessoa("Daniel"),
	            null,
	            new Pessoa("alberto")
	        };

	        System.out.println("Antes da ordenação:");
	        for (Pessoa p : pessoas) {
	            System.out.print(p + " ");
	        }
	        
	        Pessoa p = new Pessoa();
	        
	        p.insertionSort(pessoas);

	        System.out.println("\n\nDepois da ordenação (por nome):");
	        for (Pessoa t : pessoas) {
	            System.out.print(t + " ");
	        }
	    }*/
		
		int tamVetor = 11;
		int tamVetorProjeto = 10;
		
		Funcionario fun[] = new Funcionario[tamVetor];
		fun[0] = new Funcionario (1, "alex silva", 5000.0);
		fun[1] = new Funcionario (2, "carlos santos", 3000.0);
		fun[2] = new Funcionario (3, "maria pena", 12000.0);
		fun[3] = new Funcionario (4, "valentina pereira", 10000.0);
		fun[4] = new Funcionario (5, "adriana martins", 14000.0);
		fun[5] = new Funcionario (6, "jose almeida", 8000.0);
		fun[6] = new Funcionario (7, "pedro costa", 20000.0);
		fun[7] = new Funcionario (8, "davi ruiz", 3500.0);
		fun[8] = new Funcionario (9, "luiza alvarez", 9500.0);
		fun[9] = new Funcionario (10, "henrique mioto", 15000.0);

		LocalDate dataInicio0Amazon = LocalDate.parse("07/02/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataTermino0Amazon = LocalDate.parse("07/08/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio1Apple = LocalDate.parse("15/05/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataTermino1Apple = LocalDate.parse("15/07/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio2Broadcom = LocalDate.parse("26/05/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio3Google = LocalDate.parse("04/01/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataTermino3Google = LocalDate.parse("04/06/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio4Meta = LocalDate.parse("22/02/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataTermino4Meta = LocalDate.parse("22/04/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio5Microsoft = LocalDate.parse("13/04/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataTermino5Microsoft = LocalDate.parse("13/07/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio6Nvidia = LocalDate.parse("13/01/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataTermino6Nvidia = LocalDate.parse("13/07/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio7TSMC = LocalDate.parse("11/02/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio8Tencent = LocalDate.parse("29/04/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataInicio9Tesla = LocalDate.parse("24/03/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataTermino9Tesla = LocalDate.parse("24/05/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Projeto projetos[] = {
			new Projeto ("Tencent", dataInicio8Tencent, null, 3, 750000.0, fun[3]),
			new Projeto ("Broadcom", dataInicio2Broadcom, null, 3, 1000000.0, fun[0]),
			null,
			new Projeto ("Meta", dataInicio4Meta, dataTermino4Meta, 2, 200000.0, fun[9]),
			new Projeto ("Amazon", dataInicio0Amazon, dataTermino0Amazon, 5, 550000.0, fun[5]),
			new Projeto ("Microsoft", dataInicio5Microsoft, dataTermino5Microsoft, 1, 600000.0, fun[9]),
			null,
			new Projeto ("TSMC", dataInicio7TSMC, null, 6, 150000.0, fun[2]),
			new Projeto ("Tesla", dataInicio9Tesla, dataTermino9Tesla, 2, 800000.0, fun[5]),
			new Projeto ("Apple", dataInicio1Apple, dataTermino1Apple, 2, 400000.0, fun[8]),
		};
		
		OrdenacaoProjeto.insertionSort(projetos);
		
		for(Projeto p: projetos) {
			System.out.println(p);
		}
		
	}
}
