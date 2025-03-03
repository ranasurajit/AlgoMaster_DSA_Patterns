class Solution {
    /**
     * Using Sliding Window (Fixed Size) Technique and Hashing Approach
     *
     * TC: O(N + K)
     * SC: O(26) ~ O(1)
     */
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();
        int[] chars = new int[26]; // SC: O(26)
        for (int i = 0; i < k; i++) { // TC: O(K)
            chars[s1.charAt(i) - 'a']++;
        }
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        while (j < n) { // TC: O(N)
            chars[s2.charAt(j) - 'a']--;
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (isAllCharsZero(chars)) {
                    return true;
                }
                // remove all calculations before sliding to next window
                chars[s2.charAt(i) - 'a']++;
                // slide to next window by maintaining window size k
                i++;
                j++;
            }
        }
        return false;
    }

    /**
     * TC: O(26) ~ O(1)
     * SC: O(1)
     */
    private boolean isAllCharsZero(int[] chars) {
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
