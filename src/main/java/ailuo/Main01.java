package ailuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main01 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;
        int res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for(int q=i;q<=j;q++){
                    sum+=nums[q];
                }
                if(sum==k){
                    res++;
                }
            }
        }
        System.out.println(res);



    }
    public static int[] sum(int[] nums,int target){
        int[] res=new int[2];
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(hashMap.containsKey(temp)){
                res[0]=hashMap.get(temp);
                res[1]=i;
                break;
            }
            hashMap.put(nums[i],i );
        }
        return res;
    }

    public static int sumAddone(int[] digits){

        int num=0;
        int count=0;
        for (int i=digits.length-1;i>=0;i--){
            num=num+digits[i]*10^count;
            count++;
        }
        num++;

        for (int i = digits.length-1; i >=0; i--) {

        }
        return 0;
    }



}
