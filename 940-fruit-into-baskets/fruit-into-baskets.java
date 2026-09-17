class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxlen = 0;
        while(j < n){
            mp.put(fruits[j],mp.getOrDefault(fruits[j],0)+1);
            while(mp.size() > 2){
                mp.put(fruits[i],mp.get(fruits[i])-1);
                if(mp.get(fruits[i]) == 0){
                    mp.remove(fruits[i]);
                }
                i++;
            }
            maxlen = Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}