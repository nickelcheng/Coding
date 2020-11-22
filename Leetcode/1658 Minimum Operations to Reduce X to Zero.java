class Solution {
    public int minOperations(int[] nums, int x) {
        int fPt = 0;
        int bPt = nums.length - 1;
        int ans = nums.length + 1;
        while (x > 0 && fPt < nums.length) {
            x -= nums[fPt++];
        }
        if (fPt == nums.length) {
            return (x == 0) ? nums.length : -1;
        }
        while (fPt > 0) {
            if (x == 0) {
                ans = Math.min(ans, fPt + nums.length - 1 - bPt);
                x += nums[--fPt];
            }
            while (x < 0 && fPt > 0) {
                x += nums[--fPt];
            }
            while (x > 0) {
                x -= nums[bPt--];
            }
        }
        if (x == 0) {
            ans = Math.min(ans, nums.length - 1 - bPt);
        }
        return (ans == nums.length + 1) ? -1 : ans;
    }
}
