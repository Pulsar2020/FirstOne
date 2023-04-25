package great_class29;

/**
 * Created by likz on 2023/4/24
 *
 * @author likz
 */
public class Problem_0050_PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (x == 1.0){
            return 1.0;
        }
        int pow = Math.abs(n == 0x80000000 ? n + 1 : n);
        double ans = 1;
        double t = x;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                ans *= t;
            }
            pow >>= 1;
            t *= t;
        }
        if (n == 0x80000000) {
            ans *= x;
        }
        return n < 0 ? 1.0 / ans : ans;
    }
}
