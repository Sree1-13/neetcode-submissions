class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seq = new HashSet<>();
        int maxWindow = 0;
        int window = 0;

        for(int right=0;right<s.length();right++){

            while(seq.contains(s.charAt(right))){
                seq.remove(s.charAt(window));
                window++;
            }

            seq.add(s.charAt(right));

            maxWindow = Math.max(right-window+1,maxWindow);
        }
        
        return maxWindow;
    }
}
