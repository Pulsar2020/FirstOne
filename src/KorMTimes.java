/**
 * 输入一定能够保证，数组中所有的数都出现了M次，只有一种数出现了K次
 *    1 <= K < M
 * 返回这种数
 */
public class KorMTimes {

    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += (num >> i) & 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                if (t[i] % m == k) {
                    ans |= (1 << i);
                } else {
                    return -1;
                }
            }
        }
        // 刚好这种数是0
        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            // 这种数不是出现k次
            if (count != k) {
                return -1;
            }
        }
        return ans;
    }



}
