class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> ht= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(! ht.add(nums[i])) return true;
        }
        return false;
    }
}