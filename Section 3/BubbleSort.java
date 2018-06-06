/**
 * BubbleSort
 * Time complexity: O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = { 20, 35, -15, 7, 55, 1, -22 };
        print(array);
        sort(array);
        print(array);

    }

    public static void sort(int[] array) {
        int last = array.length - 1;
        
        while (last != 0) {
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            last--;
        }
    }

    private static void swap(int[] array, int a, int b) {
        if (a == b) return;

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}