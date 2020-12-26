class Solution {
    public double averageWaitingTime(int[][] c) {
        int len = c.length;
        long wait = 0;
        int idel = 0;
        for (int i = 0; i < len; i++) {
            int serve = Math.max(idel, c[i][0]) + c[i][1];
            wait += serve - c[i][0];
            idel = serve;
        }
        
        return (double)wait / len;
    }
}
