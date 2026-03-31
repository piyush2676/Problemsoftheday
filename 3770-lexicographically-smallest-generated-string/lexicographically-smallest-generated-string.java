class Solution {
    
    public boolean isSame(StringBuilder word, int i, String str2, int m){
        for(int j = 0; j < m; j++){
            if(word.charAt(i) != str2.charAt(j)){
                return false;
            }
            i++;
        }
        return true;
    }

    public String generateString(String str1, String str2) {
        int N = str1.length();
        int m = str2.length();
        int n = N + m - 1;  // ✅ FIX

        StringBuilder word = new StringBuilder("$".repeat(n));
        boolean[] canChange = new boolean[n];

        // Handle 'T'
        for(int i = 0; i < N; i++){
            if(str1.charAt(i) == 'T'){
                int idx = i;
                for(int j = 0; j < m; j++){
                    if(word.charAt(idx) != '$' && word.charAt(idx) != str2.charAt(j)){
                        return "";
                    }
                    word.setCharAt(idx, str2.charAt(j));
                    idx++;
                }
            }
        }

        // Fill remaining with 'a'
        for(int i = 0; i < n; i++){
            if(word.charAt(i) == '$'){
                word.setCharAt(i, 'a');
                canChange[i] = true;
            }
        }

        // Handle 'F'
        for(int i = 0; i < N; i++){
            if(str1.charAt(i) == 'F'){
                if(isSame(word, i, str2, m)){
                    boolean changed = false;
                    
                    for(int k = i + m - 1; k >= i; k--){
                        if(canChange[k]){
                            word.setCharAt(k, 'b');
                            changed = true;
                            break;
                        }
                    }

                    if(!changed) return "";
                }
            }
        }

        return word.toString();
    }
}