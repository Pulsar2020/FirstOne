import java.util.LinkedList;

/**
 * Created by likz on 2023/4/28
 *
 * @author likz
 */
public class GasStation {
// 测试连接：   https://leetcode.cn/problems/gas-station/description/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        boolean[] okStartIndex = getOkStartIndex(gas, cost);
        for (int i = 0; i < okStartIndex.length; i++) {
            if (okStartIndex[i]) {
                return i;
            }
        }
        return -1;
    }

    // 找出所有符合要求的位置
    private boolean[] getOkStartIndex(int[] gas, int[] cost) {
        int N = gas.length;
        boolean[] ans = new boolean[N];
        int M = N * 2;
        int[] arr = new int[M];
        for(int i = 0; i < N; i++){
            arr[i] = gas[i] - cost[i];
            arr[i + N] = gas[i] - cost[i];
        }
        for(int i = 1; i < M; i++){
            arr[i] += arr[i - 1];
        }
        LinkedList<Integer> w = new LinkedList<>();
        for(int R = 0; R < N; R++){
            while(!w.isEmpty() && arr[w.peekLast()] >= arr[R]){
                w.pollLast();
            }
            w.addLast(R);
        }
        for (int offset = 0, i = 0, j = N; j < M; offset = arr[i++], j++) {
            if (arr[w.peekFirst()] - offset >= 0) {
                ans[i] = true;
            }
            if (w.peekFirst() == i) {
                w.pollFirst();
            }
            while (!w.isEmpty() && arr[w.peekLast()] >= arr[j]) {
                w.pollLast();
            }
            w.addLast(j);
        }
        return ans;
    }
}
