class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;

        // create a set
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        // for each num
        // check if its prev is in set
        // if it is, skip, we'll get to it
        // if not, then its a seq
        // check the next ones and count length
        for (int num : nums) {
            if (!seen.contains(num - 1)) {
                int length = 1;
                int next = num + 1;
                while (seen.contains(next)) {
                    length++;
                    next++;
                }

                if (length > max) max = length;
            }
        }

        return max;

    }
}
