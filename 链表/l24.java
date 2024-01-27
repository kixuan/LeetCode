package 链表;

/**
 * @author kixuan
 * @version 1.0
 */
public class l24 {

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

    public ListNode swapPairs(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;

        // 初始化前一个节点和当前节点
        ListNode prev = null;
        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode next = current.next; // 下一个要交换的节点
            ListNode nextPair = next.next; // 下一对要交换的节点的开始

            // 交换节点
            if (prev != null)
                prev.next = next;
            next.next = current;
            current.next = nextPair;

            // 移动到下一对节点
            prev = current;
            current = nextPair;
        }
        return newHead;
    }

    public static void main(String[] args) {
        l24 l24 = new l24();
        ListNode head = l24.new ListNode();
        head.val = 1;
        head.next = l24.new ListNode();
        head.next.val = 2;
        head.next.next = l24.new ListNode();
        head.next.next.val = 3;
        head.next.next.next = l24.new ListNode();
        head.next.next.next.val = 4;
        ListNode result = l24.swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
