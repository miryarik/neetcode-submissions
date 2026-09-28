class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int max = 0;

        while (i < j) {
            int vol = (j - i) * Math.min(heights[i], heights[j]);
            
            if (vol > max) { 
                max = vol;
            }

            if (heights[i] < heights[j]) i++;
            else j--;
        }

        return max;
    }
}
