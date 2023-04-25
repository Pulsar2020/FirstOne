package great_class03;

/**
 * Created by likz on 2023/3/21
 * // 本题测试链接 : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author likz
 */
public class Code01_LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] str = s.toCharArray();
		int[] map = new int[256];
		for(int i = 0; i < 256; i++){
			map[i] = -1;
		}
		map[str[0]] = 0;
		int pre = 1;
		int ans = 1;
		for (int i = 1; i < str.length; i++){
			pre = Math.min(i - map[str[i]], pre + 1);
			ans = Math.max(ans, pre);
			map[str[i]] = i;
		}
		return ans;
	}

}
