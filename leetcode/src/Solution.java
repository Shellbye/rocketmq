import java.util.ArrayList;
import java.util.List;

public class Solution {


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int x0 = x;
        while (x / 10 > 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        y = y * 10 + x % 10;
        return x0 == y;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1234321));
        System.out.println(new Solution().isPalindrome(123321));
        System.out.println(new Solution().isPalindrome(1233211));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
