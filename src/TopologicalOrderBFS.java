import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by likz on 2023/3/3
 * OJ链接：https://www.lintcode.com/problem/topological-sorting
 *
 * @author likz
 */
public class TopologicalOrderBFS {
    // 不要提交这个类
    public static class DirectedGraphNode {
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<DirectedGraphNode, Integer> indrgeeMap = new HashMap<>();
        for (DirectedGraphNode cur : graph) {
            indrgeeMap.put(cur, 0);
        }
        for (DirectedGraphNode cur : graph) {
            for (DirectedGraphNode next : cur.neighbors) {
                indrgeeMap.put(next, indrgeeMap.get(next) + 1);
            }
        }
        LinkedList<DirectedGraphNode> zeroQueue = new LinkedList<>();
        for (DirectedGraphNode node : indrgeeMap.keySet()) {
            if (indrgeeMap.get(node) == 0) {
                zeroQueue.offer(node);
            }
        }
        ArrayList<DirectedGraphNode> resultList = new ArrayList<>();
        while (zeroQueue.size() != 0) {
            DirectedGraphNode cur = zeroQueue.poll();
            resultList.add(cur);
            for (DirectedGraphNode next : cur.neighbors) {
                indrgeeMap.put(next, indrgeeMap.get(next) - 1);
                if (indrgeeMap.get(next) == 0) {
                    zeroQueue.offer(next);
                }
            }
        }
        return resultList;
    }
}
