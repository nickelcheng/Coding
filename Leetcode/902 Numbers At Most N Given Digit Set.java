class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] num = new int[10];
        int k = 0;
        while (n > 0) {
            num[k++] = n % 10;
            n /= 10;
        }
        int ans = 0;
        int possi = digits.length;
        for (int i = 0; i < k-1; i++) {
            ans += possi;
            possi *= digits.length;
        }
        return ans + fun(digits, Arrays.copyOf(num, k));
    }
    
    private int fun(String[] digits, int[] num) {
        int smallerCnt = 0;
        int eqCnt = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i].charAt(0) - '0' < num[num.length-1]) smallerCnt++;
            if (digits[i].charAt(0) - '0' == num[num.length-1]) eqCnt++;
        }
        if (num.length == 1) return smallerCnt + eqCnt;
        int ans = 0;
        if (smallerCnt > 0)
            ans += smallerCnt * (int)Math.pow(digits.length, num.length-1);
        if (eqCnt > 0)
            ans += fun(digits, Arrays.copyOf(num, num.length-1));
        return ans;
    }
}
