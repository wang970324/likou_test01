package meituan;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        //小美拿到了一个n行m列的矩阵，她想知道该矩阵有多少个 2*2 的子矩形满足 1 和 0 的数量相等？
        //
        //输入描述
        //第一行输入两个正整数n,m用空格隔开。
        //接下来的n行，每行输入一个长度为m的 01 串，用来表示矩阵。
        //2 3
        //110
        //010
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] matrix=new int[n][m];
        for (int i = 0; i < n; i++) {
            String row=sc.next();
            for (int j=0;j<m;j++){
                matrix[i][j]=Character.getNumericValue(row.charAt(j));
            }
        }

        int res=0;
        for(int i=0;i<n-1;i++){
            for (int j=0;j<m-1;j++){
                if(check(matrix,i,j)){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
   static boolean check(int[][] matrix,int row,int col){
        int countOne=0;
        int countZero=0;
        for (int i=row;i<=row+1;i++){
            for (int j=col;j<=col+1;j++){
                if(matrix[i][j]==0){
                    countZero++;
                }else if(matrix[i][j]==1){
                    countOne++;
                }
            }
        }
        return countOne==countZero;
    }
}
