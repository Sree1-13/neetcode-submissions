class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;

        Map<Character,Integer> charCount = new HashMap<>();
        int maxLength = 0;
        int maxCount = 0;
        int left = 0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            charCount.put(c,charCount.getOrDefault(c,0)+1);
            maxCount = Math.max(charCount.get(c),maxCount);

            while(right-left+1 - maxCount > k){
                charCount.put(s.charAt(left),charCount.get(s.charAt(left))-1);
                left++;
                 
            }

            maxLength = Math.max(maxLength,right-left+1);

        }

        return maxLength;
    }
}
