class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        boolean[] flag = new boolean[len];
        Arrays.fill(flag, true);
        
        flag[0] = false;
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            flag[i] = nums[i] > min;
            min = Math.min(min, nums[i]);
        }

        int start = 1;
        while (start < len && !flag[start]) start++;
        if (start == len) return false;
        
        flag[start] = false;
        min = nums[start];
        for (int i = start + 1; i < len; i++) {
            if (flag[i]) {
                flag[i] = nums[i] > min;
                min = Math.min(min, nums[i]);
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (flag[i]) return true;
        }
        return false;
    }
}
