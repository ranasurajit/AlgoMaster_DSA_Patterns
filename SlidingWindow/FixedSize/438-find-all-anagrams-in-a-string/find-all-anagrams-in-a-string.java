class Solution {
    /**
     * Using Sliding Window (Fixed Size) Technique and Hashing Approach
     *
     * TC: O(N + K)
     * SC: O(26) ~ O(1)
     */
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        List<Integer> indices = new ArrayList<Integer>();
        int[] chars = new int[26];    // SC: O(26)
        for (int i = 0; i < k; i++) { // TC: O(K)
            chars[p.charAt(i) - 'a']++;
        }
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        while (j < n) { // TC: O(N)
            chars[s.charAt(j) - 'a']--;
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (isAllCharsZero(chars)) { // TC: O(1), SC: O(1)
                    indices.add(i);
                }
                // remove all calculation before sliding to next window
                chars[s.charAt(i) - 'a']++;
                // slide to next window maintaining its size = k
                i++;
                j++;
            }
        }
        return indices;
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
