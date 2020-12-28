class Solution {
    public int reachNumber(int target) {
        int n = 1;
        target = Math.abs(target);
        int sum = 0;
        while(true) {
            sum += n;
            if (sum == target) return n;
            if (sum > target) {
                if ((sum - target) % 2 == 0) return n;
                if (n % 2 == 0) return n+1;
                return n+2;
            }
            n++;
        }
    }
}
