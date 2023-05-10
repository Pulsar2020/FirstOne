package great_class30;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likz on 2023/5/9
 *
 * @author likz
 */
public class Problem_0118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        int row = 1;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        while (++row <= numRows) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            List<Integer> preRow = res.get(row - 2);
            for (int i = 1; i < row - 1; i++) {
                curRow.add(i, preRow.get(i - 1) + preRow.get(i));
            }
            curRow.add(1);
            res.add(curRow);
        }
        return res;
    }
}
