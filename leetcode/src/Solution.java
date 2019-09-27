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
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 只能交易一次
        int minP = Integer.MAX_VALUE;
        int m = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minP) {
                minP = prices[i];
            }
            if (prices[i] - minP > m) {
                m = prices[i] - minP;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(a));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
