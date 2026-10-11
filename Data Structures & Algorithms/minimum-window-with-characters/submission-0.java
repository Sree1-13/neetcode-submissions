class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || t.length()==0) return "";

        int bestLen = Integer.MAX_VALUE;
        int left = 0;
        int bestStart = 0;
        int[] charCount = new int[128];
        int required = t.length();
        for(char c: t.toCharArray()){
            charCount[c]++;
        }

        for(int right=0;right<s.length();right++){
            if(charCount[s.charAt(right)]-- > 0) required--;

            while(required == 0){
                if(right-left+1 < bestLen){
                    bestLen = right-left+1;
                    bestStart = left;
                }
                if(charCount[s.charAt(left)]++ == 0) required++;
                left++;
            }

            
        }

        return bestLen == Integer.MAX_VALUE ?  "" : s.substring(bestStart,bestStart+bestLen);
    }
}
