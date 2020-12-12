class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int preSum = 0;
        int postSum = sum;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            postSum -= nums[i];
            ans[i] = nums[i] * (2*i - nums.length + 1) - preSum + postSum;
            preSum += nums[i];
        }
        return ans;
    }
}
