package great_class30;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likz on 2023/5/9
 *
 * @author likz
 */
public class Problem_0119_PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int row = 1;
        res.add(1);
        while (++row <= rowIndex + 1) {
            int pre = res.get(0);
            for (int i = 1; i < row - 1; i++) {
                int cur = res.get(i);
                res.set(i, pre + cur);
                pre = cur;
            }
            res.add(row - 1, 1);
        }
        return res;
    }
}
