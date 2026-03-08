class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        String result = "";
        for(int i=0;i<n;i++){
            char ch = nums[i].charAt(i);
            if(ch == '0'){
                result+="1";
            }
            else{
                result+="0";
            }
        }
        return result;
    }
}