
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
    public boolean isSymmetric(TreeNode root) {
        if (root.right.val != root.left.val) {
            return false;
        }
        return s(root.right, root.left);
    }

    public boolean s(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }

        if (right != null && left != null && right.val != left.val) {
            return false;
        }

        if (right != null && left != null) {
            return s(right.right, left.left) && s(right.left, left.right);
        }
        return false;
    }



    public static void main(String[] args) {
//        int[] a = new int[]{7,1,5,3,6,4};//7    122. 买卖股票的最佳时机 II
//        int[] a = new int[]{1, 7, 3, 1, 3, 7, 1, 1, 1, 1, 1};
//        int[] a = new int[]{3, 2, 3};
        /*
          1
        2  3
       4    5
        * */
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(2);
        TreeNode l4 = new TreeNode(3);
        TreeNode l5 = new TreeNode(3);
        TreeNode l6 = new TreeNode(6);
        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l3.right = l5;
        int[] a = new int[]{1, 2, 3, 10, 4, 5, 6};
        System.out.println(new Solution().isSymmetric(l1));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
