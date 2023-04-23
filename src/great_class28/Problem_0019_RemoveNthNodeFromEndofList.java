package great_class28;

/**
 * Created by likz on 2023/4/21
 *
 * @author likz
 */
public class Problem_0019_RemoveNthNodeFromEndofList {

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

    int cur = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        cur++;
        if(n == cur){
            return head.next;
        }
        return head;
    }
}
