package application;

import java.util.Locale;
import java.util.Scanner;

import algorithms.Ordenacao;
import entities.Funcionario;


public class ProgramaTeste1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Funcionario fun[] = {
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
        }
		
		
		
		
		sc.close();
	}

}
