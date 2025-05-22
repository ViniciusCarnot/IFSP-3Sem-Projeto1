package teste;

public class Pessoa {
	
        private String nome;
        
        public Pessoa() {
        }

        public Pessoa(String nome) {
            this.nome = nome;
        }

        public String getNome() {
			return nome;
		}

		@Override
        public String toString() {
            return nome == null ? "null" : nome;
        }

        public void insertionSort(Pessoa[] vetor) {
        	int n = vetor.length;

        	for (int i = 1; i < n; i++) {
        		Pessoa chave = vetor[i];
        		int j = i - 1;

        		while (j >= 0 && compare(vetor[j], chave) > 0) {
        			vetor[j + 1] = vetor[j];
        			j--;
        		}

        		vetor[j + 1] = chave;
        	}
        }

        // Método para comparar nomes (trata nulls como maiores)
        public static int compare(Pessoa a, Pessoa b) {
	        if (a == null && b == null) return 0;
	        if (a == null) return 1; // null vai para o final
	        if (b == null) return -1;
	
	        if (a.nome == null && b.nome == null) return 0;
	        if (a.nome == null) return 1;
	        if (b.nome == null) return -1;
	
	        return a.nome.compareToIgnoreCase(b.nome); // Ignora maiúsculas/minúsculas
        }
	
}
