import java.util.HashMap;
import java.util.Map;

/**
 * Created by likz on 2023/3/1
 *
 * @author likz
 */
public class StickersToSpellWord {

    public static int minStickers1(String[] stickers, String target) {
        int ans = process1(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process1(String[] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String str : stickers) {
            String rest = minus(target, str);
            if (rest.length() != target.length()) {
                min = Math.min(min, process1(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String minus(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] count = new int[26];
        for (char c : str1) {
            count[c - 'a']++;
        }
        for (char c : str2) {
            count[c - 'a']--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                stringBuilder.append((char) (i + 'a'));
                count[i]--;
            }
        }
        return stringBuilder.toString();
    }

    public static int minStickers2(String[] stickers, String target) {
        int length = stickers.length;
        int[][] counts = new int[length][26];
        for (int i = 0; i < length; i++) {
            char[] stickerStr = stickers[i].toCharArray();
            for (char cha : stickerStr) {
                counts[i][cha - 'a']++;
            }
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        int ans = process2(counts, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process2(int[][] stickers, String t, Map<String, Integer> dp ) {
        if(dp.containsKey(t)){
            return dp.get(t);
        }
        if (t.length() == 0) {
            return 0;
        }
        char[] target = t.toCharArray();
        int[] tCount = new int[26];
        for (char cha : target) {
            tCount[cha - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] sticker : stickers) {
            if (sticker[target[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    int nums = tCount[j] - sticker[j];
                    if (nums > 0) {
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) ('a' + j));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, process2(stickers, rest, dp));
            }
        }
        int res = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(t, res);
        return res;
    }

}
