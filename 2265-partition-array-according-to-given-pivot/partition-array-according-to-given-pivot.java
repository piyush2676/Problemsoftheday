class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int countless = 0;
        int equaltopivot = 0;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i] < pivot) countless++;
            if(nums[i] == pivot) equaltopivot++;
        }
        int i = 0;
        int j = countless;
        int k = countless+equaltopivot;
        for(int insert : nums){
            if(insert < pivot) {
                result[i] = insert;
                i++;
            }
            else if(insert == pivot){
                result[j] = insert;
                j++;
            }else{
                result[k] = insert;
                k++;
            }
        }
        return result;
    }
}