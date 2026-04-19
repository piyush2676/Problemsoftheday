class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        int maxdistance = 0;
        while(i<n1 && j<n2){
            if(i<=j && nums1[i] <= nums2[j]){
                maxdistance = Math.max(maxdistance,j-i);
                j++;
            }
            else{
                i++;
                if(i > j) j = i;
            }
        }
        return maxdistance;
    }
}