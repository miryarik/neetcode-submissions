class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int vol = 0;

        while (left < right) {
            
            if (leftMax < rightMax) {
                left++;
                if (height[left] < leftMax) {
                    int diff = leftMax - height[left];
                    vol += diff;
                } 
                else {
                    leftMax = height[left];
                }
            }
            else {
                right--;
                if (height[right] < rightMax) {
                    int diff = rightMax - height[right];
                    vol += diff;
                }
                else {
                    rightMax = height[right];
                }
            }
        }

        return vol;
    }
}
