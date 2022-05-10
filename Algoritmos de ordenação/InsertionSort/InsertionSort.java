package InsertionSort;

public class InsertionSort {
    public static void sort(int inicio, int fim, int[] array) {
        for(int i = inicio; i < fim; i++) {
            int j = i;

            while(j > 0 && array[j] < array[j - 1]) {
                change(j, j - 1, array);
                System.out.println(Main.printArray(array));
                j--;
            }

            System.out.println();
        }
    }

    public static void change(int x, int y, int[] array) {
        int aux = array[x];
        array[x] = array[y];
        array[y] = aux;
    }
}
