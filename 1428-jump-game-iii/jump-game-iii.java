class Solution {
    public boolean solve(int[] arr,int index){
        int n = arr.length;
        if(index<0 || index>=n || arr[index] < 0)return false;
        if(arr[index] == 0) return true;
        arr[index] *= -1;
        boolean a  = solve(arr,index+arr[index]);
        boolean b = solve(arr,index-arr[index]);
        return (a||b);
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        return solve(arr,start);
    }
}