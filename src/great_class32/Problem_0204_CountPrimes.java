package great_class32;

/**
 * Create By LKUNZ on 2023/6/13
 */
public class Problem_0204_CountPrimes {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int count = n / 2;
        boolean[] noPrimeFlag = new boolean[n];
        for (int i = 3; i * i < n; i += 2) {
            if (noPrimeFlag[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) {
                if (!noPrimeFlag[j]) {
                    count--;
                    noPrimeFlag[j] = true;
                }
            }
        }
        return count;
    }
}
