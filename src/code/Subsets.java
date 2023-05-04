package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likz on 2023/5/4
 *
 * @author likz
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        process(nums, 0, result, path);
        return result;
    }

    private void process(int[] nums, int index, List<List<Integer>> result, List<Integer> path) {
        if (index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        process(nums, index + 1, result, path);
        path.add(nums[index]);
        process(nums, index + 1, result, path);
        path.remove(path.size() - 1);
    }
}
