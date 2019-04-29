package cat.leetcodes.L21_MergeTwoSortedLists;

public class Solution {
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