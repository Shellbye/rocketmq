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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树
        if (root == null) {
            return null;
        }
        TreeNode small = p.val <= q.val ? p : q;
        TreeNode large = p.val < q.val ? q : p;
        if (root.val > large.val) {
            // 搜索左子树
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < small.val) {
            // 右子树
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
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
        System.out.println(new Solution().lowestCommonAncestor(null, null, null));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
