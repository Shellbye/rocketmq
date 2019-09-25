import java.util.ArrayList;
import java.util.List;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode r = head;
        int acc = 0;
        while (l1 != null && l2 != null) {
            int nVal = l1.val + l2.val + acc;
            acc = nVal / 10;
            nVal = nVal % 10;
            ListNode tmpNode = new ListNode(nVal);
            r.next = tmpNode;
            r = tmpNode;
            System.out.println(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int nVal = l1.val + acc;
            acc = nVal / 10;
            nVal = nVal % 10;
            ListNode tmpNode = new ListNode(nVal);
            r.next = tmpNode;
            r = tmpNode;
            System.out.println(nVal);
            l1 = l1.next;
        }
        while (l2 != null) {
            int nVal = l2.val + acc;
            acc = nVal / 10;
            nVal = nVal % 10;
            ListNode tmpNode = new ListNode(nVal);
            r.next = tmpNode;
            r = tmpNode;
            System.out.println(nVal);
            l2 = l2.next;
        }
        if (acc != 0) {
            head.next.val = acc;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(5);
        ListNode h2 = new ListNode(5);
        new Solution().addTwoNumbers(h1, h2);
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
