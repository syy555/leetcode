package cat.leetcodes;


import cat.leetcodes.L19_RemoveNthNodeFromEndOfList.Solution;

import static org.junit.Assert.assertEquals;

public class Solution1Test {

    @org.junit.Test
    public void test() {
        assertEquals(new Solution().removeNthFromEnd(new Solution.ListNode(1),1),null);

    }
}