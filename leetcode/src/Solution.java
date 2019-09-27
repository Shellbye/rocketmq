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
        int m = 0;
        int status = 0; // 0 bug 1 sell
        for (int i = 0; i < prices.length - 1; i++) {
            if (status == 0) {
                // 要买入的状态
                if (prices[i + 1] > prices[i]) {
                    m -= prices[i];
                    status = 1;
                }
            } else {
                // 要卖出的状态
                if (prices[i + 1] < prices[i]) {
                    m += prices[i];
                    status = 0;
                }
            }
        }
        if (status == 1) {
            m += prices[prices.length - 1];
        }
        return m;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{7,1,5,3,6,4};//7    122. 买卖股票的最佳时机 II
        int[] a = new int[]{1,7,1,1,1,1,1,1,1,2};
        System.out.println(new Solution().maxProfit(a));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
