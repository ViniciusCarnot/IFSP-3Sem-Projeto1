package application;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import algorithms.OrdenacaoFuncionario;
import entities.Funcionario;


public class ProgramaTeste1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/*Funcionario fun[] = {
				new Funcionario (8, "davi ruiz", 3500.0),
				new Funcionario (1, "alex silva", 5000.0),
				new Funcionario (5, "adriana martins", 14000.0),
				new Funcionario (3, "maria pena", 12000.0),
				null,
				new Funcionario (10, "henrique mioto", 15000.0),
				new Funcionario (6, "jose almeida", 8000.0),
				new Funcionario (7, "pedro costa", 20000.0),
				null,
				new Funcionario (2, "carlos santos", 3000.0),
		};
		
	
		
		
		
		System.out.println("Vetor original:");
        for (Funcionario f : fun) {
            System.out.println(f + " ");
        }

        Ordenacao.insertionSortFuncionario(fun);

        System.out.println("\nVetor ordenado por 'valor':");
        for (Funcionario f : fun) {
            System.out.println(f + " ");
        }*/
		
		// Exemplo 1: Array com elementos
		Funcionario fun[] = new Funcionario[10];
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
        Integer chave1 = 7;
        Integer chave2 = 4;
        Integer chave3 = 80; // Não está no array
        Integer chave4 = 1; // Primeiro elemento
        Integer chave5 = 10; // Último elemento
        
        Funcionario f = new Funcionario();

        

        // Teste para chave1 (23)
        int resultado1 = f.buscaBinaria(fun, chave1);
        if (resultado1 != -1) {
            System.out.println("Chave " + chave1 + " encontrada no índice: " + resultado1); // Esperado: 6
        } else {
            System.out.println("Chave " + chave1 + " não encontrada.");
        }

        // Teste para chave2 (12)
        int resultado2 = f.buscaBinaria(fun, chave2);
        if (resultado2 != -1) {
            System.out.println("Chave " + chave2 + " encontrada no índice: " + resultado2); // Esperado: 3
        } else {
            System.out.println("Chave " + chave2 + " não encontrada.");
        }

        // Teste para chave3 (10)
        int resultado3 = f.buscaBinaria(fun, chave3);
        if (resultado3 != -1) {
            System.out.println("Chave " + chave3 + " encontrada no índice: " + resultado3);
        } else {
            System.out.println("Chave " + chave3 + " não encontrada."); // Esperado: não encontrada
        }

        // Teste para chave4 (2) - primeiro elemento
        int resultado4 = f.buscaBinaria(fun, chave4);
        if (resultado4 != -1) {
            System.out.println("Chave " + chave4 + " encontrada no índice: " + resultado4); // Esperado: 0
        } else {
            System.out.println("Chave " + chave4 + " não encontrada.");
        }

        // Teste para chave5 (91) - último elemento
        int resultado5 = f.buscaBinaria(fun, chave5);
        if (resultado5 != -1) {
            System.out.println("Chave " + chave5 + " encontrada no índice: " + resultado5); // Esperado: 9
        } else {
            System.out.println("Chave " + chave5 + " não encontrada.");
        }
    
		
		
		
		
		sc.close();
	}

}
