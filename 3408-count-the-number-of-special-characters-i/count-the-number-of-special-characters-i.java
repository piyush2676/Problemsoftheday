class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> st = new HashSet<>();
        int n = word.length();
        boolean found = false;
        int specialOnes = 0;
        for(int i=0;i<n;i++){
            st.add(word.charAt(i));
        }
        for(char ch = 'a';ch<='z';ch++){
            if(st.contains(ch) && st.contains(Character.toUpperCase(ch))){
                specialOnes++;
            }
        }
        return specialOnes;
    }
}