import java.util.Arrays;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        arr = createArray();

        System.out.println(Arrays.toString(QuickSort.sort(arr.clone())));
        System.out.println(Arrays.toString(CountingSort.sort(arr.clone())));
        System.out.println(Arrays.toString(HeapSort.sort(arr.clone())));
    }

    public static int[] createArray(){
        int[] arr = new int[10000];
        int j = 0;
        for (int i = 10000; i>0; i--){
            arr[j] = i;
            j++;
        }
        return arr;
    }

}

