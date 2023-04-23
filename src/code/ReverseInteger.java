package code;

/**
 * Created by likz on 2023/4/18
 *
 * @author likz
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean flag = x < 0 ? false : true;
        x = x < 0 ? x : -x;
        int res = 0;
        int minr = Integer.MIN_VALUE / 10;
        int minq = Integer.MIN_VALUE % 10;
        while(x != 0){
            int cur = x % 10;
            if (res < minr || res == minr && cur < minq){
                return 0;
            }
            res = res * 10 + cur;
            x /= 10;
        }
        return flag ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
