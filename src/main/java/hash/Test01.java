package hash;

import linked.ListNode;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        int[][] grid={{1,3,1},
                      {1,5,1},
                      {4,2,1}};
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=grid[i][0];
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=grid[0][j];
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0&&j==0){
                    dp[i][j]=grid[i][j];
                } else if (i == 0&&j!=0) {
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                } else if (i!=0&&j==0) {
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }

            }
        }

        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>> hashMap=new HashMap<>();

       for (String str:strs){
           char[] chars = str.toCharArray();
           Arrays.sort(chars);
           String s = String.valueOf(chars);
           if(!hashMap.containsKey(s)){
               hashMap.put(s,new ArrayList<>());
           }
           hashMap.get(s).add(str);
       }
        Set<String> strings = hashMap.keySet();
        Collection<List<String>> values = hashMap.values();
        ArrayList<List<String>> lists = new ArrayList<>(values);
        return lists;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(int num:set){
            int cur=num;
            if(!set.contains(cur-1)){
                while(set.contains(cur+1)){
                    cur++;
                }
                ans=Math.max(ans,cur-num+1);
            }

        }
        return ans;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        return ans;
    }

    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length+1][grid[0].length+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length][grid[0].length];
    }

}
