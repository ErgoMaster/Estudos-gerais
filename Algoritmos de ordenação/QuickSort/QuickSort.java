package QuickSort;

public class QuickSort {
    public static void sort(int inicio, int fim, int[] array) {
        if(inicio < fim) {
            int pivot = partition(inicio, fim, array);

            sort(inicio, pivot - 1, array);
            sort(pivot + 1, fim, array);
        }
    }

    private static int partition(int inicio, int fim, int[] array) {
        int pivot = array[fim];
        int i = inicio - 1;

        for(int j = inicio; j <= fim - 1; j++) {
            if(array[j] < pivot) {
                i++;
                change(j, i, array);
            }
        }

        change(i + 1, fim, array);
        return i + 1;
    }

    public static void change(int x, int y, int[] array) {
        int aux = array[x];
        array[x] = array[y];
        array[y] = aux;
    }
}
