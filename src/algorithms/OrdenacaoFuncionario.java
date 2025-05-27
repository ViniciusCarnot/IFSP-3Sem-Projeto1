package algorithms;

import entities.Funcionario;

public class OrdenacaoFuncionario extends Funcionario {
	
	
	    public static void insertionSort(Funcionario vetorFuncionario[]) {
	        int n = vetorFuncionario.length;

	        for (int i = 1; i < n; i++) {
	            Funcionario chave = vetorFuncionario[i];
	            int j = i - 1;

	            while (j >= 0 && compare(vetorFuncionario[j], chave) > 0) {
	                vetorFuncionario[j + 1] = vetorFuncionario[j];
	                j--;
	            }

	            vetorFuncionario[j + 1] = chave;
	        }
	    }
	    
	    

	    // Método auxiliar para comparar dois objetos Funcionario, lidando com nulls
	    public static int compare(Funcionario a, Funcionario b) {
	        if (a == null && b == null) return 0;
	        if (a == null) return 1;     // null vai para o final
	        if (b == null) return -1;

	        // Agora ambos não são null
	        if (a.getNumero_funcional() == null && b.getNumero_funcional() == null) return 0;
	        if (a.getNumero_funcional() == null) return 1;
	        if (b.getNumero_funcional() == null) return -1;

	        // Ambos não são null, comparar normalmente
	        if (a.getNumero_funcional() < b.getNumero_funcional()) return -1;
	        if (a.getNumero_funcional() > b.getNumero_funcional()) return 1;
	        return 0;
	    }
	    
//------------------------------------------------------------------------------------------------------------------------------------------------------	    
	    public static void insertionSortSalarioDecrescente(Funcionario vetorFuncionario[]) {
	        int n = vetorFuncionario.length;

	        for (int i = 1; i < n; i++) {
	            Funcionario chave = vetorFuncionario[i];
	            int j = i - 1;

	            // A condição de comparação foi invertida para ordenar em ordem decrescente.
	            // Agora, vetorFuncionario[j] é "menor" que a chave se o salário for MAIOR,
	            // fazendo com que seja movido para a direita.
	            while (j >= 0 && compareSalarioDecrescente(vetorFuncionario[j], chave) < 0) {
	                vetorFuncionario[j + 1] = vetorFuncionario[j];
	                j--;
	            }

	            vetorFuncionario[j + 1] = chave;
	        }
	    }

	    public static int compareSalarioDecrescente(Funcionario a, Funcionario b) {
	        // Regras para nulls de Funcionario (nulls sempre vão para o final)
	        if (a == null && b == null) return 0;
	        if (a == null) return 1;     // 'a' é null, vai para o final (depois de 'b')
	        if (b == null) return -1;    // 'b' é null, 'a' vem antes de 'b'

	        // Agora ambos Funcionario não são null. Comparar seus salários.

	        // Regras para nulls de salário (salários nulls também vão para o final)
	        if (a.getSalary() == null && b.getSalary() == null) return 0;
	        if (a.getSalary() == null) return 1;    // 'a.salario' é null, vai para o final
	        if (b.getSalary() == null) return -1;   // 'b.salario' é null, 'a.salario' vem antes

	        // Ambos os salários não são null, comparar normalmente, mas invertido para decrescente
	        // Se a.salario for MAIOR que b.salario, 'a' vem antes de 'b' (retorna -1)
	        if (a.getSalary() > b.getSalary()) return -1;
	        // Se a.salario for MENOR que b.salario, 'a' vem depois de 'b' (retorna 1)
	        if (a.getSalary() < b.getSalary()) return 1;

	        return 0; // Salários são iguais
	    }
	    
//------------------------------------------------------------------------------------------------------------------------------------------------------	    
	    public static Integer buscaBinariaNumeroFuncional(Funcionario vetorFuncionario[], Integer numeroFuncional) {
			
			if (vetorFuncionario == null || vetorFuncionario.length == 0) {
	            return -1; // Array nulo ou vazio, não há nada para pesquisar
	        }

	        // 1. Encontrar o verdadeiro 'alto' índice (último elemento não-nulo)
	        int fim = vetorFuncionario.length - 1;
	        while (fim >= 0 && vetorFuncionario[fim] == null) {
	            fim--;
	        }

	        // Se todos os elementos forem nulos, ou o array for efetivamente vazio após remover nulos
	        if (fim < 0) {
	            return -1;
	        }
		
			int inicio = 0; // O índice inicial do segmento de busca

	        // Continua a busca enquanto o índice de início não ultrapassar o índice de fim
	        while (inicio <= fim) {
	            // Calcula o índice do meio.
	            // Uso de (inicio + fim) / 2 pode causar overflow se inicio e fim forem muito grandes.
	            // Uma forma mais segura é: inicio + (fim - inicio) / 2
	            int meio = inicio + (fim - inicio) / 2;
	            
	            if(vetorFuncionario[meio] == null) {
	            	fim = meio -1;
	            	continue;
	            }

	            // Caso 1: O elemento no meio é igual à chave
	            if (vetorFuncionario[meio].getNumero_funcional() == numeroFuncional) {
	                return meio; // Chave encontrada, retorna seu índice
	            }
	            // Caso 2: O elemento no meio é menor que a chave
	            // Isso significa que a chave (se existir) deve estar na metade superior
	            else if (vetorFuncionario[meio].getNumero_funcional() < numeroFuncional) {
	                inicio = meio + 1; // Ajusta o início para buscar na metade superior
	            }
	            // Caso 3: O elemento no meio é maior que a chave
	            // Isso significa que a chave (se existir) deve estar na metade inferior
	            else { // arr[meio] > chave
	                fim = meio - 1; // Ajusta o fim para buscar na metade inferior
	            }
	        }

	        // Se o loop terminar, significa que a chave não foi encontrada no array
	        return -1;
			
			
		}
	    
//------------------------------------------------------------------------------------------------------------------------------------------------------	    
	    
	    
}
