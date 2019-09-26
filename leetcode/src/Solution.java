import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                chars.push(c);
            } else {
                if (chars.isEmpty()) {
                    return false;
                }
                Character cOut = chars.pop();
                switch (cOut) {
                    case '(':
                        if (c != ')') {
                            return false;
                        }
                        break;
                    case '[':
                        if (c != ']') {
                            return false;
                        }
                        break;
                    case '{':
                        if (c != '}') {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
//            System.out.println(c);
        }
        return chars.isEmpty();
    }

    public static void main(String[] args) {
        String strings = "[";
        System.out.println(new Solution().isValid(strings));
    }

    public static void p(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
