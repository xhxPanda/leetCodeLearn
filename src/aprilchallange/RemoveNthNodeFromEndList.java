package aprilchallange;

public class RemoveNthNodeFromEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sta = new ListNode(0);
        ListNode slow = sta;
        ListNode fast = sta;

        sta.next = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return sta.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(100/99);
    }
}
