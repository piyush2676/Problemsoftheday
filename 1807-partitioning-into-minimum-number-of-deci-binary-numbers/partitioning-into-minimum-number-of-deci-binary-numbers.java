class Solution {
    public int minPartitions(String n) {
        char[] c = n.toCharArray();
        int count = 0;
        while(true){
            boolean changed = false;
            for(int i=0;i<c.length;i++){
                if(c[i]!='0'){
                    c[i]--;
                    changed = true;
                }
            }
            if(!changed){
                break;
            }
            count++;
        }
        return count;
    }
}
// trick part
// char maxch = '0';
//for(char ch : n.toCharArray()){
//  maxch =(char)Math.max(maxch,ch)
//}
//return maxch-'0';