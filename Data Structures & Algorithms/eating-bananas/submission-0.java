class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = Arrays.stream(piles).max().getAsInt();
        int res = j;

        while (i <= j) {
            int k = (i + j) / 2;

            int time = 0;

            for (int pile : piles) {
                time += Math.ceil((double) pile / k);
            }

            if (time <= h) {
                // record and look for smaller
                res = k;
                j = k - 1;
            }
            else {
                i = k + 1;
            }
        }

        return res;
    }
}
