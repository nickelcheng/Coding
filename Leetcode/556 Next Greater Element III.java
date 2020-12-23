class Solution {
    public int nextGreaterElement(int n) {
        int[] arr = new int[10];
        int len = 0;
        while (n > 0) {
            arr[len++] = n % 10;
            n /= 10;
        }
        int target;
        for (target = 1; target < len && arr[target] >= arr[target-1]; target++);
        if (target == len) return -1;
        
        int ex;
        for (ex = 0; arr[ex] <= arr[target]; ex++);
        swap(arr, ex, target);

        for (int i = 0, j = target - 1; i < j; i++, j--) {
            swap(arr, i, j);
        }
        
        long num = 0;
        for (int i = len-1; i >= 0; i--) {
            num *= 10;
            num += arr[i];
        }
        
        if (num > Integer.MAX_VALUE) return -1;
        return (int) num;
    }
    
    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
