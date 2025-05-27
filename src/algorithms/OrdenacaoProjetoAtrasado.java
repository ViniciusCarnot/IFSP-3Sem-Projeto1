package algorithms;

import entities.ProjetoAtrasado;

public class OrdenacaoProjetoAtrasado {
	
	public static void insertionSortTempoDeAtraso(ProjetoAtrasado vetorProjetosAtrasados[]) {
	        int n = vetorProjetosAtrasados.length;

	        for (int i = 1; i < n; i++) {
	            ProjetoAtrasado chave = vetorProjetosAtrasados[i];
	            int j = i - 1;

	            while (j >= 0 && compare(vetorProjetosAtrasados[j], chave) > 0) {
	            	vetorProjetosAtrasados[j + 1] = vetorProjetosAtrasados[j];
	                j--;
	            }

	            vetorProjetosAtrasados[j + 1] = chave;
	        }
	}
	    
	// Método auxiliar para comparar dois objetos Funcionario, lidando com nulls
	public static int compare(ProjetoAtrasado a, ProjetoAtrasado b) {
	        if (a == null && b == null) return 0;
	        if (a == null) return 1;     // null vai para o final
	        if (b == null) return -1;

	        // Agora ambos não são null
	        if (a.getTempoAtraso() == null && b.getTempoAtraso() == null) return 0;
	        if (a.getTempoAtraso() == null) return 1;
	        if (b.getTempoAtraso() == null) return -1;

	        // Ambos não são null, comparar normalmente
	        if (a.getTempoAtraso() < b.getTempoAtraso()) return -1;
	        if (a.getTempoAtraso() > b.getTempoAtraso()) return 1;
	        return 0;
	}
	
}
