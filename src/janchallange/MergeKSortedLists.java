package janchallange;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = left + right >> 1;
        ListNode l0 = helper(lists, left, mid);
        ListNode l1 = helper(lists, mid + 1, right);
        return mergeKLists(l0, l1);
    }

    private ListNode mergeKLists(ListNode l0, ListNode l1) {
        ListNode node = new ListNode(0);
        ListNode tmp = node;

        while (l0 != null && l1 != null) {
            if(l0.val <= l1.val) {
                tmp.next = new ListNode(l0.val);
                l0 = l0.next;
            } else {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l0 != null ? l0 : l1;
        return node.next;
    }

    class ListNode {
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
}
