import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[] arr=new int[n];
        int result=0;
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=sc.nextInt();
        }

        int flag=0;
        for (int i=0;i<arr.length;i++){
            for (int j=i;j< arr.length;j++){
                flag=0;
                HashMap<Integer,Integer> map=new HashMap<>();
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
                for (Map.Entry<Integer,Integer> set:map.entrySet()){
                    if(set.getValue()>=m){
                        result++;
                        flag=1;
                        break;
                    }
                }
                if(flag==1){
                    break;
                }


            }

        }
        System.out.println(result);

    }
}
