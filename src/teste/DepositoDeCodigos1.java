package teste;

public class DepositoDeCodigos1 {
	
	//### TESTE 1 INSERTION SORT PARA FUNCIONARIOS###

    public static class Item {
        Integer valor;

        public Item(Integer valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return valor == null ? "null" : valor.toString();
        }
    }

    public static void insertionSort(Item[] vetor) {
        int n = vetor.length;

        for (int i = 1; i < n; i++) {
            Item chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && compare(vetor[j], chave) > 0) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = chave;
        }
    }

    // Método auxiliar para comparar dois objetos Item, lidando com nulls
    public static int compare(Item a, Item b) {
        if (a == null && b == null) return 0;
        if (a == null) return 1;     // null vai para o final
        if (b == null) return -1;

        // Agora ambos não são null
        if (a.valor == null && b.valor == null) return 0;
        if (a.valor == null) return 1;
        if (b.valor == null) return -1;

        // Ambos não são null, comparar normalmente
        if (a.valor < b.valor) return -1;
        if (a.valor > b.valor) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Item[] vetor = {
            new Item(5),
            null,
            new Item(2),
            new Item(null),
            new Item(1),
            null,
            new Item(3)
        };

        System.out.println("Vetor original:");
        for (Item item : vetor) {
            System.out.println(item + " ");
        }

        insertionSort(vetor);

        System.out.println("\nVetor ordenado (null objetos e valores no final):");
        for (Item item : vetor) {
            System.out.println(item + " ");
        }
    }
    
    
 

    
    
}
