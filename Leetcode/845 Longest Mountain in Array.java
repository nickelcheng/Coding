class Solution {
    class Mountain {
        boolean up;
        boolean down;
        int size;
        int curr;
        public Mountain() {
            up = false;
            down = false;
            size = 0;
            curr = -1;
        }
        int tryNextPoint(int pt) {
            size++;
            if (curr == -1) {
                curr = pt;
                return 0;
            }
            if (!up && pt > curr) {
                curr = pt;
                up = true;
                return 0;
            }
            if (up && !down) {
                if (pt > curr) {
                    curr = pt;
                    return 0;
                }
                if (pt < curr) {
                    down = true;
                    curr = pt;
                    return size;
                }
            }
            if (up && down && pt < curr) {
                curr = pt;
                return size;
            }
            up = false;
            down = false;
            size = 1;
            if (curr < pt) {
                size++;
                up = true;
            }
            curr = pt;
            return 0;
        }
    }
    
    public int longestMountain(int[] A) {
        int ans = 0;
        int len = A.length;
        Mountain mountain = new Mountain();
        for(int i = 0; i < len; i++) {
            ans = Math.max(ans, mountain.tryNextPoint(A[i]));
        }
        return ans;
    }
}
