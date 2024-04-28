package meituan;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        //小美有一个长为 n 的字符串 s，她希望删除尽可能少的字符，使得字符串不含长度为偶数的回文子串。
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int[] dp=new int[n];

        for (int i=0;i<n;i++){
            dp[i]=1;
            if(i>0&&s.charAt(i)==s.charAt(i-1)){
                dp[i]=2;
            }
        }

        for(int len=3;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                if(s.charAt(i)==s.charAt(i+len-1)&&dp[i+1]==len-2){
                    dp[i]=len;
                }
            }
        }

        int resulut=0;
        for (int i=1;i<n;i++){
            if(dp[i]%2==0){
                resulut++;
                i++;
            }
        }
        System.out.println(resulut);
    }
}
