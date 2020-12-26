class Solution {
    public String maximumBinaryString(String binary) {
        int target = -1;
        boolean hasZero = false;
        int len = binary.length();
        for (int i = 0; i < len && target == -1; i++) {
            if (binary.charAt(i) == '0') hasZero = true;
            if (hasZero && binary.charAt(i) == '1') target = i;
        }
        if (!hasZero) return binary;
        if (target == -1) target = len;
        
        int zeroCnt = 0;
        for (int i = target+1; i < len; i++) {
            if (binary.charAt(i) == '0') zeroCnt++;
        }
        target += zeroCnt;
        
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < target - 1; i++) {
            ans.append('1');
        }
        ans.append('0');
        for (int i = target; i < len; i++) {
            ans.append('1');
        }
        return ans.toString();
    }
}
