class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int len = heights.length;
        
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int sTop = stack.peek();
            if (sTop == -1 || heights[sTop] <= heights[i]) {
                stack.push(i);
                continue;
            }
            while(heights[sTop] > heights[i]) {
                stack.pop();
                int pre = stack.peek();
                ans = Math.max(ans, heights[sTop] * (i-1-pre));
                if (pre == -1) break;
                sTop = pre;
            }
            stack.push(i);
        }
        
        while(stack.size() > 1) {
            int sTop = stack.pop();
            int pre = stack.peek();
            ans = Math.max(ans, heights[sTop] * (len-1-pre));
        }
        return ans;
    }
}
