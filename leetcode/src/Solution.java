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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int mL = 0;
        int mR = 0;
        if (root.left != null) {
            mL = maxDepth(root.left);
        }
        if (root.right != null) {
            mR = maxDepth(root.right);
        }
        return Math.max(mL, mR) + 1;
    }

    public static void main(String[] args) {
        new Solution().maxDepth(null);
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
