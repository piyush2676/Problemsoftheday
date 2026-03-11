class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        String number = Integer.toBinaryString(n);
        char[] ch = number.toCharArray();
        for(int i=0;i<number.length();i++){
           if(ch[i] == '0'){
               ch[i] = '1';
           }
           else{
             ch[i]= '0';
           }
        }
        String flipped = new String(ch);
        return Integer.parseInt(flipped,2);
    }
}