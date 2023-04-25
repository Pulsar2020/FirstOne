package great_class29;

/**
 * Created by likz on 2023/4/25
 *
 * @author likz
 */
public class Problem_0062_UniquePaths {
    public int uniquePaths(int m, int n) {
        /* 排列组合C
            ___ n - 1
           /
          |
           \___ m + n - 2
        */
        int right = n - 1;
        int all = m + n - 2;
        long o1 = 1;
        long o2 = 1;
        for(int i = right + 1, j = 1; i <= all; i++, j++){
            o1 *= i;
            o2 *= j;
            long gcd = gcd(o1, o2);
            o1 /= gcd;
            o2 /= gcd;
        }

        return (int) o1;
    }

    public long gcd(long m, long n){
        return n == 0 ? m : gcd(n, m % n);
    }

}
