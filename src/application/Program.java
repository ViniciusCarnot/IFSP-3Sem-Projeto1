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
		
		int tamVetor = 15;
		int tamVetorProjeto = 15;
		
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

		
		Projeto proj[] = new Projeto[tamVetorProjeto];
		
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
				System.out.println("[MENU] ADICIONAR FUNCIONARIO");
				System.out.print("Numero funcional desejado[1-20], (passível a modificacao pelo sistema): ");
				Integer numeroFuncional = sc.nextInt();
				System.out.print("Nome: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Salario: ");
				Double salario = sc.nextDouble();
				Funcionario f = new Funcionario();
				f.inserir(numeroFuncional, name, salario, fun, tamVetor);
				System.out.println();
			}
			else if(opc == 2) {
				System.out.println();
				System.out.println("[MENU] ATUALIZAR FUNCIONARIO");
				System.out.print("Numero funcional do funcionário que será atualizado: ");
				Integer numeroFuncional = sc.nextInt();
				System.out.print("Novo nome: ");
				sc.nextLine();
				String novoNome = sc.nextLine();
				System.out.print("Novo salario: ");
				Double novoSalario = sc.nextDouble();
				Funcionario f = new Funcionario();
				f.atualizar(numeroFuncional, novoNome, novoSalario, fun, tamVetor);
				System.out.println();
			} 
			else if(opc == 3) {
				System.out.println();
				System.out.println("[MENU] DELETAR FUNCIONARIO");
				System.out.print("Numero funcional do funcionário que será deletado: ");
				Integer numeroFuncional = sc.nextInt();
				Funcionario f = new Funcionario();
				f.deletar(numeroFuncional, fun, tamVetor);
				//deixando null o funcionario pertencente ao projeto
				for(int i=0; i<tamVetorProjeto && proj[i] != null; i++) {
					if(proj[i].getFuncionario().getNumero_funcional() == numeroFuncional) {
						proj[i].setFuncionario(null);
						break;
					}
 				}
				System.out.println();
			}
			else if(opc == 4) {
				System.out.println();
				System.out.println("[MENU] ADICIONAR PROJETO");
				System.out.println("Deseja adicionar um projeto já finalizado[1] ou um projeto em andamento[2]?");
				System.out.print("Digite 1 ou 2: ");
				Integer opc2 = sc.nextInt();
				System.out.print("Nome do projeto: ");
				sc.nextLine();
				String nomeProjeto = sc.nextLine();
				System.out.print("Data de inicio (dd/MM/yyyy): ");
				String data1 = sc.next();
				System.out.print("Tempo estimado (meses):  ");
				Integer tempoEstimado = sc.nextInt();
				System.out.print("Valor estimado: ");
				Double valorEstimado = sc.nextDouble();
				System.out.print("Funcionario responsável (numero funcional [1-20]): ");
				Integer numeroFuncional = sc.nextInt();
				LocalDate dataInicio = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Projeto p = new Projeto();
				if(opc2 == 1) {
					System.out.print("Data de termino (dd/MM/yyyy): ");
					String data2 = sc.next();
					LocalDate dataTermino = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					p.inserirProjeto(nomeProjeto, dataInicio, dataTermino, tempoEstimado, valorEstimado, 
							numeroFuncional, fun, tamVetor, proj, tamVetorProjeto);
				}
				else if(opc2 == 2) {
					
					p.inserirProjeto(nomeProjeto, dataInicio, null, tempoEstimado, valorEstimado, 
							numeroFuncional, fun, tamVetor, proj, tamVetorProjeto);
				}
				else {
					System.out.println("Erro, valor digitado invalido!");
				}	
				System.out.println();
			} else if(opc == 5) {
				System.out.println();
				System.out.println("[MENU] ATUALIZAR PROJETO");
				System.out.print("Nome atual do projeto a ser atualizado: ");
				sc.nextLine();
				String nomeProjeto = sc.nextLine();
				System.out.println("Qual será a nova situacao do projeto, finalizado[1] ou um projeto em andamento[2]?");
				System.out.print("Digite 1 ou 2: ");
				Integer opc2 = sc.nextInt();
				System.out.print("Data de inicio (dd/MM/yyyy): ");
				String novaData1 = sc.next();
				System.out.print("Tempo estimado (meses):  ");
				Integer novoTempoEstimado = sc.nextInt();
				System.out.print("Valor estimado: ");
				Double novoValorEstimado = sc.nextDouble();
				System.out.print("Funcionario responsável (numero funcional [1-20]): ");
				Integer novoNumeroFuncional = sc.nextInt();
				LocalDate novaDataInicio = LocalDate.parse(novaData1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Projeto p = new Projeto();
				if(opc2 == 1) {
					System.out.print("Data de termino (dd/MM/yyyy): ");
					String novaData2 = sc.next();
					LocalDate novaDataTermino = LocalDate.parse(novaData2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					p.atualizarProjeto(nomeProjeto, novaDataInicio, novaDataTermino, novoTempoEstimado, novoValorEstimado, 
							novoNumeroFuncional, fun, tamVetor, proj, tamVetorProjeto);
				}
				else if(opc2 == 2) {
					p.atualizarProjeto(nomeProjeto, novaDataInicio, null, novoTempoEstimado, novoValorEstimado, 
							novoNumeroFuncional, fun, tamVetor, proj, tamVetorProjeto);
				}
				else {
					System.out.println("Erro, valor digitado invalido!");
				}
				System.out.println();
			} else if(opc == 6) {
				System.out.println();
				System.out.println("[MENU] DELETAR PROJETO");
				System.out.print("Nome do projeto a ser deletado: ");
				sc.nextLine();
				String nomeProjeto = sc.nextLine();
				Projeto p = new Projeto();
				p.deletarProjeto(nomeProjeto, proj, tamVetorProjeto);
				System.out.println();
			} else if(opc == 7) {
				System.out.println();
				System.out.println("LISTA DE FUNCIONARIOS...");
				for(int i=0; i<tamVetor && fun[i] != null; i++) {
					System.out.println(fun[i]);
				}
				System.out.println();
			} else if(opc == 8) {
				System.out.println();
				System.out.println("LISTA DE PROJETOS...");
				for(int i=0; i<tamVetorProjeto && proj[i] != null; i++) {
					System.out.println(proj[i]);
				}
			} else if(opc == 9) {
				System.out.println();
				System.out.println("LISTA DE FUNCIONARIOS COM SALARIOS MAIORES DE 10 MIL...");
				Funcionario f = new Funcionario();
				f.salarioMaiorDezMil(fun, tamVetor);
				System.out.println();
			}
		}
	
		
		
		
		
		sc.close();
	}
	
	public static void mostrarMenu() {
		System.out.println("#### MENU PRINCIPAL####");
		System.out.println("[1] Adicionar Funcionario");
		System.out.println("[2] Atualizar Dados do Funcionario");
		System.out.println("[3] Deletar Funcionario");
		System.out.println("[4] Adicionar Projeto");
		System.out.println("[5] Atualizar Dados do Projeto");
		System.out.println("[6] Deletar Projeto");
		System.out.println("[7] Imprimir Lista de Funcionarios");
		System.out.println("[8] Imprimir Lista de Projetos");
		System.out.println("[9] Imprimir Lista de Funcionarios com Salarios Maiores de 10 mil");
	}
	

}
