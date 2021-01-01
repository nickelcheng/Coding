class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int aLen = arr.length;
        int pLen = pieces.length;
        
        int pt = 0;
        boolean flag = true;
        while (pt < aLen && flag) {
            flag = false;
            for (int i = 0; i < pLen && pt < aLen; i++) {
                if (arr[pt] == pieces[i][0]) {
                    flag = true;
                    for (int j = 0; j < pieces[i].length; j++) {
                        if (arr[pt++] != pieces[i][j]) return false;
                    }
                }
            }
        }
        return pt == aLen;
    }
}
