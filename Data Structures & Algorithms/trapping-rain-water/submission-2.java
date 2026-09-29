class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int vol = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (height[left] < leftMax) {
                    vol += leftMax - height[left];
                }
                else {
                    leftMax = height[left];
                }   
            }
            else {
                right--;
                if (height[right] < rightMax) {
                    vol += rightMax - height[right];
                }
                else {
                    rightMax = height[right];
                }   
            }
        }
        return vol;
    }
}
