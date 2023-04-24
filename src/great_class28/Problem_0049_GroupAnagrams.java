package great_class28;

import java.util.*;

/**
 * Created by likz on 2023/4/23
 *
 * @author likz
 */
public class Problem_0049_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> strMap = new HashMap<>();
        for(String element : strs){
            char[] str = element.toCharArray();
            insertionSort(str);
            String key = String.valueOf(str);
            if (strMap.containsKey(key)){
                strMap.get(key).add(element);
            } else {
                List<String> listStr = new ArrayList<>();
                listStr.add(element);
                strMap.put(key, listStr);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : strMap.keySet()){
            ans.add(strMap.get(key));
        }
        return ans;
    }

    public static void insertionSort(char[] str){
        if(str.length <= 1){
            return;
        }
        for (int i = 1; i < str.length; i++){
            for (int j = i - 1; j >= 0 && str[j] > str[j + 1]; j--){
                swap(str, j + 1, j);
            }
        }
    }

    public static void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

}
