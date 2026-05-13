class Solution {
    public int tribonacci(int n) {
        int[] arr = new int[38];
        arr[0] = 0;
         arr[1] = arr[2] = 1;
        for(int i=0;i<=n-3;i++){
            arr[i+3] = arr[i] + arr[i+1] + arr[i+2];
        }
        return arr[n];
    }
}