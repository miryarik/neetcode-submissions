class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        int left = 0;
        int right = nums1.length;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            int aLeft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int bLeft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;

            int aRight = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int bRight = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;


            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 != 0) {
                    return Math.max(aLeft, bLeft);
                }
                else {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
            }
            else if (aLeft > bRight) {
                right = i - 1;
            }
            else {
                left = i + 1;
            }
        }
        
        return -1;
    }
}
