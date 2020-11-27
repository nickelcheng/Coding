class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (sum % 2 == 1) return false;
        
        boolean[] table = new boolean[sum/2];
        table[0] = true;
        
        int currMax = 0;
        for (int num : nums) {
            for (int i = currMax; i >= 0; i--) {
                if (!table[i]) continue;
                int currSum = i + num;
                if (currSum == sum/2) return true;
                if (currSum < sum/2) {
                    table[currSum] = true;
                    currMax = Math.max(currMax, currSum);
                }
            }
        }

        return false;
    }
}
