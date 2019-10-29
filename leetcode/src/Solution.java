
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
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        String[] ns = new String[ss.length];
        int i = 0;
        for (String a : ss) {
            String b = reverseString(a);
            ns[i++] = b;
        }

        return String.join(" ", ns);
    }

    public String reverseString(String str) {
        char[] s = str.toCharArray();
        char a;
        for (int i = 0; i < s.length / 2; i++) {
            a = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = a;
        }
        return new String(s);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    public void mT(TreeNode t1, TreeNode t2, TreeNode n) {
        if (n == null) {

        }

        return;
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
        System.out.println(new Solution().reverseWords("123 4567 8"));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
