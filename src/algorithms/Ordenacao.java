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

	
}
