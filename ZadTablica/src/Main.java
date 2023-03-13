import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Mikolaj!");
        checkingTimeOfSortingOrderedArray(2000);
        checkingTimeOfSortingUnorderedArray(2000);
        checkingTimeOfSortingOrderedArray(4000);
        checkingTimeOfSortingUnorderedArray(4000);
        checkingTimeOfSortingOrderedArray(8000);
        checkingTimeOfSortingUnorderedArray(8000);
        checkingTimeOfSortingOrderedArray(16000);
        checkingTimeOfSortingUnorderedArray(16000);
        checkingTimeOfSortingOrderedArray(32000);
        checkingTimeOfSortingUnorderedArray(32000);
    }

    private static void checkingTimeOfSortingOrderedArray(int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(i);
        }
        runMethodAndTakeTime(arr, size, "Ordered");
    }

    private static void checkingTimeOfSortingUnorderedArray(int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = size - 1; i >= 0; i--) {
            arr.add(i);
        }
        runMethodAndTakeTime(arr, size, "Unordered");
    }

    static void sort(Object[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = (int)arr[i];
            int j = i - 1;

            while (j >= 0 && (int)arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    private static void runMethodAndTakeTime(ArrayList<Integer> arr, int size, String ordered){
        long startTime = System.nanoTime();
        sort(arr.toArray());
        long stopTime = System.nanoTime();
        long workTimeOfFunction = stopTime - startTime;
        float ratio = 0;
        if (Objects.equals(ordered, "Ordered")){
            ratio = (float) size/workTimeOfFunction;
        }else if (Objects.equals(ordered, "Unordered")){
            ratio = (float) (pow(size, 2)/workTimeOfFunction);
        }
        System.out.println("\nSize of array was " + size + " and it was: " + ordered + ". \n" + "It took me: " + workTimeOfFunction + " nanoseconds." + "The ratio was: " + ratio);
    }
}