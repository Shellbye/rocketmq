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

public class Solution {
    // 88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前合并，可以避免多次移动
        int pm = m - 1;
        int pn = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (pm >= 0 && pn >= 0) {
                if (nums1[pm] > nums2[pn]) {
                    nums1[i] = nums1[pm];
                    pm--;
                } else {
                    nums1[i] = nums2[pn];
                    pn--;
                }
            } else {
                if (pm < 0) {
                    nums1[i] = nums2[pn];
                    pn--;
                } else {
                    nums1[i] = nums1[pm];
                    pm--;
                }

            }

        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{0};
        int[] n2 = new int[]{};
        System.out.println(Arrays.toString(n1));
        new Solution().merge(n1, 0, n2, 0);
        System.out.println(Arrays.toString(n1));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
