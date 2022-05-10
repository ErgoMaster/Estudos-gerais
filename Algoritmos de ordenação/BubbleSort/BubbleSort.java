package BubbleSort;

public class BubbleSort {
    public static void sort(int inicio, int fim, int[] array) {
        for(int i = inicio; i < fim; i++) {
            for(int j = fim - 1; j > i; j--) {
                if(array[j] < array[j -1]) {
                    change(j, j - 1, array);
                    System.out.println(Main.printArray(array));
                } 
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