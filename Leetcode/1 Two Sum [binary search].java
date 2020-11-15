class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] copied = Arrays.copyOf(nums, len);
        Arrays.sort(copied);
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < len; i++) {
            int remainder = target - copied[i];
            copied[i] = (remainder == 0) ? 1 : 0;
            
            int foundIdx = binarySearch(copied, remainder);
            copied[i] = target - remainder;
            if (foundIdx < len && copied[foundIdx] == remainder) {
                ans[0] = findOriginalIdx(nums, remainder, -1);
                ans[1] = findOriginalIdx(nums, copied[i], ans[0]);
                break;
            }
            
        }
        return ans;
    }
    
    private int findOriginalIdx(int[] nums, int target, int exclude) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i != exclude && nums[i] == target) {
                return i;
            }
        }
        return len;
    }
    
    private int binarySearch(int[] arr, int target) {
        int h = 0;
        int t = arr.length;
        while (h < t - 1) {
            int curr = (h+t) / 2;
            if (arr[curr] > target) {
                t = curr;
            } else {
                h = curr;
            }
        }
        if (arr[h] == target) {
            return h;
        }
        return arr.length;
    }
}
