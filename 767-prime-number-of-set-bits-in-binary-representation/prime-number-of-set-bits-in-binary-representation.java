class Solution {
    private static final Set<Integer> PRIMES = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
    public int countPrimeSetBits(int left, int right) {
       int count = 0;
       for(int i=left;i<=right;i++){
        int setBits = Integer.bitCount(i);
        if(PRIMES.contains(setBits)){
            count++;
        }
       }
       return count;
    }
}