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
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cnt.containsKey(nums[i])) {
                int n = cnt.get(nums[i]) + 1;
                cnt.put(nums[i], n);
            } else {
                cnt.put(nums[i], 1);
            }
            if (cnt.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{7,1,5,3,6,4};//7    122. 买卖股票的最佳时机 II
        int[] a = new int[]{1, 7, 3, 1, 3, 7, 1, 1, 1, 1, 1};
//        int[] a = new int[]{3, 2, 3};
        System.out.println(new Solution().majorityElement(a));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
