package niuke;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by likz on 2023/7/7
 *
 * @author likz
 */
public class StringSimplify {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        UnionFind unionFindSet = new UnionFind(255);
        String inputString = br.readLine();

        boolean enterBracket = false;
        char[] str = inputString.toCharArray();
        StringBuilder targetStr = new StringBuilder();
        List<Character> sameSetStr = new ArrayList<>();
        List<List<Character>> list = new ArrayList<>();
        // 输入数据转换处理
        for (char ch : str) {
            if (enterBracket) {
                if (ch == ')') {
                    enterBracket = false;
                    // 若括号内有数据
                    if (!sameSetStr.isEmpty()) {
                        List<Character> element = new ArrayList<>(sameSetStr);
                        list.add(element);
                        sameSetStr.clear();
                    }
                } else {
                    sameSetStr.add(ch);
                }
            } else {
                if (ch == '(') {
                    enterBracket = true;
                } else {
                    targetStr.append(ch);
                }
            }
        }
        // 若并查集为空
        if (list.isEmpty()) {
            out.println(targetStr);
            out.flush();
            return;
        }

        // 构建并查集
        for (List<Character> characterList : list) {
            if (characterList.size() > 1) {
                for (int i = 1; i < characterList.size(); i++){
                    unionFindSet.union(characterList.get(0), characterList.get(i));
                }
            }
        }

        // 输出
        if (targetStr.length() > 0) {
            char[] chs = targetStr.toString().toCharArray();
            for (char ch : chs) {
                out.print((char) (unionFindSet.unionFind(ch)));
            }
            out.println();
            out.flush();
        } else {
            out.println("0");
            out.flush();
        }

    }


    public static class UnionFind {
        private int[] parent;
        private int[] help;

        public UnionFind(int n) {
            parent = new int[n];
            help = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int unionFind(int i) {
            int size = 0;
            while (parent[i] != i) {
                help[size++] = i;
                i = parent[i];
            }
            while (size > 0) {
                parent[help[--size]] = i;
            }
            return i;
        }

        public void union(int x, int y) {
            int fx = unionFind(x);
            int fy = unionFind(y);
            if (fx != fy) {
                if (fx < fy) {
                    parent[fy] = fx;
                } else {
                    parent[fx] = fy;
                }
            }
        }


    }

    /*
    示例一：
    输入：()abd
    输出：abd
    说明：输入字符串里没有被小括号包含的子字符串为"abd"，其中每个字符没有等效字符，输出为"abd"

    示例二：
    输入：(abd)demand(fb)()for
    输出：aemanaaor
    说明:等效字符集为('a','b','d','f')，输入字符串里没有被小括号包含的子字符串集合为"demandfor"，将其中字符替换为字典序最小的等效字符后输出为:"aemanaaor

    示例3
    输入: ()happy(xyz)new(wxy)year(t)
    输出: happwnewwear
    说明: 等效字符集为('x','y','z','w')，输入字符串里没有被小括号包含的子字符串集合为"happynewyear”，将其中字符替换为字典序最小的等效字符后输出
    为:"happwnewwear

    示例四：
    输入:()abcdefgAC(a)(Ab)(C)
    输出:AAcdefgAC
    说明:等效字符集为('a','A','b')，输入字符串里没有被小括号包含的子字符串集合为“abcdefgAC，将其中字符替换为字典序最小的等效字符后输出为:"AAcdefgAC"

    * */
}
