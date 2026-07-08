class Solution {
    public boolean isAnagram(String s, String t) {
        int [] sCount = new int[26];
        int [] tCount = new int[26];

        for(int i=0;i<s.length();i++) {
            sCount[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t.length();i++) {
            tCount[t.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++) {
            if(sCount[i] != tCount[i]) return false;
        }

        return true;
    }
}
