/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = { 20, 35, -15, 7, 55, 1, -22 };
        print(array);
        sort(array);
        print(array);
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length);
    }

    private static void sort(int[] array, int start, int end) {
        if ((end - start) < 2) return;

        int pivot = partition(array, start, end);
        sort(array, start, pivot);
        sort(array, pivot + 1, end);
    }

    private static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;

        // Prevent i and j from crossing each other.
        while (i < j) {
            
            // NOTE: Emtpy loop
            while (i < j && array[--j] >= pivot);
            if (i < j) array[i] = array[j];

            // NOTE: Empty loop
            while (i < j && array[++i] <= pivot);
            if (i < j) array[j] = array[i];

        }
        
        array[j] = pivot;

        return j;

    }
}