/**
 * InsertionSort
 * Time complexity: O(n^2)
 */
public class InsertionSort {
    
    public static void main(String[] args) {
        int[] array = { 20, 35, -15, 7, 55, 1, -22 };
        print(array);
        sort(array);
        print(array);

    }

    public static void sort(int[] array) {
        int last = array.length;
        
        // The first element is at 1 because
        // it is assumed that the first element is sorted
        for (int first = 1; first < last; first++) {
            // The element to be inserted
            int element = array[first];
            int i = first;

            while (i > 0 && array[i - 1] > element) {
                shift(array, i, i - 1);
                i--;
            }
            
            array[i] = element;
        }
    }

    private static void shift(int[] array, int a, int b) {
        array[a] = array[b];
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