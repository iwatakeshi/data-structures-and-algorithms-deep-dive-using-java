/**
 * CountingSort
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] array = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };
        
        print(array);
        sort(array, 1, 10);
        print(array);
    }

    private static void sort(int[] array, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                array[j++] = i;
                countArray[i - min]--;
            }
        }
    }


    private static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}