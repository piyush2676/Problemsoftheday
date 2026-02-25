class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(temp,(a,b) -> {
            int counta = Integer.bitCount(a);
            int countb = Integer.bitCount(b);
            if(counta == countb){
                return a-b;
            }
            return counta-countb;
        });
        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }
        return arr;
    }
}