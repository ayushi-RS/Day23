class Solution {
    public int findDuplicate(int[] nums) {
        
        
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow!=fast);      //o(n)
        
        slow = nums[0];
         
        while(slow!=fast){             //O(n)
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}