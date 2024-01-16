package chanting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        boolean b = IsContatined(s2, s1);
        System.out.println(b);
    }

    public static boolean IsContatined(String s1,String s2){
        if(s2.length()<s1.length()){
            return false;
        }
        //因为全是小写字母，共有26种可能，用数组存储比用map存储方便。
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        //nums1存s1串的所有字符及对应次数,nums2存s2的一个窗口长度字符种类及次数
        for(int i = 0;i < s1.length();i++){
            nums1[s1.charAt(i)-'a']++;
            //这里是第一个窗口的字符种类及次数
            nums2[s2.charAt(i)-'a']++;
        }
        int j = s1.length();
        for(int i = 0;i < s2.length()-s1.length();i++){
            //i表示当前窗口的第一个字符,j表示该窗口外的第一个字符
            //判断两个数组是否匹配,匹配则返回true
            if(matches(nums1,nums2)){
                return true;
            }
            //不匹配，则窗口右移一位,即i对应的字符次数减1,j对应的字符次数加1。i,j右移
            nums2[s2.charAt(i)-'a']--;
            nums2[s2.charAt(j++)-'a']++;
        }
        return false;
    }
    private static boolean matches(int[] nums1, int[] nums2) {
        for(int i = 0;i < 26;i++){
            if(nums1[i]!=nums2[i]){
                return false;
            }
        }
        return true;
    }
}
