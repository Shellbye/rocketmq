import java.util.ArrayList;
import java.util.List;

public class Solution {


    public int reverse(int x) {
        long r = 0;
        while (Math.abs(x / 10) > 0) {
            r = r * 10 + x % 10;
            x = x / 10;
        }

        r = r * 10 + x % 10;
        if (x > 0 && r < 0) {
            r = 0;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)r;
    }

    public static void main(String[] args) {
        //-2147483648
//        System.out.println(new Solution().reverse(1534236469));
        System.out.println(new Solution().reverse(-2147483648));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
