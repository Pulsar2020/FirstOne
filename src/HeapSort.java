import java.util.Arrays;

/**
 * Created by likz on 2023/3/10
 *
 * @author likz
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return ;
        }
        for (int i = arr.length - 1; i >= 0; i--){
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while(heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while(left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index){
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateArray(int rangeData, int maxLength) {
        int[] res = new int[(int) (Math.random() * (maxLength + 1))];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * rangeData - Math.random() * rangeData);
        }
        return res;
    }

    public static int[] arrayCopy(int[] arr) {
        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, res.length);
        return res;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int range = 100;
        int max = 100;
        boolean flag = false;
        long t1 = 0;
        long t2 = 0;
        point:
        for (int k = 0; k < testTime; k++) {
            int[] array = generateArray(range, max);
            int[] array2 = arrayCopy(array);
            long l1 = System.currentTimeMillis();
            Arrays.sort(array);
            long l2 = System.currentTimeMillis();
            heapSort(array2);
            long l3 = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                if (array[i] != array2[i]) {
                    flag = true;
                    break point;
                }
            }
            t1 += l2 - l1;
            t2 += l3 - l2;
        }
        System.out.println("total, Array sort :" + t1 + " heap sort:" + t2);
        System.out.println(flag ? "Oops!" : "Nice!");
    }
}
