import java.util.Scanner;

public class niuniuDache {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        minLine(10);

    }
    public static void minLine(int num){
        double res1=num/1;
        double res2=10+num/10;
        if(res1<res2){
            System.out.println("w");
        }else {
            System.out.println("v");
        }
    }
}
