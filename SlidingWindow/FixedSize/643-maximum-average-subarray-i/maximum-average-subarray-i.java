class Solution {
    /**
     * Using Sliding Window (Fixed Size) Technique
     *
     * TC: O(N)
     * SC: O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        double maxAvg = (double) Integer.MIN_VALUE;
        double sum = 0d;
        while (j < n) { // TC: O(N)
            sum += nums[j];
            if (j - i + 1 < k) {
                // keep adding nums[j] till sliding window size is met
                j++;
            } else if (j - i + 1 == k) {
                // when the sliding window size is met, capture the result
                double currentAvg = sum / k;
                maxAvg = Math.max(maxAvg, currentAvg);
                // remove calculation from nums[i]
                sum -= nums[i];
                // slide the next window to maintain it's size
                i++;
                j++;
            }
        }
        return maxAvg;
    }
}
