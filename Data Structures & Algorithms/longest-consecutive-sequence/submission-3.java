class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1; //To store the longest sequence
        for(int i=1; i < nums.length;i++) {
           int tempLong = 1;
           while(i<nums.length && (nums[i-1]+1 == nums[i] || nums[i-1] == nums[i])){
            if(nums[i-1] == nums[i]) {
                i++;
                continue;
            }
            tempLong++;
            i++;
           }
           longest = Math.max(longest,tempLong);
        }

        return longest;
    }
}
