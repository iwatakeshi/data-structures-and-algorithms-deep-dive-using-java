import javax.swing.plaf.InputMapUIResource;

/**
 * MergeSort
 * Time complexity: O(nlogn)
 */
public class MergeSort {

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
        if ((end - start) < 2) {
            return;
        }

        int mid = (start + end) / 2;

        sort(array, start, mid);
        sort(array, mid, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        // Check whether the left partiton's last element
        // is less than the right partiton's first element.
        // If so, then the entire left partions is less than the right.
        if (array[mid - 1] <= array[mid]) {
            return;
        }

        // Since there is a number in the left partion that is greater
        // than the right, we will need to sort them into the correct position.
        int i = start;
        int j = mid;
        // 'k' keeps track of the current index
        int k = 0;

        // Temporary array
        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[k++] = (array[i] <= array[j]) ? array[i++] : array[j++]; 
        }

        System.arraycopy(array, i, array, start + k, mid - i);
        System.arraycopy(temp, 0, array, start, k);

    }
    
    private static void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}