class Solution {
    public int search(int[] nums, int target) {
        int h = 0;
        int t = nums.length;
        while (h+1 < t) {
            int curr = (h+t) / 2;
            if (isTargetLeft(nums[0], nums[curr], target)) {
                t = curr;
            } else {
                h = curr;
            }
        }
        return (nums[h] == target) ? h : -1;
    }
    
    private boolean isTargetLeft(int start, int curr, int target) {
        if (curr >= start && target < start) return false;
        if (curr < start && target >= start) return true;
        return target < curr;
    }
}
