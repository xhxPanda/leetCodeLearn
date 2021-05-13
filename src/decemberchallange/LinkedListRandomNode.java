package decemberchallange;

import java.util.Random;

public class LinkedListRandomNode {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        head.next = head;
    }

    /** Returns a random node's value. */
    public int getRandom(ListNode currNode) {
        int res = currNode.val;
        ListNode pNode = currNode.next;
        Random random = new Random();
        for(int i=1; currNode.next!=null; i++) {
            currNode = currNode.next;
            if((random.nextInt(i + 1)) == i) {
                res = currNode.val;
            }
        }
        return res;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
