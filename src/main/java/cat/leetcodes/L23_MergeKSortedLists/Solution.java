package cat.leetcodes.L23_MergeKSortedLists;

/**
 *
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = null;
        if (lists.length >= 2) {
            for (int i = 0; i < lists.length; i++) {
                head = mergeTwoLists(head, lists[i]);
            }
        }
        return head;
    }

    @Deprecated
    public ListNode mergeTwoLists(ListNode nodeA, ListNode nodeB) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val > nodeB.val) {
                temp.next = nodeB;
                nodeB = nodeB.next;
            } else {
                temp.next = nodeA;
                nodeA = nodeA.next;
            }
            temp = temp.next;
        }
        if (nodeA != null) {
            temp.next = nodeA;
        } else if (nodeB != null) {
            temp.next = nodeB;
        }
        return head.next;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}