class Solution {
    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        if (p/g % 2 == 1 && q/g % 2 == 1) return 1;
        if (p/g % 2 == 0 && q/g % 2 == 1) return 2;
        return 0;
    }
    
    int gcd(int a, int b) {
        if (a%b == 0) return b;
        return gcd(b, a%b);
    }
}
