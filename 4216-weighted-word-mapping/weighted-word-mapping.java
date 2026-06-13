class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder s = new StringBuilder();
       
        for (String word : words) {
             int sum = 0;
             for(char ch : word.toCharArray()){
            int index = ch - 'a';
             sum = sum + weights[index];
             }
        int mod = sum % 26;
        char mappedchar = (char) ('z' - mod);
        s.append(mappedchar);
        }
        return s.toString();
    }
}