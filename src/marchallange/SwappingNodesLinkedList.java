package marchallange;

public class SwappingNodesLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;

        ListNode firstNode = null;
        ListNode secondNode = null;

        while (curr != null) {
            if (k == length++) {
                firstNode = curr;
                curr = curr.next;
            }
        }

        curr = head;
        int index = 0;
        while (curr != null) {
            if ((length - k + 1) == index++) {
                secondNode = curr;
            }
            curr = curr.next;
        }

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return head;
    }
}
