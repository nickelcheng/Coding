class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len-k+1];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (x, y) -> Integer.compare(nums[y], nums[x]));
        for (int i = 0; i < k; i++) {
            pq.add(i);
        }
        int h = 0;
        int t = k;
        while (t < len) {
            while (pq.size() > 0 && pq.peek() < h) pq.poll();
            ans[h++] = nums[pq.peek()];
            pq.add(t++);
        }
        
        while (pq.size() > 0 && pq.peek() < h) pq.poll();
        ans[len-k] = nums[pq.peek()];
        return ans;
    }
}
