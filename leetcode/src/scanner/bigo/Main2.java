package scanner.bigo;

import java.util.Scanner;

public class Main2<T> {

    public void bubbleSort(T[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 1; j < arrays.length - i; j++) {
                String v1 = String.valueOf(arrays[j - 1]);
                String v2 = String.valueOf(arrays[j]);
                if (v1.compareTo(v2) < 0){
                    swap(arrays, j - 1, j);
                }
            }
        }
        for (T array : arrays) {
            System.out.println(array);
        }
    }

    private void swap(T[] arrays, int i, int j){
        T t = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = t;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

    }
}
