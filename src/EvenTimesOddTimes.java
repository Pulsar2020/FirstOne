/**
 * Create By LKUNZ on 2023/1/23
 */
public class EvenTimesOddTimes {

    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }
        System.out.println(ans);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightestOne = extractRightestOne(eor);

        // eor'
        int one = 0;
        for (int i = 0; i < arr.length; i++){
            if ((rightestOne & arr[i]) != 0) {
                one ^= arr[i];
            }
        }

        int another = eor ^ one;
        System.out.println(one + " " + another);

    }

    // 提取出最右侧的一
    public static int extractRightestOne(int num) {
        return num & (~num + 1);
    }

    public static void main(String[] args) {
//        int a = 5;
//        int b = 7;
//
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//
//        System.out.println(a);
//        System.out.println(b);

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);

    }
}
