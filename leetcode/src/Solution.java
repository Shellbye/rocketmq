import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 把其中一个构造成环
        ListNode b = headB;
        while (b.next != null) {
            b = b.next;
        }
        b.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;
        boolean hasCycle = false;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            b.next = null;
            return null;
        }
        ListNode entrance = headA;
        while (entrance != slow) {
            entrance = entrance.next;
            slow = slow.next;
        }
        b.next = null;
        return entrance;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{7,1,5,3,6,4};//7    122. 买卖股票的最佳时机 II
        int[] a = new int[]{1, 7, 3, 1, 3, 7, 6, 5, 5, 2, 2};
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode l11 = new ListNode(1);
        ListNode l22 = new ListNode(2);
        ListNode l33 = new ListNode(3);
        l11.next = l22;
        l22.next = l33;
        l33.next = l4;
        System.out.println(new Solution().getIntersectionNode(l1, l11));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
