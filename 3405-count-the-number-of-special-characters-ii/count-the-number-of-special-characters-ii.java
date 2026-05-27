class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] lastoccur = new int[26];
        int[] firstoccurCap = new int[26];
        for(int i=0;i<26;i++){
            lastoccur[i] = -1;
            firstoccurCap[i] = -1;
        }
        int count = 0;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                lastoccur[ch-'a'] = i;
            }else{
                if(firstoccurCap[ch-'A'] == -1){
                    firstoccurCap[ch-'A'] = i;
                }
            }
        }
        for(int i=0;i<26;i++){
            if((lastoccur[i] != -1 && firstoccurCap[i] != -1) && (lastoccur[i] < firstoccurCap[i])){
                count++;
            }
        }
        return count;
    }
}