import java.util.ArrayList;
import java.util.List;

public class SevenEight {

    public List<List<Integer>> subsets(int[] nums) {
        /*
        思路
        数组子集元素个数分别为是0~n-1，分别找元素个数是0~n-1的子数组

        找每种子数组中的元素时，采用递归的方式一个数一个数确定
        递归终止条件：weiZhi等于要找的元素个数
         */
        List<Integer> out = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] visited = new int[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            findOneNum(nums, i, visited, out, res);
        }
        return res;
    }

    /**
     * @param nums    源数组
     * @param geShu   要查找的子数组元素个数
     * @param visited 访问数组记录数组元素是否可选择
     * @param out     记录一个子数组元素
     * @param res     记录所有子数组
     */
    private void findOneNum(int[] nums, int geShu, int[] visited, List<Integer> out, List<List<Integer>> res) {
        if (out.size() == geShu) {
            List<Integer> numArr = new ArrayList<>(out);
            res.add(numArr);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //元素可使用
            if (visited[i] == 0) {  // 只在递归的内部才会有 1 的出现，最初进入都是 0
                out.add(nums[i]);
                //位置i及位置i前的数后面都不能选
                for (int j = 0; j < i + 1; j++) {
                    visited[j] = 1;
                }
                //递归查找下一个数
                findOneNum(nums, geShu, visited, out, res);
                // 还原标记
                for (int j = 0; j < i + 1; j++) {
                    visited[j] = 0;
                }
                // 这里可以 remove 是因为在上面的 findOneNum 中已经在 out.size() == geShu add 到了 res 中
                out.remove(out.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[6];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        nums[5] = 6;
        p(new SevenEight().subsets(nums));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}