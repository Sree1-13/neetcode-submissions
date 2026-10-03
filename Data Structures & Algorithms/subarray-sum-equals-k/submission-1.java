class Solution {
    public int subarraySum(int[] nums, int k) {
        int subArrayCount = 0;
        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        int sum = 0;

        for(int num: nums){
            sum += num;
            subArrayCount += prefixSum.getOrDefault(sum-k,0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum,0)+1);
        }
        return subArrayCount;
    }
}