package niuke;

public class BM1_ReverseList {
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
         * @return ListNode类
         */
        public ListNode ReverseList(ListNode head) {
            // write code here
            if (head == null) {
                return null;
            }
            ListNode pre = null;
            ListNode cur = head;
            while(cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
