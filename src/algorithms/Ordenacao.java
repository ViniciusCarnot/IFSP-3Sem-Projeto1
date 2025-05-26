package algorithms;

import entities.Funcionario;

public class Ordenacao extends Funcionario {
	
	
	    public static void insertionSortFuncionario(Funcionario vetorFuncionario[]) {
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
	    
	    
	    public static void insertionSortFuncionarioSalarioDecrescente(Funcionario vetorFuncionario[]) {
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

	
}
