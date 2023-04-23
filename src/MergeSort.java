/**
 * Created by likz on 2022/12/8
 *
 * @author likz
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length == 0 || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right){
        if (left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        while(p1 <= mid && p2 <= right){
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[index++] = arr[p1++];
        }
        while(p2 <= right){
            help[index++] = arr[p2++];
        }
        for(int i = 0; i < help.length; i++){
            arr[left + i] = help[i];
        }
    }


    public static void main(String[] args) {
        int textTimes = 10;
        int maxSize = 1000000;
        int maxValue = 10000;
        boolean success = true;
        for (int i = 0; i < textTimes; i++) {
            int[] arr1 = PartitionAndQucikSort.generateRandomArray(maxSize, maxValue);
            int[] arr2 = PartitionAndQucikSort.copyArray(arr1);
            PartitionAndQucikSort.quickSort3(arr1);
            mergeSort(arr2);
            if (!PartitionAndQucikSort.isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "nice!" : "Oops!");
    }
}
