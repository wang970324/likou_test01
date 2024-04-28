package xiecheng;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int res=0;

        int i=0;
        while (i<str.length()-1){
            if(str.charAt(i)=='y'&&str.charAt(i+1)=='u'){
                res++;
            }
            i=i+1;
        }
        System.out.println(res);
    }
}
