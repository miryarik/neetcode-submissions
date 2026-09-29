class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freqs = new List[nums.length + 1];

        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < freqs.length; i++) {
            freqs[i] = new ArrayList<>();
        }

        for(var entry : map.entrySet()) {
            freqs[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = freqs.length - 1; i >= 0; i--) {
            for (var num : freqs[i]) {
                res[index] = num;
                index++;

                if (index == k) return res;
            }
        }

        return new int[k];
    }
}
