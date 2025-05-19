package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;
import entities.Projeto;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int tamVetor = 11;
		
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

		
		Projeto proj[] = new Projeto[10];
		
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
		
		
		proj[0] = new Projeto ("Amazon", dataInicio0Amazon, dataTermino0Amazon, 5, 550000.0, fun[5]);
		proj[1] = new Projeto ("Apple", dataInicio1Apple, dataTermino1Apple, 2, 400000.0, fun[8]);
		proj[2] = new Projeto ("Broadcom", dataInicio2Broadcom, null, 3, 1000000.0, fun[0]);
		proj[3] = new Projeto ("Google", dataInicio3Google, dataTermino3Google, 5, 600000.0, fun[6]);
		proj[4] = new Projeto ("Meta", dataInicio4Meta, dataTermino4Meta, 2, 200000.0, fun[9]);
		proj[5] = new Projeto ("Microsoft", dataInicio5Microsoft, dataTermino5Microsoft, 1, 600000.0, fun[9]);
		proj[6] = new Projeto ("Nvidia", dataInicio6Nvidia, dataTermino6Nvidia, 6, 700000.0, fun[7]);
		proj[7] = new Projeto ("TSMC", dataInicio7TSMC, null, 6, 150000.0, fun[2]);
		proj[8] = new Projeto ("Tencent", dataInicio8Tencent, null, 3, 750000.0, fun[3]);
		proj[9] = new Projeto ("Tesla", dataInicio9Tesla, dataTermino9Tesla, 2, 800000.0, fun[5]);
		
		
		int opc = 0;
		while(opc != 50) {
			mostrarMenu();
			opc = sc.nextInt();
			
			if(opc == 1) {
				System.out.println();
				System.out.print("Numero funcional (passível a modificacao pelo sistema): ");
				Integer numeroFuncional = sc.nextInt();
				System.out.print("Nome do novo funcionario: ");
				String name = sc.next();
				System.out.print("Salario do novo funcionario: ");
				Double salario = sc.nextDouble();
				Funcionario f = new Funcionario();
				f.inserir(numeroFuncional, name, salario, fun, tamVetor);
				System.out.println();
			}
			
		}
	
		
		
		
		
		sc.close();
	}
	
	public static void mostrarMenu() {
		System.out.println("#### MENU ####");
		System.out.println("[1] Adicionar Funcionario");
		System.out.println("[2] Atualizar Dados do Funcionario");
		System.out.println("[3] Deletar Funcionario");
		System.out.println("[4] Adicionar Projeto");
		System.out.println("[5] Atualizar Dados do Projeto");
		System.out.println("[6] Deletar Projeto");
	}
	
	public static void mostrarSubMenuInserir() {
		
	}

}
