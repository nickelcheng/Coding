class Solution {
    public int[][] merge(int[][] intervals) {
        int mmin = 10010;
        int mmax = 0;
        for (int i = 0; i < intervals.length; i++) {
            mmin = Math.min(mmin, intervals[i][0]);
            mmax = Math.max(mmax, intervals[i][1]);
        }
        int[] arr = new int[mmax+1];
        arr[0] = -1;
        for (int i = 0; i < intervals.length; i++) {
            arr[intervals[i][0]] = Math.max(arr[intervals[i][0]], intervals[i][1]);
        }
        List<int[]> ans = new ArrayList<>();
        if (arr[0] == 0) ans.add(new int[]{0, 0});
        for (int i = mmin; i <= mmax; i++) {
            if (arr[i] != 0) {
                int start = i;
                int end = arr[i];
                for (int j = start; j <= end; j++) {
                    end = Math.max(end, arr[j]);
                }
                ans.add(new int[]{start, end});
                i = end;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
