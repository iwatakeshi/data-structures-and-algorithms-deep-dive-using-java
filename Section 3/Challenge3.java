/**
 * Challenge3: Use radix sort to sort "bcdef", "dbaqc", "abcde", "omadd", "bbbbb"
 */
public class Challenge3 {

    public static void main(String[] args) {
        String[] array = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };
        // String[] array = { "aefs", "djrt", "hfgf", "etyu", "fhgs" };


        sort(array, 26, 5);
        
        print(array);
    }

    public static void sort(String[] array, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            singleSort(array, radix, i);
        }
    }
    
    private static void singleSort(String[] array, int radix, int position) {
        int numItems = array.length;
        int[] countArray = new int[radix];

        for (String value : array) {
            countArray[getCharIndex(value, radix, position)]++;
        }

        print(countArray);

        // Adjust the count array
        for (int i = 1; i < radix; i++) {
            countArray[i] += countArray[i - 1];
        }

        String[] temp = new String[numItems];
        for (int i = numItems - 1; i >= 0; i--) {
            temp[--countArray[getCharIndex(array[i], radix, position)]] = array[i];
        }

        for (int i = 0; i < numItems; i++) {
            array[i] = temp[i];
        }
    }

    private static int getCharIndex(String value, int radix, int position) {
        return value.charAt(position) - 'a';
        // return ((int)(value.charAt(position)) / (int) Math.pow(26, position)) % radix;
    }


    private static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void print(String[] array) {
        for (String item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}