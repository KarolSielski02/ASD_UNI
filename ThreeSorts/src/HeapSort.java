
// Java program for implementation of Heap Sort

public class HeapSort {
    public static int[] sort(int arr[]) {
        long start = System.nanoTime();
        int size = arr.length;

        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(arr, size, i);

        for (int i = size - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime + " NanoSecs, for HeapSort");
        return arr;
    }

    static void heapify(int arr[], int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }
}

