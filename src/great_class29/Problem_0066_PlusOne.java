package great_class29;

/**
 * Created by likz on 2023/4/25
 *
 * @author likz
 */
public class Problem_0066_PlusOne {
    public int[] plusOne(int[] digits) {
        boolean all9 = true;
        for (int digit : digits) {
            if (digit != 9) {
                all9 = false;
                break;
            }
        }
        int length = digits.length;
        if (all9) {
            int[] res = new int[++length];
            res[0] = 1;
            return res;
        } else {
            int plus = 1;
            for (int i = length - 1; i >= 0; i--){
                if (plus != 0){
                    digits[i] += 1;
                    plus = 0;
                    if (digits[i] == 10){
                        digits[i] = 0;
                        plus = 1;
                    }
                } else {
                    break;
                }
            }
        }
        return digits;
    }

}
