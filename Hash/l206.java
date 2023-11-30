package Hash;

/**
 * @author kixuan
 * @version 1.0
 */
public class l206 {
    static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        for (int i = 0; ; i++) {
            cur.next.next = cur;
            if (cur.next.next == null)
                break;
        }
        head.next = null;
        return cur.next;
    }

    public static void main(String[] args) {
        l206 l206 = new l206();
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
        ListNode result = l206.reverseList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
