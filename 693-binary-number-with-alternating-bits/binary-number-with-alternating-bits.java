class Solution {
    public boolean hasAlternatingBits(int n) {
    int number = n ^ (n >> 1);
    return (number & (number+1)) == 0;
    }
}