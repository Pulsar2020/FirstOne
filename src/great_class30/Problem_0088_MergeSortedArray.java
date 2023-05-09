package great_class30;


public class Problem_0088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = 0;
        int y = 0;
        int[] help = new int[m + n];
        int index = 0;
        while(x < m && y < n){
            help[index++] = nums1[x] <= nums2[y] ? nums1[x++] : nums2[y++];
        }
        while(x < m){
            help[index++] = nums1[x++];
        }
        while(y < n){
            help[index++] = nums2[y++];
        }
        System.arraycopy(help, 0, nums1, 0, m + n);
    }
}
