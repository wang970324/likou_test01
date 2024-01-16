package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LunZhuanArray {
    public static void main(String[] args) {
        int[][] nums={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> list = spiralOrder(nums);
        System.out.println(list);
    }
    public static void rotate(int[] nums, int k) {
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[(i+k)%res.length]=nums[i];
        }
        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            if(i==res.length-1){
                System.out.print(res[i]+"]");
            }else {
                System.out.print(res[i]+",");
            }

        }
        System.out.println("-----------------------");
        System.arraycopy(res,0,nums,0,res.length);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] answer=new int[nums.length];
        for(int i=0;i<answer.length;i++){
            int sum=1;
            for(int j=0;j<nums.length;j++){
                if(i==j){
                    continue;
                }
                sum=sum*nums[j];
            }
            answer[i]=sum;
        }
        return answer;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        List<Integer> res=new ArrayList<>();
        while(top<bottom&&left<right){
            for(int i=left;i<right;i++){
                res.add(matrix[top][i]);
            }
            for(int i=top;i<bottom;i++){
                res.add(matrix[i][right]);
            }
            for(int i=right;i>left;i--){
                res.add(matrix[bottom][i]);
            }
            for(int i=bottom;i>top;i--){
                res.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        if(top==bottom){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
        }else if(left==right){
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][left]);
            }
        }
        return res;

    }
}
