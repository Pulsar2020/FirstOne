package code;

/**
 * Create By LKUNZ on 2023/6/7
 */
public class FindPeakElement {
    public int findPeakElement(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        }
        if (arr[0] > arr[1]) {
            return arr[0];
        }
        if (arr[len - 2] < arr[len - 1]){
            return arr[len - 1];
        }
        int left = 1;
        int right = len - 2;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 2);
            if (arr[mid] < arr[mid - 1]) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid + 1]){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
