public class SelectionSort {
    public static void sort(int inicio, int fim, int[] array) {
        for(int i = inicio; i < fim - 1; i++) {
            int menorIndice = i;
            int menorElemento = array[i];

            for(int j = i + 1; j < fim; j++) {
                if(array[j] < menorElemento) {
                    menorIndice = j;
                    menorElemento = array[j];
                }

            }

            change(i, menorIndice, array);
            //System.out.println(Main.printArray(array));
            //System.out.println();
        }
    }

    public static void change(int x, int y, int[] array) {
        int aux = array[x];
        array[x] = array[y];
        array[y] = aux;
    }
}
