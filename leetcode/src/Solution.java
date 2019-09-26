import java.util.ArrayList;
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
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode m = head;
        while (l1 != null && l2 != null) {
            int v = 0;
            if (l1.val < l2.val) {
                v = l1.val;
                l1 = l1.next;
            } else {
                v = l2.val;
                l2 = l2.next;
            }
            ListNode tmp = new ListNode(v);
            m.next = tmp;
            m = m.next;
        }
        if (l1 != null)
            m.next = l1;
        if (l2 != null)
            m.next = l2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l3;l3.next = l5;l5.next = l7;
        l2.next = l4;l4.next = l6;l6.next = l8;
        ListNode r = new Solution().mergeTwoLists(l1, null);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
