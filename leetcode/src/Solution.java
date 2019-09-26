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
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        // 第一轮统计有多少重复
        int dupCnt = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                dupCnt++;
            } else {
                pre = nums[i];
            }
        }
        // 第二轮移动
        pre = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length - dupCnt; i++) {
            while (pre == nums[index]) {
                index++;
            }
            nums[i] = nums[index];
            pre = nums[index];
            index++;
        }
        return nums.length - dupCnt;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,3,4,5,6,7,7,8};
//        int[] nums = new int[]{1,1,8};
        int[] nums = new int[]{};
        System.out.println(Arrays.toString(nums));
        int r = new Solution().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
