package algorithms;

import entities.Projeto;

public class OrdenacaoPorNome extends Projeto {

    public static void insertionSort(Projeto vetorProjeto[]) {
    	for (int i = 1; i < vetorProjeto.length; i++) {
            Projeto chave = vetorProjeto[i];
            int j = i - 1;

            while (j >= 0 && compararProjetos(vetorProjeto[j], chave) > 0) {
                vetorProjeto[j + 1] = vetorProjeto[j];
                j--;
            }
            vetorProjeto[j + 1] = chave;
        }
    }

	 // Comparação manual entre objetos Pessoa
     public static int compararProjetos(Projeto a, Projeto b) {
    	
	     // Trata objetos null
    	 if (a == null && b == null) return 0;
	     if (a == null) return 1;    // null considerado maior
	     if (b == null) return -1;
	
	     // Trata nomes null
	     String nomeA = a.getNome();
	     String nomeB = b.getNome();
	
	     if (nomeA == null && nomeB == null) return 0;
	     if (nomeA == null) return 1;
	     if (nomeB == null) return -1;
	        
	     // Comparação manual letra por letra
	     int minLength = nomeA.length() < nomeB.length() ? nomeA.length() : nomeB.length();

	     for (int i = 0; i < minLength; i++) {
	          char ca = nomeA.charAt(i);
	          char cb = nomeB.charAt(i);

	          if (ca < cb) return -1;
	          if (ca > cb) return 1;
	     }
	     
	     // Se todos os caracteres forem iguais até o comprimento mínimo
	     if (nomeA.length() < nomeB.length()) return -1;
	     if (nomeA.length() > nomeB.length()) return 1;

	     return 0; // Iguais
	    
	 	}

}
