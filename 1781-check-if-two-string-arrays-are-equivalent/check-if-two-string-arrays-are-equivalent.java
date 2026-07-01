class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for(String i : word1){
            s1.append(i);
        }
        StringBuilder s2 = new StringBuilder();
        for(String j : word2){
            s2.append(j);
        }
        return s1.toString().equals(s2.toString());
    }
}