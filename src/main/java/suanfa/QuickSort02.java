package suanfa;

public class QuickSort02 {
    public static void main(String[] args) {
        int[] nums={13,23,22,34,21,56,26,29,100,300,150};
        quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }

    public static void quickSort(int[] nums,int left,int right){
        if(left<right){
            int temp = oneSort(nums, left, right);
            quickSort(nums,left,temp-1);//左
            quickSort(nums,temp+1,right);
        }

    }
    public static int oneSort(int[] nums,int left,int right){
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
