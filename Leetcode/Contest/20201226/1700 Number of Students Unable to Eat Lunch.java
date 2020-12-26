class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int one = 0;
        int zero = 0;
        for (int s : students) {
            if (s == 0) zero++;
            else one++;
        }
        int cnt = one + zero;
        int pt;
        for (pt = 0; pt < cnt; pt++) {
            if (sandwiches[pt] == 0) {
                if (zero == 0) break;
                zero--;
            } else {
                if (one == 0) break;
                one--;
            }
        }
        
        return cnt - pt;
    }
}
