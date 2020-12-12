class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int len = aliceValues.length;
        int bWin = 0;
        int[] sumArr = new int[len];
        for (int i = 0; i < len; i++) {
            bWin += bobValues[i];
            sumArr[i] = aliceValues[i] + bobValues[i];
        }
        Arrays.sort(sumArr);
        for (int i = len-1; i >= 0; i-=2) {
            bWin -= sumArr[i];
        }
        return Integer.compare(0, bWin);
    }
}
