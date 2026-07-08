class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> key = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(key.containsKey(nums[i])){
                return new int[] {key.get(nums[i]), i};
            }
            key.put(diff, i);
        }

        return new int[] {};
    }
}
