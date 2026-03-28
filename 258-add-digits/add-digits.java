class Solution {
   public int digitSum(int num,int b){
        int total = 0;
        while(num>0){
            total+=num%b;
            num /= b;
        }
        return total;
    }
    public int digitalroot(int num,int b){
        HashSet<Integer> seen = new HashSet<>();
        while(!seen.contains(num)){
            seen.add(num);
            num = digitSum(num,b);
        }
        return num;
    }
    public int additivePersistence(int num,int b){
        HashSet<Integer> seen = new HashSet<>();
        while(!seen.contains(num)){
            seen.add(num);
            num = digitSum(num,b);
        }
        return seen.size()-1;
    }
    public int addDigits(int num) {
        int b = 10;
        return digitalroot(num,b);
     
    }
}