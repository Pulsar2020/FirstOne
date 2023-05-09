package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by likz on 2023/5/4
 *
 * @author likz
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        process(nums, 0, result, path);
        return new ArrayList<>(result);
    }

    private void process(int[] nums, int index, Set<List<Integer>> result, List<Integer> path) {
        if (index == nums.length){
            ArrayList<Integer> sortList = new ArrayList<>(path);
            sortList.sort((o1, o2) -> o1 - o2);
            result.add(sortList);
            return;
        }
        process(nums, index + 1, result, path);
        path.add(nums[index]);
        process(nums, index + 1, result, path);
        path.remove(path.size() - 1);
    }


}
