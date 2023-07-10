package niuke;

import java.io.*;
import java.util.*;

/**
 * 高矮排序
 *
 * @author likz
 */
public class HighShort {
/*    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] strArr = line.split(" ");
            List<Integer> numList = new ArrayList<>();
            for (String str : strArr) {
                try {
                    numList.add(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    System.out.println("[]");
                    return;
                }
            }
            mySort(numList);
            for (Integer i : numList) {
                System.out.print(i + " ");
            }
        }
    }*/


    public static void main(String[] args) {
/*        int[] test1a = new int[]{4, 3, 5, 7, 8};
        int[] test2a = new int[]{4, 1, 3, 5, 2};
        int[] test3a = new int[]{1, 1, 1, 1, 1};
        List<Integer> test1 = new ArrayList<>();
        for (int temp : test1a){
            test1.add(temp);
        }
        List<Integer> test2 = new ArrayList<>();
        for (int temp : test2a) {
            test2.add(temp);
        }
        List<Integer> test3 = new ArrayList<>();
        for (int temp : test3a) {
            test3.add(temp);
        }

        mySort(test1);
        mySort2(test1a);
        mySort(test2);
        mySort2(test2a);
        mySort(test3);
        mySort2(test3a);
        System.out.println(equals(test1a, test1));
        System.out.println(equals(test2a, test2));
        System.out.println(equals(test3a, test3));*/
        System.out.println("Test begin!");
        int testTime = 50000;
        int size = 99;
        for (int i = 0; i < testTime; i++) {
            int[] nums = generateRondomArray(size);
            List<Integer> numList = getNumList(nums);
            mySort(numList);
            mySort2(nums);
            if (!equals(nums, numList)) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("Test finish!");
    }

    private static List<Integer> getNumList(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    private static int[] generateRondomArray(int size) {
        // Math.rondom() [0, 1)
        int random = (int) (Math.random() * (size - 1)) + 1;
        int[] arr = new int[random];
        for (int i = 0; i < random; i++) {
            arr[i] = (int) (Math.random() * 30 + 1);
        }
        return arr;
    }

    public static boolean equals(int[] a, List<Integer> b) {
        if (a.length != b.size()) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void mySort(List<Integer> nums) {
        if (nums.size() == 1) {
            return;
        }
        if (nums.size() == 2) {
            if (nums.get(0) < nums.get(1)) {
                swap(nums, 0, 1);
            }
            return;
        }
        int size = nums.size();
        boolean gtLt = true;
        for (int i = 0; i < size - 1; i++) {
            if (gtLt) {
                if (nums.get(i) < nums.get(i + 1)) {
                    swap(nums, i, i + 1);
                }
                gtLt = false;
            } else {
                if (nums.get(i) > nums.get(i + 1)) {
                    swap(nums, i, i + 1);
                }
                gtLt = true;
            }
        }
    }

    public static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // my sort for testing
    public static void mySort2(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (flag == 0) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                    }
                    flag = 1;
                } else {
                    if (nums[i] > nums[j]) {
                        swap(nums, i, j);
                    }
                    flag = 0;
                }
                break;
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[] nums;
//        try {
//            nums = Arrays.stream(in.nextLine().split(" "))
//                    .map(Integer::parseInt).mapToInt(i -> i).toArray();
//        } catch (Exception e) {
//            System.out.println("[]");
//            return;
//        }
//        mySort2(nums);
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
//    }
}
