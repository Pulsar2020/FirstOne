package code;

/**
 * Created by likz on 2023/4/26
 *
 * @author likz
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int less = -1;
        int more = nums.length;
        int index = 0;
        while(index < more){
            if (nums[index] == 1){
                index++;
            } else if (nums[index] < 1){
                swap(nums, ++less, index++);
            } else {
                swap(nums, --more, index);
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
