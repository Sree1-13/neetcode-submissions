class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> greaterEle = new ArrayDeque<>();
        int[] result = new int[nums1.length];

        for(int num: nums2) {
            while(!greaterEle.isEmpty() && greaterEle.peek()<num){
                map.put(greaterEle.pop(),num);
            }
            greaterEle.push(num);
        }

        for(int i=0;i<nums1.length;i++){
            result[i] = map.getOrDefault(nums1[i],-1);
        }

        return result;
    }
}