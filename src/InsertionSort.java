/**
 * Created by likz on 2022/12/20
 *
 * @author likz
 */
public class InsertionSort {
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int textTimes = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < textTimes; i++) {
            int[] arr1 = PartitionAndQucikSort.generateRandomArray(maxSize, maxValue);
            int[] arr2 = PartitionAndQucikSort.copyArray(arr1);
            PartitionAndQucikSort.quickSort3(arr1);
            insertSort(arr2);
            if (!PartitionAndQucikSort.isEqual(arr1, arr2) ) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "nice!" : "Oops!");
    }
}
