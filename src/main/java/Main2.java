import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums=new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(0);
        nums.add(4);
        int longestSubArray = findLongestSubArray(nums);
        System.out.println(longestSubArray);

    }
    public static String reverse(String s1,String s2){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            if(s2.indexOf(c)!=-1){
                sb.append(new StringBuilder(String.valueOf(c)).reverse());
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public Boolean palindromeNumber(int number) {

        //write your code here......
        String numStr=String.valueOf(number);
        if(numStr.charAt(0)==numStr.charAt(4)&&numStr.charAt(1)==numStr.charAt(3)){
            return true;
        }else {
            return false;
        }

    }

    public static int findLongestSubArray (ArrayList<Integer> nums) {
      int n=nums.size();
      int neg=0,pos=0,first=-1;
      int ans=0;
      for (int i=0;i<n;i++){
          if(nums.get(i)==0){
              pos=0;
              neg=0;
              first=-1;
          } else if (nums.get(i) > 0) {
              pos++;
          }else {
              if(first==-1){
                  first=i;
              }
              neg++;
          }
          if(neg%2==0){
              ans=Math.max(ans,pos+neg);
          }
      }
      return ans;


    }
}
