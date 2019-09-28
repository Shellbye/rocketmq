import java.util.ArrayList;

public class MinStack {

        private int min;

        private ArrayList<Integer> data;

        private ArrayList<Integer> minList;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new ArrayList<>();
            minList = new ArrayList<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            data.add(x);
            if (x <= min) {
                minList.add(min);
                min = x;
            }
        }

        public void pop() {
            Integer integer = data.remove(data.size() - 1);
            if (integer == min) {
                // 重置最小值
                min = minList.get(minList.size() - 1);
                minList.remove(minList.size() - 1);
            }
        }

        public int top() {
            return data.get(data.size() - 1);
        }

        public int getMin() {
            return min;
        }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */