package great_class31;

public class Problem_0172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n != 0){
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
