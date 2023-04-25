package great_class29;

/**
 * Created by likz on 2023/4/25
 *
 * @author likz
 */
public class Problem_0069_SqrtX {
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (x <= 5) {
            return x / 2;
        }
        long ans = 0;
        long L = 0;
        long R = x;
        long M;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            if (M * M <= x) {
                ans = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return (int) ans;
    }



    public int mySqrt2(int x) {
        int s = x;
        if (x == 0) {
            return 0;
        }
        return ((int) (sqrts(x, s)));
    }

    public double sqrts(double x, int s) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res, s);
        }
    }

}
