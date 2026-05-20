class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // int n = A.length;
        // int m = B.length;
        // int[] result = new int[n];
        
        // for(int i=0;i<n;i++){
        //     int count = 0;
        //     for(int j=0;j<=i;j++){
        //        for(int k = 0;k<=i;k++){
        //         if(B[k] == A[j]) count++;
        //        }
        //     }
        //     result[i] = count;  //TC(O(N^3))
                                   //SC(O(1))
        // }
        // return result;
        // int n = A.length;
        // int m = B.length;
        // boolean[] isPresentA = new boolean[n+1];
        // boolean[] isPresentB = new boolean[n+1];
        // int[] result = new int[n];
        // for(int i=0;i<n;i++){
        //     isPresentA[i] = false;
        //     isPresentB[i] = false;
        // }
        // for(int i=0;i<n;i++){
        //     isPresentA[A[i]] = true;
        //     isPresentB[B[i]] = true;
        //     int count = 0;
        //     for(int j=1;j<=n;j++){
        //         if(isPresentA[j] == true && isPresentB[j] == true) count++;
        //     }
        //     result[i] = count;
        // }
        // return result;  TC(O(N^2)) 
                           //SC(O(N))
        HashMap<Integer, Integer> mp = new HashMap<>();

        int count = 0;

        for(int i = 0; i < A.length; i++) {

            if(A[i] == B[i]) {
                mp.put(A[i],
                mp.getOrDefault(A[i], 0) + 2);
                count++;
            }

            else {
                mp.put(A[i],
                mp.getOrDefault(A[i], 0) + 1);

                mp.put(B[i],
                mp.getOrDefault(B[i], 0) + 1);

                if(mp.get(A[i]) == 2) {
                    count++;
                }
                if(mp.get(B[i]) == 2) {
                    count++;
                }
            }

            A[i] = count;
        }

        return A;
    }
}