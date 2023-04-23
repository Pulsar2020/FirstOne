import java.util.PriorityQueue;

/**
 * Created by likz on 2022/12/9
 *
 * @author likz
 */
public class MinKth {

    // 利用大根堆，时间复杂度O(N*logK)
    public static int minKth1(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }

    public static int minKth2(int[] array, int k) {
        int[] arr1 = copyArray(array);
        return process(arr1, 0, arr1.length - 1, k - 1);
    }

    public static int process(int[] arr, int L, int R, int index) {
        if (L == R) {
            return arr[L];
        }
        int pivot =  arr[L + (int)(Math.random() * (R - L + 1))];
        int[] equalArea = partition(arr, L, R, pivot);
        if (index >= equalArea[0] && index <= equalArea[1]) {
            return arr[index];
        } else if (index < equalArea[0]){
            return process(arr, L, equalArea[0] - 1, index);
        } else {
            return process(arr, equalArea[1] + 1, R, index);
        }
    }

    private static int[] partition(int[] arr, int l, int r, int pivot) {
        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while(cur < more){
            if (arr[cur] < pivot){
                swap(arr, ++less, cur++);
            } else if (arr[cur] > pivot){
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i != ans.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int k = (int) (Math.random() * arr.length) + 1;
            int ans1 = minKth1(arr, k);
            int ans2 = minKth2(arr, k);
//            int ans3 = minKth3(arr, k);
            if (ans1 != ans2 /*|| ans2 != ans3*/) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
