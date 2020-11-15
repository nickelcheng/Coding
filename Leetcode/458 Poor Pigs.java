class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets)/Math.log(Math.floor(minutesToTest/minutesToDie)+1));
    }
}
