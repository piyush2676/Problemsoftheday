class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefix = new int[n+1];
        prefix[0] = gain[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + gain[i];
        }
        int largest = prefix[0];
        for(int i=1;i<prefix.length;i++){
            if(prefix[i] > largest){
                largest = prefix[i];
            }
        }
        return largest;
    }
}