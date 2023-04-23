package code;

/**
 * Created by likz on 2023/4/17
 * https://leetcode.cn/problems/add-two-numbers/
 * @author likz
 */
public class AddTwoNumbersOfLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode x = l1;
        ListNode y = l2;
        ListNode res = null;
        int plus = 0;
        ListNode cur = null;
        while (x != null && y != null) {
            int tmpVal = (x.val + y.val + plus) % 10;
            plus = (x.val + y.val + plus) / 10;
            if (res == null) {
                res = new ListNode(tmpVal);
                cur = res;
            } else {
                res.next = new ListNode(tmpVal);
                res = res.next;
            }
            x = x.next;
            y = y.next;
        }
        while (x != null) {
            int tmpVal = (x.val + plus) % 10;
            plus = (x.val + plus) / 10;
            res.next = new ListNode(tmpVal);
            res = res.next;
            x = x.next;
        }
        while (y != null) {
            int tmpVal = (y.val + plus) % 10;
            plus = (y.val + plus) / 10;
            res.next = new ListNode(tmpVal);
            res = res.next;
            y = y.next;
        }
        if (plus == 1) {
            res.next = new ListNode(plus);
        }

        return cur;
    }
}
