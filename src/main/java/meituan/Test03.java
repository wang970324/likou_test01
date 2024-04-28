package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        String colors=sc.next();
        int redCounnt=0;
        int[] redIndices=new int[n];
        for(int i=0;i<n;i++){
            if(colors.charAt(i)=='R'){
                redIndices[redCounnt++]=i;
            }
        }

        int ans=0;
        for(int i=0;i<redCounnt;i++){
            if(arr[redIndices[i]]!=i+1){
                int j=i;
                while (arr[redIndices[j]]!=i+1){
                    j++;
                }
                for(int k=j;k>i;k--){
                    int temp=redIndices[k];
                    redIndices[k]=redIndices[k-1];
                    redIndices[k-1]=temp;
                    ans++;
                }
            }
        }

        for (int i=0;i<n;i++){
            if(colors.charAt(i)=='W'&&arr[i]!=i+1){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);

//        //int whiteCount=0;
//        for(int i=0;i<n;i++){
//            if(colors.charAt(i)=='W'){
//                whiteCount++;
//            }
//        }
//
//
//
//       for(int i=n-1;i>=n-whiteCount;i--){
//           arr[i]=0;
//       }
//        Arrays.sort(arr,0,n-whiteCount);
//
//       for (int i=n-whiteCount;i<n;i++){
//           arr[i]=0;
//       }

        //System.out.println(Arrays.toString(arr));
    }
}
