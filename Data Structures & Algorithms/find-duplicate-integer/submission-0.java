class Solution {
    public int findDuplicate(int[] nums) {
        int currentIdx = 0;
        while (true) {
            int nextIdx = nums[currentIdx];
            if (nextIdx == -1) {
                return currentIdx;
            }

            nums[currentIdx] = -1;
            currentIdx = nextIdx;
        }

    }
}
