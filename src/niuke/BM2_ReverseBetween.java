package niuke;

public class BM2_ReverseBetween {
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
         * @param head ListNode类
         * @param m    int整型
         * @param n    int整型
         * @return ListNode类
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            // write code here
            ListNode res = new ListNode(-1);
            res.next = head;
            ListNode cur = head;
            ListNode pre = res;
            int index = m;
            while(--index > 0) {
                pre = cur;
                cur = cur.next;
            }
            // -1 ->  head -> ...
            // res     cur

            for (int i = m ; i < n; i++){
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            return res.next;
        }
    }
}
