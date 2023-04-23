/**
 * Created by likz on 2023/1/30
 *
 * @author likz
 */
public class AppleMinBag {

    public static int minBags(int apple) {
        int bag = apple / 8;
        int rest = apple - bag * 8;
        if (rest == 0) {
            return bag;
        } else {
            while (bag >= 0) {
                if (rest % 6 == 0) {
                    bag += rest / 6;
                    return bag;
                } else {
                    bag--;
                    rest += 8;
                }
            }
        }
        return -1;
    }

    public static int improvementMinBags(int apple) {
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return apple % 2 == 0 ? (apple - 18) / 8 + 3 : -1;
    }

    public static void main(String[] args) {
//        for (int apple = 1; apple < 200; apple++) {
//            System.out.println(apple + " : " + minBags(apple));
//        }
        System.out.println("test begin");
        for (int apple = 1; apple < 200; apple++) {
            if (minBags(apple) != improvementMinBags(apple)) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("test end");
    }
}
