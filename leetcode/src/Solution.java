import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 核心在于寻找比 n 大和比 n 小的两个回文数
     * 高位+1反转
     * 高位直接反转
     * 高位-1反转
     * "那么实际上最近回文数是有范围的，比如说n为三位数，那么其最近回文数的范围在[99, 1001]之间，
     * 这样我们就可以根据给定数字的位数来确定出两个边界值，要和其他生成的回文数进行比较，取绝对差最小的。"
     * ——https://www.cnblogs.com/grandyang/p/6915355.html
     */
    public String nearestPalindromic(String n) {
        int half = n.length() / 2 + n.length() % 2; // 统一奇偶
        long value = Long.parseLong(n);
        long highVal0 = Long.parseLong(n.substring(0, half));
        Set<Long> candidates = new HashSet<>();
        candidates.add((long) Math.pow(10, n.length() - 1) - 1);
        candidates.add((long) Math.pow(10, n.length()) + 1);
        for (int i = -1; i <= 1; i++) {
            String pre = String.valueOf(highVal0 + i);
            String post = "";
            if (n.length() % 2 == 0) { // 偶数，前半部分整体反转
                post = new StringBuffer(pre).reverse().toString();
            } else {                   // 奇数，需要注意中间不反转，减少一位即可
                post = new StringBuffer(pre.substring(0, pre.length() - 1)).reverse().toString();
            }

            Long candidate = Long.parseLong(String.format("%s%s", pre, post));
            candidates.add(candidate);
        }
        candidates.remove(value);
        long result = value;
        long minDif = Long.MAX_VALUE;
        for (Long a : candidates) {
            if (Math.abs(a - value) < minDif) {
                minDif = Math.abs(a - value);
                result = a;
            } else if (Math.abs(a - value) == minDif) {
                result = Math.min(result, a);
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        p(new Solution().nearestPalindromic("1"), "0");
        p(new Solution().nearestPalindromic("9"), "8");
        p(new Solution().nearestPalindromic("10"), "9");
        p(new Solution().nearestPalindromic("11"), "9");
        p(new Solution().nearestPalindromic("12"), "11");
        p(new Solution().nearestPalindromic("13"), "11");
        p(new Solution().nearestPalindromic("14"), "11");
        p(new Solution().nearestPalindromic("15"), "11");
        p(new Solution().nearestPalindromic("16"), "11");
        p(new Solution().nearestPalindromic("16"), "11");
        p(new Solution().nearestPalindromic("17"), "22");
        p(new Solution().nearestPalindromic("111"), "101");
        p(new Solution().nearestPalindromic("123"), "121");
        p(new Solution().nearestPalindromic("100"), "99");
        p(new Solution().nearestPalindromic("199"), "202");
        p(new Solution().nearestPalindromic("902"), "898");
        p(new Solution().nearestPalindromic("999"), "1001");//
        p(new Solution().nearestPalindromic("1111"), "1001");
        p(new Solution().nearestPalindromic("1000"), "999");//
        p(new Solution().nearestPalindromic("1010"), "1001");
        p(new Solution().nearestPalindromic("1112"), "1111");
        p(new Solution().nearestPalindromic("1234"), "1221");
        p(new Solution().nearestPalindromic("1999"), "2002");
        p(new Solution().nearestPalindromic("90100"), "90109");
        p(new Solution().nearestPalindromic("9001000"), "9001009");
        p(new Solution().nearestPalindromic("900000"), "899998");
        p(new Solution().nearestPalindromic("1805170081"), "1805115081");
        p(new Solution().nearestPalindromic("9723"), "9669");   //  9724 = (9779 + 9669) / 2
        p(new Solution().nearestPalindromic("9724"), "9669");   //  9724 = (9779 + 9669) / 2
        p(new Solution().nearestPalindromic("9725"), "9779");   //  9724 = (9779 + 9669) / 2
        p(new Solution().nearestPalindromic("9900"), "9889");   //
        p(new Solution().nearestPalindromic("9938"), "9889");   //
        p(new Solution().nearestPalindromic("9944"), "9889");   //  9944 = (9999 + 9889) / 2
        p(new Solution().nearestPalindromic("9945"), "9999");
        p(new Solution().nearestPalindromic("9977"), "9999");   //
        p(new Solution().nearestPalindromic("12321"), "12221");
        p(new Solution().nearestPalindromic("123321"), "122221");
        p(new Solution().nearestPalindromic("12932"), "12921");
        p(new Solution().nearestPalindromic("99800"), "99799");
        p(new Solution().nearestPalindromic("12120"), "12121");
        p(new Solution().nearestPalindromic("807045053224792883"), "807045053350540708");

    }

    public static void p(Object input, String answer) {
//        System.out.println(input);
        if (!answer.equals(input)) {
            System.err.println(input + ", but expect " + answer);
            System.exit(0);
        } else {
            System.out.println("success as " + answer);
        }
    }

}
