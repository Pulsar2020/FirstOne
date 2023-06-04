package great_class31;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By LKUNZ on 2023/6/3
 */
public class Problem_0140_WordBreakII {

    public static class Node {
        public String path;
        public boolean end;
        public Node[] next;

        public Node() {
            path = null;
            end = false;
            next = new Node[26];
        }

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Node root = getTrie(wordDict);
        boolean[] dp = getDp(s, root);
        List<String> path = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        dfs(str, 0, root, dp, path, ans);
        return ans;
    }

    private static void dfs(char[] str, int index, Node root, boolean[] dp, List<String> path, List<String> ans) {
        if (index == str.length) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++){
                builder.append(path.get(i)).append(" ");
            }
            builder.append(path.get(path.size() - 1));
            ans.add(builder.toString());
        } else {
            Node cur = root;
            for (int end = index; end < str.length; end++) {
                int road = str[end] - 'a';
                if (cur.next[road] == null) {
                    break;
                }
                cur = cur.next[road];
                if (cur.end && dp[end + 1]){
                    path.add(cur.path);
                    dfs(str, end + 1, root, dp, path, ans);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static Node getTrie(List<String> wordDict) {
        Node root = new Node();
        for (String str : wordDict) {
            char[] word = str.toCharArray();
            Node node = root;
            int index;
            for (char wordChar : word) {
                index = wordChar - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new Node();
                }
                node = node.next[index];
            }
            node.path = str;
            node.end = true;
        }
        return root;
    }

    public static boolean[] getDp(String s, Node root) {
        int N = s.length();
        char[] str = s.toCharArray();
        boolean[] dp = new boolean[N + 1];
        dp[N] = true;
        for (int i = N - 1; i >= 0; i--){
            Node cur = root;
            for (int end = i; end < N; end++){
                int index = str[end] - 'a';
                if (cur.next[index] == null){
                    break;
                }
                cur = cur.next[index];
                if (cur.end && dp[end + 1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp;
    }
}
