class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int perimeter = 0;
        int i =0;
        int j = i+1;
        int k = j+1;
        while(i < n && j < n && k < n){
             if(nums[i] + nums[j] > nums[k]){
                perimeter = nums[i] + nums[j] + nums[k];
             }
             i++;
             j++;
             k++;
        }
        return perimeter;
    }
}