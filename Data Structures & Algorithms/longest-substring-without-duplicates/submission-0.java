class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left  = 0;
        int max = 0;
        HashMap<Character, Integer> seen = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (seen.containsKey(current)) {
                int idx = seen.get(current) + 1;
                left = Math.max(idx, left);
            }

            seen.put(current, right);
            max = Math.max(right - left + 1, max);
        }

        return max;
    }
}
