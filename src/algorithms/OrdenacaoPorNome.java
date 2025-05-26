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
	     String nomeA = a.getNome().toUpperCase();
	     String nomeB = b.getNome().toUpperCase();
	
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
     
     public static void shellSort(Projeto vetorProjetosEmAndamento[]) {
         int n = vetorProjetosEmAndamento.length;

         // Aplica o Shell Sort nos valores não nulos
         // Começa com um gap grande e o reduz gradualmente
         for (int gap = n / 2; gap > 0; gap = gap / 2) {
             // Realiza um insertion sort para cada gap
             for (int i = gap; i < n; i++) {
            	// Guarda arr[i] para ser inserido na posição correta
            	 Projeto tempProjeto = vetorProjetosEmAndamento[i];
            	 
                 int j;
                 for (j = i; j >= gap; j -= gap) {
                     Projeto prev = vetorProjetosEmAndamento[j - gap];

                     // Regras de comparação para tratar nulls:
                     // 1. Se prev for null e temp não for null: prev deve vir depois de temp, então desloca prev.
                     // 2. Se temp for null e prev não for null: temp deve vir depois de prev, então não desloca.
                     // 3. Se ambos forem null: são equivalentes, não desloca (ordem relativa mantida).
                     // 4. Se nenhum for null: compara os valores double normalmente.

                     if (tempProjeto != null && prev == null) {
                         // temp (null) é "menor" que prev (não-null), então prev deve vir depois.
                    	 vetorProjetosEmAndamento[j] = prev;
                     } else if (tempProjeto == null) {
                         // prev (null) é "menor" que temp (não-null), então prev já está no lugar.
                         // Não precisamos mover.
                         break;
                     } else if (prev.getValor_estimado() > tempProjeto.getValor_estimado()) {
                         // Ambos não são null. Se prev.value é maior que temp.value,
                         // prev deve vir depois. Desloca prev.
                    	 vetorProjetosEmAndamento[j] = prev;
                     } else {
                         // A posição correta foi encontrada (temp é "maior" ou igual a prev).
                         break;
                     }
                 }
                 // Coloca temp na sua posição correta
                 vetorProjetosEmAndamento[j] = tempProjeto;
             }
         }    
     }
         
}
