package niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BM5_MergeKList {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param lists ListNode类ArrayList
         * @return ListNode类
         */
        public ListNode mergeKLists(ArrayList<ListNode> lists) {
            // write code here
            if (lists == null) {
                return null;
            }
            PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) != null) {
                    heap.add(lists.get(i));
                }
            }
            if (heap.isEmpty()) {
                return null;
            }
            ListNode head = heap.poll();
            ListNode pre = head;
            if (pre.next != null) {
                heap.add(pre.next);
            }
            while (!heap.isEmpty()) {
                ListNode cur = heap.poll();
                pre.next = cur;
                pre = cur;
                if (cur.next != null) {
                    heap.add(cur.next);
                }
            }
            return head;
        }

        public class ListNodeComparator implements Comparator<ListNode> {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }

        }
    }
}
