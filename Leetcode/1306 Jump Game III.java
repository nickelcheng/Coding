class Solution {
    private int[] a;
    
    public boolean canReach(int[] arr, int start) {
        a = Arrays.copyOf(arr, arr.length);
        return dfs(start);
    }
    
    private boolean dfs(int pos) {
        if (pos < 0 || pos >= a.length) return false;
        if (a[pos] == -1) return false;
        if (a[pos] == 0) return true;
        int d = a[pos];
        a[pos] = -1;
        
        return dfs(pos-d) || dfs(pos+d);
    }
}

// 0:00 start coding
// 9:00 WA
// 10:45 AC
