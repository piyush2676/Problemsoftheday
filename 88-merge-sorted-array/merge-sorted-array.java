class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int gap = nextGap(length);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < length) {
              
                if (left < m && right < m) {
                    if (nums1[left] > nums1[right]) {
                        int temp = nums1[left];
                        nums1[left] = nums1[right];
                        nums1[right] = temp;
                    }
                }
                else if (left < m && right >= m) {
                    if (nums1[left] > nums2[right - m]) {
                        int temp = nums1[left];
                        nums1[left] = nums2[right - m];
                        nums2[right - m] = temp;
                    }
                }
               
                else {
                    if (nums2[left - m] > nums2[right - m]) {
                        int temp = nums2[left - m];
                        nums2[left - m] = nums2[right - m];
                        nums2[right - m] = temp;
                    }
                }
                left++;
                right++;
            }
            gap = nextGap(gap);
        }

       
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
    private int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
}