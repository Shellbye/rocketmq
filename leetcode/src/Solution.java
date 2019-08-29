import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String nearestPalindromic(String n) {
        // 个位数需要单独处理
        if (n.length() == 1) {
            return String.valueOf(Long.parseLong(n) - 1);
        }
        // 10, 11 单独处理
        if ("10".equals(n) || "11".equals(n)) {
            return "9";
        }
        if (n.length() % 2 == 0) {  // 长度为偶数，可能是 123321 之类（称为轴对称）
//            return copyEvenHigh2Low(n, (long) Math.pow(10, n.length() - 1) - 1, (long) Math.pow(10, n.length()) + 1);
            return copyHigh2Low(n, (long) Math.pow(10, n.length() - 1) - 1, (long) Math.pow(10, n.length()) + 1);
        } else {    // 长度为奇数，可能是 12321 之类（称为中心对称）
            return copyOddHigh2Low(n, (long) Math.pow(10, n.length() - 1) - 1, (long) Math.pow(10, n.length()) + 1);
//            return copyHigh2Low(n, (long) Math.pow(10, n.length() - 1) - 1, (long) Math.pow(10, n.length()) + 1);
        }
    }

    /**
     * 核心在于寻找比 n 大和比 n 小的两个回文数
     * 直接高位反转：结果可能大也可能小，取决于高位反转之后与原来低位的大小   = a
     *
     * 比 n 大：
     *      高位+1反转                                               = b
     *      低位上升
     * 比 n 小：
     *      高位-1反转                                               = c
     *      低位下降
     *
     *
     * 99999 和 10000 这种有个比较特殊的地方，就是他们的高位在加一减一之后，会发生位数的变化
     *
     * "那么实际上最近回文数是有范围的，比如说n为三位数，那么其最近回文数的范围在[99, 1001]之间，
     * 这样我们就可以根据给定数字的位数来确定出两个边界值，要和其他生成的回文数进行比较，取绝对差最小的。"
     * ——https://www.cnblogs.com/grandyang/p/6915355.html
     * */
    private long getReversed(long value, boolean even) {
        if (even) {
            return Long.parseLong(new StringBuffer(String.valueOf(value)).reverse().toString());
        } else {
            if (value > 10) {
                return Long.parseLong(new StringBuffer(String.valueOf(value / 10)).reverse().toString());
            } else {
                return Long.parseLong(new StringBuffer(String.valueOf(value)).reverse().toString());
            }
        }
    }

    private String copyOddHigh2Low(String n, long min, long max) {
        // 奇数时，高位要把中间值拉上，因为中间值减一可能会涉及到向高位借位（比如 902）
        int half = n.length() / 2 + 1;
        // 原始高位和它放到低位之后的值
        long highVal = Long.parseLong(n.substring(0, half));
        // 这里的除10是为了去掉多取的那个中间位，因为反转不需要中间位，否则会多出来一位
        String highValReversedStr = new StringBuffer(String.valueOf(highVal / 10)).reverse().toString();
        long h = Long.parseLong(highVal + highValReversedStr);
        // 高位减一和它放到低位之后的值
        long highValM1 = highVal - 1;   // 这里减一之后，可能会少一位
        String highValM1ReversedStr = new StringBuffer(String.valueOf(highValM1 / 10)).reverse().toString();
        long hM = Long.parseLong(highValM1 + highValM1ReversedStr);
        if (hM < min)
            hM = min;
        long highValA1 = highVal + 1;   // 这里加一之后，也可能会多一位
        String highValA1ReversedStr = new StringBuffer(String.valueOf(highValA1 / 10)).reverse().toString();
        long hA = Long.parseLong(highValA1 + highValA1ReversedStr);
        if (hA > max)
            hA = max;
        return judgeAndReturn(h, hM, hA, n);
    }

    private String copyHigh2Low(String n, long min, long max) {
        int half = n.length() / 2;
        long value = Long.parseLong(n);
        long highVal0 = Long.parseLong(n.substring(0, half));
        Set<Long> candidates = new HashSet<>();
        candidates.add(max);
        candidates.add(min);
        for (int i = -1; i <= 1; i++) {
            String pre = String.valueOf(highVal0 + i);
            String middle = n.length() % 2 == 0 ? "" : String.valueOf(n.charAt(half + 1));
            String post = new StringBuffer(pre).reverse().toString();
            Long candidate = Long.parseLong(String.format("%s%s%s", pre, middle, post));
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

    private String copyEvenHigh2Low(String n, long min, long max) {
        /*
          单纯的把高位拷贝到低位是不行的，因为无法确保符合 最近的回文数 中的 最近（比如 9723）
          这里的 最近，需要计算一高一低两个值，然后计算与输入与这两个值的绝对值，取较小的
        */
        int half = n.length() / 2;
        // 高位反转
        long highVal = Long.parseLong(n.substring(0, half));
        String highValReversedStr = new StringBuffer(String.valueOf(highVal)).reverse().toString();
        long h = Long.parseLong(highVal + highValReversedStr);

        // 高位减一
        long highValM1 = highVal - 1;
        String highValM1ReversedStr = new StringBuffer(String.valueOf(highValM1)).reverse().toString();
        long hM = Long.parseLong(highValM1 + highValM1ReversedStr);
        if (hM < min)
            hM = min;
        // 高位加一
        long highValA1 = highVal + 1;
        String highValA1ReversedStr = new StringBuffer(String.valueOf(highValA1)).reverse().toString();
        long hA = Long.parseLong(highValA1 + highValA1ReversedStr);
        if (hA > max)
            hA = max;
        return judgeAndReturn(h, hM, hA, n);
    }

    private String judgeAndReturn(long h, long hM, long hA, String n) {
        long val = Long.parseLong(n);
        long d1 = Math.abs(val - h);
        long d2 = Math.abs(val - hM);
        long d3 = Math.abs(val - hA);
        if (d1 == 0) {  // 本身就是回文数
            d1 = Long.MAX_VALUE;
        }
        if (d2 <= d1 && d2 <= d3) {
            return String.valueOf(hM);  // 最小值
        }
        if (d1 <= d2 && d1 <= d3) {
            return String.valueOf(h);
        }
        return String.valueOf(hA);
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
