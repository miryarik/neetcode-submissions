class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freqs1 = new int[26];
        int[] freqs2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freqs1[s1.charAt(i) - 'a']++;
            freqs2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (freqs1[i] == freqs2[i]) {
                matches++;
            }
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;

            int idx = s2.charAt(right) - 'a';
            freqs2[idx]++;

            if (freqs1[idx] == freqs2[idx]) matches++;
            else if (freqs1[idx] + 1 == freqs2[idx]) matches--;

            idx = s2.charAt(left) - 'a';
            freqs2[idx]--;
            if (freqs1[idx] == freqs2[idx]) matches++;
            else if (freqs1[idx] - 1 == freqs2[idx]) matches--;

            left++;
        }

        return matches == 26;
    }
}
