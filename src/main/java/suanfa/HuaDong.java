package suanfa;

import java.util.Arrays;
import java.util.HashMap;

public class HuaDong {
    public static void main(String[] args) {
        String s1="ba";
        String s2="eidbaooo";

        System.out.println(checkInclusion2(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int l1=s1.length();
        int l2=s2.length();
        if(l1>l2){
            return false;
        }
        int[] arr1=new int[26];
        int[] arr2=new int[26];

        for(int i=0;i<l1;i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(arr1,arr2)){
            return true;
        }
        for(int i=l1;i<l2;i++){
            arr2[s2.charAt(i)-'a']++;
            arr2[s2.charAt(i-l1)-'a']--;
            if(Arrays.equals(arr1,arr2)){
                return true;
            }
        }

        return false;
    }

    public static boolean checkInclusion2(String s1,String s2){
        if(s1.length()>s2.length()){
            return false;
        }
        //判断s2中是否包含了s1,s1和s2都是小写字母
        int[] arr1=new int[26];
        int[] arr2=new int[26];

        for (int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(arr1,arr2)){
            return true;
        }
        //滑动窗口
        int left=0;
        for (int right=s1.length();right<s2.length();right++){
            arr2[s2.charAt(left)-'a']--;
            left++;
            arr2[s2.charAt(right)-'a']++;
            if(Arrays.equals(arr1,arr2)){
                return true;
            }
        }
        return false;
    }
    public static boolean isEquals(int[] arr1,int[] arr2){
        if(arr1.length!=arr2.length){
            return false;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=target-nums[i];
            if(map.containsKey(num)){
                res[0]=i;
                res[1]=map.get(num);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max=0;
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),right);
            if(map.containsKey(s.charAt(right))){
                left=Math.max(left,map.get(s.charAt(left))+1);
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
    public int[] twoSum2(int[] nums,int target){
        int[] res=new int[2];
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int path=target-nums[i];
            if(hashMap.containsKey(path)){
                res[0]=hashMap.get(path);
                res[1]=i;
            }
            hashMap.put(nums[i],i);
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for (int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right))+1,left);
            }
            map.put(s.charAt(right),right);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
