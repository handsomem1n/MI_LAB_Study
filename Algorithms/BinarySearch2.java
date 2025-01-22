class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int right = nums.length - 1;
        int mid = (start + right) /2;

        // int start2 = mid+1;
        // int right1 = mid-1;

        while(start <= right){
            mid = (start + right) /2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[start] <= nums[mid]){
                if( (nums[start] <= target) && (target < nums[mid]) ){
                    right = mid -1;
                }
                else{
                    start = mid + 1;
                }
            }

            else {
                if( (nums[mid] < target) && (target <= nums[right]) ) {
                    start = mid + 1;
                }
                else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
