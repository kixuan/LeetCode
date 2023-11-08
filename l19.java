/**
 * @author kixuan
 * @version 1.0
 */
public class l19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        ListNode fast = tmp, slow = tmp.next;
        // n有可能会大于链表长度
        for (int i = 0; i <= n && fast.next != null; i++)
            fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }

    public static void main(String[] args) {
        l19 l19 = new l19();
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode();
        head.next.val = 2;
        head.next.next = new ListNode();
        head.next.next.val = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.val = 4;
        head.next.next.next.next = new ListNode();
        head.next.next.next.next.val = 5;
        ListNode result = l19.removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
