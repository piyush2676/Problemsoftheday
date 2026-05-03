class Solution {
    public boolean rotateString(String s, String goal) {
        char[] arr = s.toCharArray();
        char[] arr1 = goal.toCharArray();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(Arrays.equals(arr,arr1)) return true;
            char first = arr[0];
            for(int j=0;j<n-1;j++){
                arr[j] = arr[j+1];
            }
            arr[n-1] = first;
        }
        return false;
    }
}