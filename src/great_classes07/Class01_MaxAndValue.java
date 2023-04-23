package great_classes07;

/**
 * Created by likz on 2023/4/14
 * 给定一个正数组成的数组，长度一定大于1，求数组中哪两个数与的结果最大
 *
 * @author likz
 */
public class Class01_MaxAndValue {

    /**
     * 暴力方法 O(n^2) 时间复杂度
     * @param arr 入参
     * @return ans
     */
    public static int maxAndValue(int[] arr){
        int ans = arr[0] & arr[1];
        for(int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                ans = Math.max(ans, arr[i] & arr[j]);
            }
        }
        return ans;
    }

    private static int maxAndValue2(int[] arr) {
        int M = arr.length;
        int ans = 0;
        for (int bit = 30; bit >= 0; bit--){
            int i = 0;
            int temp = M;
            // arr[0...M-1]
            while(i < M){
                if (((arr[i] >> bit) & 1) == 0){
                    swap(arr, i, --M);
                } else {
                    i++;
                }
            }
            // arr[0] & arr[1]
            if (M == 2){
                return arr[0] & arr[1];
            }
            if (M < 2){
                M = temp;
            } else {
                ans |= (1 << bit);
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRomdomArray(int size, int maxValue){
        int[] res = new int[size];
        for (int i = 0; i < size; i++){
            res[i] = (int) (Math.random() * (maxValue + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int maxSize = 50;
        int maxValue = 100;
        int times = 100000;
        int[] arr;
        System.out.println("test begin!");
        for (int i = 0; i < times; i++){
            int size = 2 + (int)(Math.random() * maxSize);
            arr = generateRomdomArray(size, maxValue);
            if (maxAndValue(arr) != maxAndValue2(arr) ){
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("test finish!");
    }

}
