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
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n = n ^ nums[i];
        }
        return n;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{7,1,5,3,6,4};//7    122. 买卖股票的最佳时机 II
        int[] a = new int[]{1,7,3,1,3,7,6,5,5,2,2};
        System.out.println(new Solution().singleNumber(a));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
