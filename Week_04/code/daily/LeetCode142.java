package daily;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 2020/05/17
 */
public class LeetCode142 {
    @Test
    public void test1() {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (visited.contains(curr)) return curr;
            visited.add(curr);
            curr = curr.next;
        }

        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
