package suanfa;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums={34,54,33,2,56,32,12,21,20};
        quickSort(nums,0,nums.length-1);//调用快排方法
        for (int i:nums){
            System.out.print(i+" ");
        }
    }
    public static void quickSort(int[] nums,int left,int right){
        if(left<right){
            int location=firstSort(nums,left,right);//一次快排，确定一个元素位置，并返回这个确定元素的下标
            quickSort(nums,left,location-1);//左
            quickSort(nums,location+1,right);//右
        }


    }

    public static int firstSort(int[] nums,int left,int right){
        int prior=nums[left];//选取枢纽元素

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
        nums[left]=prior;//记得把确定好的枢纽元素放进去
        return left;
    }

}
