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
        //     result[i] = count;
        // }
        // return result;
        int n = A.length;
        int m = B.length;
        boolean[] isPresentA = new boolean[n+1];
        boolean[] isPresentB = new boolean[n+1];
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            isPresentA[i] = false;
            isPresentB[i] = false;
        }
        for(int i=0;i<n;i++){
            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;
            int count = 0;
            for(int j=0;j<=n;j++){
                if(isPresentA[j] == true && isPresentB[j] == true) count++;
            }
            result[i] = count;
        }
        return result;
    }
}