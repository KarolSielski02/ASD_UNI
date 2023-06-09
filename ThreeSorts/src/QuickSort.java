public class QuickSort {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static int[] sort(int[] arrayToSort) {
        long start = System.nanoTime();

        if (arrayToSort == null || arrayToSort.length == 0) {
            return null;
        }
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime + " NanoSecs, for QuickSort");
        return arrayToSort;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotValue = array[right];
        int border = left - 1;
        int i = left;

        while (i < right) {
            if (array[i] < pivotValue) {
                border++;
                if (border != i) {
                    swap(array, border, i);
                }
            }
            i++;
        }

        border++;
        if (border != right) {
            swap(array, border, right);
        }
        quickSort(array, left, border - 1);
        quickSort(array, border + 1, right);
    }
}
