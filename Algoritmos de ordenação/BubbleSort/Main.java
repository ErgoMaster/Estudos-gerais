package BubbleSort;
public class Main {
    public static void main(String[] args) {
        int[] array = { 10, 5, 13, 2, 9, 8, 7, 4 };

        System.out.println(printArray(array));
        BubbleSort.sort(0, 8, array);
        System.out.println("\n" + printArray(array));
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
