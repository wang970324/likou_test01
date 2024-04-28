package wangyi;

public class Test01 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int l=1,r=3;

        int left=0;
        int right=-1;
        int temp=-1;

        for(int i=0;i<l;i++){
            left++;
        }

        right=left+1;
        temp=right+1;

        while(left<r){
            int num=nums[right];
            nums[right]=nums[left];
            nums[left]=num;

            left=right;
            right=temp;
            temp++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
