class Solution {
    int[] myN;
    int[][] tbl;
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int myL = len + 2;
        
        myN = new int[myL];
        myN[0] = 1;
        myN[myL-1] = 1;
        for (int i = 0; i < len; i++) {
            myN[i+1] = nums[i];
        }
        
        tbl = new int[myL][myL];
        for (int i = 0; i < myL; i++) {
            Arrays.fill(tbl[i], -1);
        }
        tbl[0][0] = 0;
        tbl[myL-1][myL-1] = 0;
        for (int i = 1; i < myL-1; i++) {
            tbl[i][i] = myN[i-1] * myN[i] * myN[i+1];
        }
        
        return dp(1, nums.length);
    }
    
    private int dp(int s, int e) {
        if (tbl[s][e] != -1) {
            return tbl[s][e];
        }
        int max = 0;
        for (int i = s; i <= e; i++) {
            int curr = dp(s, i-1) + dp(i+1, e) + myN[i] * myN[s-1] * myN[e+1];
            max = Math.max(max, curr);
        }
        tbl[s][e] = max;
        return max;
    }
}
