package great_class31;

import java.util.List;

public class Problem_0139_WordBreak {
    public static class Node {
        public boolean end;
        public Node[] nexts;

        public Node() {
            end = false;
            nexts = new Node[26];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        for (String word : wordDict) {
            char[] wordChars = word.toCharArray();
            Node node = root;
            int index;
            for (char wordChar : wordChars) {
                index = wordChar - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                node = node.nexts[index];
            }
            node.end = true;
        }
        int N = s.length();
        char[] str = s.toCharArray();
        boolean[] dp = new boolean[N + 1];
        dp[N] = true;
        for (int i = N - 1; i >= 0; i--) {
            Node cur = root;
            for (int end = i; end < N; end++) {
                cur = cur.nexts[str[end] - 'a'];
                if (cur == null) {
                    break;
                }
                if (cur.end) {
                    dp[i] |= dp[end + 1];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
