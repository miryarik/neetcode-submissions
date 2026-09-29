class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String freq = freqString(str);
            map.putIfAbsent(freq, new ArrayList<>());
            map.get(freq).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public String freqString(String str) {
        int[] freqs = new int[26];

        for(char c : str.toCharArray()) {
            int idx = c - 'a';
            freqs[idx]++;
        }

        return Arrays.toString(freqs);
    }
}
