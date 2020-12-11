class Solution {
    public int removeDuplicates(int[] nums) {
        int nextPt = 1;
        int pt = 1;
        int count = 1;
        
        while (pt < nums.length) {
            count = (nums[pt] != nums[pt-1]) ? 1 : count + 1;
            if (count <= 2) {
                nums[nextPt++] = nums[pt];
            }
            pt++;
        }
        
        return nextPt;
    }
}
