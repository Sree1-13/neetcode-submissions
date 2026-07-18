class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int longest = 0; //To store the longest sequence
        for(int n : nums) {
            hs.add(n);
        }

        for(int n : hs) {
            int length = 1;
            while (hs.contains(n + length)) {
                length++;
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }
}
