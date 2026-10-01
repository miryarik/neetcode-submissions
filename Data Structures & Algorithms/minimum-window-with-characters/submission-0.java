class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freqsT = new HashMap<>();
        HashMap<Character, Integer> freqsWindow = new HashMap<>();
        int[] res = {-1, -1};
        int minLen = Integer.MAX_VALUE;

        for (Character c : t.toCharArray()) {
            freqsT.put(c, freqsT.getOrDefault(c, 0) + 1);
        }

        int need = freqsT.size();
        int have = 0;
    
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            freqsWindow.put(current, freqsWindow.getOrDefault(current, 0) + 1);

            if (freqsT.containsKey(current) && freqsT.get(current).equals(freqsWindow.get(current))) {
                have++;
            }

            while (have == need) {
                int length = right - left + 1;
                if (length < minLen) {
                    minLen = length;
                    res[0] = left;
                    res[1] = right;
                } 

                char leftChar = s.charAt(left);
                freqsWindow.put(leftChar, freqsWindow.get(leftChar) - 1);

                if (freqsT.containsKey(leftChar) && freqsT.get(leftChar) > freqsWindow.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
