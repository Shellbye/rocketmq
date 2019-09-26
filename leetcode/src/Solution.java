import java.util.ArrayList;
import java.util.List;

public class Solution {


    public String longestCommonPrefix(String[] strs) {
        String s = "";
        if (strs.length < 1) {
            return s;
        }
        for (int i = 0; i <= strs[0].length(); i++) {
            s = strs[0].substring(0, i);
            for (String s1 : strs) {
                if (!s1.startsWith(s)) {
                    return s.substring(0, s.length() - 1);
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"flower","flow","flight"};
//        String[] strings = new String[]{"1flower","2flow","flight"};
//        String[] strings = new String[]{"a"};
        System.out.println(new Solution().longestCommonPrefix(strings));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
