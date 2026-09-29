class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[j], nums[k]));
                    
                    int currentJ = nums[j];
                    while(nums[j] == currentJ && j < k) j++;

                    int currentK = nums[k];
                    while(nums[k] == currentK && j < k) k--;
                }

                else if (sum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }

        return triplets;
    }
}
