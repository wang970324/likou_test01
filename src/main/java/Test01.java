public class Test01 {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,22,33,44,23,222,223,1111,234};
        quickSort(nums,0,nums.length-1);

       for (int i:nums){
           System.out.println(i);
       }
    }
    public static void quickSort(int[] nums,int left,int right){

        if (left<right){
            int temp = quickPrior(nums, left, right);
            quickSort(nums,left,temp-1);
            quickSort(nums,temp+1,right);

        }
    }
    public static int quickPrior(int[] nums,int left,int right){
        int prior=nums[left];
        while (left<right){
            while (left<right&&nums[right]>=prior){
                right--;
            }
            nums[left]=nums[right];

            while (left<right&&nums[left]<=prior){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=prior;
        return left;
    }
}
