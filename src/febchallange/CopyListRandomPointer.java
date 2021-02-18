package febchallange;

public class CopyListRandomPointer {

    private Node copyRandomList(Node head) {
        if (head == null) return null;
        Node head2, p2, p = head;
        while (p != null) {
            Node n = new Node(p.val);
            n.next = p.next;
            p.next = n;
            p = n.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
               p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        head2 = head.next;
        p = head;
        while (p != null) {
            p2 = p.next;
            p.next = p2.next;
            if (p2.next != null) {
                p2.next = p2.next.next;
            }
            p = p.next;
        }
        return head2;
    }

   private class Node {
        int val;
        Node next;
        Node random;

    public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
