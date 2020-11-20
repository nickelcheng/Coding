class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (target == nums[0]) return true;
        int t = nums.length;
        while (t >= 1 && nums[t-1] == nums[0]) t--;
        int h = 0;
        while (h+1 < t) {
            int curr = (h+t) / 2;
            if (isTargetLeft(nums[0], nums[curr], target)) t = curr;
            else h = curr;
        }
        return nums[h] == target;
    }
    
    private boolean isTargetLeft(int start, int curr, int target) {
        if (target >= start && curr < start) return true;
        if (target < start && curr >= start) return false;
        return target < curr;
    }
}
