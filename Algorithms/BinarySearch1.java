class Solution {
    public int search(int[] nums, int target) {
        // idea - mid 정하고 반반 씩 쪼개고 mid를 update
        int start = 0;
        int right = nums.length-1;
        int mid = (start + right) / 2;

        while(start <= right){
            if(nums[mid] == target){
                return mid;
            }

            if (nums[mid] > target){
                right = mid-1;
                mid = (start + right) / 2;
            }
            else if(nums[mid] < target){
                start = mid+1;
                mid = (start + right) / 2;
            }
        }
        
        return -1;
    }
}
