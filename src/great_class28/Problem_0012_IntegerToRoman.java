package great_class28;

/**
 * Created by likz on 2023/4/18
 *
 * @author likz
 */
public class Problem_0012_IntegerToRoman {
    public String intToRoman(int num) {
        String[][] roman = new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        StringBuilder res = new StringBuilder();
        res.append(roman[3][num / 1000 % 10])
                .append(roman[2][num / 100 % 10])
                .append(roman[1][num / 10 % 10])
                .append(roman[0][num % 10]);
        return res.toString();
    }
    /*罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*/
}
