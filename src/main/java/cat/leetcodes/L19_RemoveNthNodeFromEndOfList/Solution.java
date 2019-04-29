package cat.leetcodes.L19_RemoveNthNodeFromEndOfList;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        List<ListNode> list = new ArrayList<>();
        ListNode current = dummy;
        int length = 0;
        list.add(current);
        for (int i = 1; current.next != null; i++) {
            current = current.next;
            list.add(current);
            if (current.next == null) {
                length = i;
            }
        }
        ListNode target = list.get(length - n);
        target.next = target.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}


