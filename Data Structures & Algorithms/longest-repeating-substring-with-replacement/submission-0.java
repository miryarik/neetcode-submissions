class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int max = 0;
        int res = 0;
        HashMap<Character, Integer> freqs = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            freqs.put(s.charAt(j), freqs.getOrDefault(s.charAt(j), 0) + 1);
            if (freqs.get(s.charAt(j)) > max) max = freqs.get(s.charAt(j));

            while (j - i + 1 - max > k) {
                freqs.put(s.charAt(i), freqs.get(s.charAt(i)) - 1);
                i++;
            }
            
            res = Math.max(res, j - i + 1);
            
        }

        return res;
    }
}
