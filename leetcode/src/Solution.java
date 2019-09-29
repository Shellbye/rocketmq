import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    public boolean isPowerOfTwo(int n) {
        long powerOfTwo = 1;
        while (powerOfTwo <= n) {
            if (powerOfTwo == n) {
                return true;
            }
             powerOfTwo = powerOfTwo << 1;

        }
        return false;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{7,1,5,3,6,4};//7    122. 买卖股票的最佳时机 II
//        int[] a = new int[]{1, 7, 3, 1, 3, 7, 1, 1, 1, 1, 1};
//        int[] a = new int[]{3, 2, 3};
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
        int[] a = new int[]{1, 2, 3, 10, 4, 5, 6};
        System.out.println(new Solution().isPowerOfTwo(253));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
