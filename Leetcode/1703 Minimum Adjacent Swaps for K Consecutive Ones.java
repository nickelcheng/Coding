class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> ones = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones.add(i - cnt);
                cnt++;
            }
        }
        
        int len = ones.size();
        int offset = (k-1) / 2;
        int curr = 0;
        for (int i = 0; i < offset; i++) {
            curr -= ones.get(i);
        }
        for (int i = offset+1; i < k; i++) {
            curr += ones.get(i);
        }
        if (k % 2 == 0) curr -= ones.get(offset);

        int ans = curr;
        for (int start = 0; start+k < len; start++) {
            curr -= ones.get(start + k/2);
            curr -= ones.get(start + (k+1)/2);
            curr += ones.get(start+k);
            curr += ones.get(start);
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}
