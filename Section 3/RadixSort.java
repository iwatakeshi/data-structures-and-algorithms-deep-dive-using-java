/**
 * RadixSort
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = { 4725, 4585, 1330, 8792, 1594, 5729 };

        sort(array, 10, 4);
        
        print(array);
    }

    public static void sort(int[] array, int radix, int width) {
        for (int i = 0; i < width; i++) {
            singleSort(array, radix, i);
        }
    }
    
    private static void singleSort(int[] array, int radix, int position) {
        int numItems = array.length;
        int[] countArray = new int[radix];

        for (int value : array) {
            countArray[getDigit(value, radix, position)]++;
        }


        // Adjust the count array
        for (int i = 1; i < radix; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] temp = new int[numItems];
        for (int i = numItems - 1; i >= 0; i--) {
            temp[--countArray[getDigit(array[i], radix, position)]] = array[i];
        }

        for (int i = 0; i < numItems; i++) {
            array[i] = temp[i];
        }
    }

    private static int getDigit(int value, int radix, int position) {
        return (value / (int) Math.pow(10, position)) % radix;
    }

    private static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}