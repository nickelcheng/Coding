class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean goingUp = true;
        int curr = 0;
        int len = arr.length;
        while (curr < len - 1) {
            if (goingUp) {
                if (curr > 0 && arr[curr-1] < arr[curr] && arr[curr] > arr[curr+1]) {
                    goingUp = false;
                } else if (arr[curr] >= arr[curr+1]) {
                    return false;
                }
            } else {
                if (arr[curr] <= arr[curr+1]) {
                    return false;
                }
            }
            curr++;
        }
        return !goingUp;
    }
}
