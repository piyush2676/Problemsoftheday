class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int resultidx = 0;
        while(l<=h){
            while(l<h && nums[l] == nums[l+1]) l++;
            while(h>l && nums[h] == nums[h-1]) h--;
            
            int mid = l + (h-l)/2;
            if(nums[mid] < nums[resultidx]){
                resultidx = mid;
            }
            if(nums[mid] > nums[h]){
                l = mid + 1;
            }else{
                h = mid - 1;
            }

        }
        return nums[resultidx];
    }
}