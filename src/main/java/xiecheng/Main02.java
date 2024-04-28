package xiecheng;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        int[] c=new int[n];

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            c[i]=sc.nextInt();
        }

        int i = maxNum(a, b, c, n);
        System.out.println(i);
    }
    public static int maxNum(int[] a,int[] b,int[] c,int n){
        int[] sums=new int[n];
        for(int i=0;i<n;i++){
            sums[i]=a[i]+b[i];
        }
        Arrays.sort(sums);
        Arrays.sort(c);

        int res=0;

        int i=0,j=0;
        while (i<n&&j<n){
            if(sums[i]==c[j]){
                res++;
                i++;
                j++;
            } else if (sums[i] < c[j]) {
                i++;
            }else {
                j++;
            }
        }
        return  res;
    }
}
