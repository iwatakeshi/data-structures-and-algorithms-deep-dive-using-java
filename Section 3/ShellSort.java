/**
 * ShellSort
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = { 20, 35, -15, 7, 55, 1, -22 };
        print(array);
        sort(array);
        print(array);
    }

    public static void sort(int[] array) {
        // Shell sort: reduce the gaps within the array
        for (int interval = array.length / 2; interval > 0; interval /= 2) {
            for (int first = interval; first < array.length; first++) {
                // Insertion sort: sort the array by selecting an element
                int element = array[first];
                int i = first;

                while (i >= interval && array[i - interval] > element) {
                    shift(array, i, i - interval);
                    i -= interval;
                }

                array[i] = element;
            }
        }
    }

    private static void shift(int[] array, int a, int b) {
        array[a] = array[b];
    }

    private static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}