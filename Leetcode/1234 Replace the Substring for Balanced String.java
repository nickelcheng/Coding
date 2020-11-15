class Solution {
    class CharCount {
        private int q;
        private int w;
        private int e;
        private int r;
        
        public CharCount() {
            q = 0;
            w = 0;
            e = 0;
            r = 0;
        }
        public CharCount (CharCount ref) {
            q = ref.q;
            w = ref.w;
            e = ref.e;
            r = ref.r;
        }
    }
    
    public int balancedString(String s) {
        int len = s.length();
        int avg = len / 4;
        CharCount[] count = new CharCount[len];
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                count[i] = new CharCount(count[i-1]);
            } else {
                count[i] = new CharCount();
            }
            switch (s.charAt(i)) {
                case 'Q': count[i].q++; break;
                case 'W': count[i].w++; break;
                case 'E': count[i].e++; break;
                case 'R': count[i].r++; break;
            }
        }
        CharCount target = new CharCount();
        target.q = count[len-1].q - avg;
        target.w = count[len-1].w - avg;
        target.e = count[len-1].e - avg;
        target.r = count[len-1].r - avg;
        if (target.q == 0 && target.w == 0 && target.e == 0 && target.r == 0) {
            return 0;
        }
        
        int ans = len;
        int h = 0;
        int t = 0;
        while (t < len) {
            while (t < len && !happy(count, h, t, target)) t++;
            if (t >= len) break;
            ans = Math.min(ans, t-h+1);
            h++;
            while (happy(count, h, t, target)) {
                ans = Math.min(ans, t-h+1);
                h++;
            }
            t++;
        }
        
        return ans;
    }
    
    private boolean happy(CharCount[] count, int h, int t, CharCount target) {
        CharCount curr = new CharCount();
        if (h == 0) {
            curr.q = count[t].q;
            curr.w = count[t].w;
            curr.e = count[t].e;
            curr.r = count[t].r;
        } else {
            curr.q = count[t].q - count[h-1].q;
            curr.w = count[t].w - count[h-1].w;
            curr.e = count[t].e - count[h-1].e;
            curr.r = count[t].r - count[h-1].r;
        }
        return curr.q >= target.q && curr.w >= target.w && curr.e >= target.e && curr.r >= target.r;
    }
}
