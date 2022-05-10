package InsertionSort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = generateArray(10);

        System.out.println(printArray(array));
        InsertionSort.sort(0, array.length, array);
        System.out.println("\n" + printArray(array));
    }

    private static int[] generateArray(int tamanho) {
        Random rand = new Random();
        int[] resultado = new int[tamanho];

        for(int i = 0; i < tamanho; i++) {
            int number = rand.nextInt(25);
            resultado[i] = number;
        }

        return resultado;
    }
    
    private static String printArray(int[] array) {
        String resultado = "[";

        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) { resultado += array[i]; }
            else { resultado += array[i] + ", "; }
        }

        resultado += "]";
        return resultado;
    }
}
