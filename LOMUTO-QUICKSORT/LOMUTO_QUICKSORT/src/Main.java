import java.util.Arrays;


public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        int[] array = {36, 27, 72, 81, 18, 75, 93, 63, 45, 14, 68, 89, 62, 15, 8, 40, 51, 59, 82, 87, 39, 74, 57, 92, 65, 67, 85, 1, 70, 31, 54, 20, 48, 77, 47, 78, 29, 80, 28, 4, 55, 3, 23, 22, 97, 43, 91, 99, 16, 34, 41};
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array = " + Arrays.toString(array));
    }

    static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                swap(array, i, j);
                i++;
            }
        }

        swap(array, i, right);
        return i;
    }

    static void swap(int[] array, int i, int j) {
        System.out.println("\tWe are changing: index = " + ANSI_GREEN + i + ANSI_RESET +
                " with value of = " + ANSI_RED + array[i] + ANSI_RESET +
                ", to: index = " + ANSI_GREEN + j + ANSI_RESET +
                " with value of = " + ANSI_RED + array[j] + ANSI_RESET);
        System.out.print("State of array = ");
        for (int number : array) {
            if (number == array[i] || number == array[j]) {
                System.out.print(ANSI_GREEN + number + ANSI_RESET + ", ");
            } else {
                System.out.print(number + ", ");
            }
        }
        System.out.println("\n");

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

