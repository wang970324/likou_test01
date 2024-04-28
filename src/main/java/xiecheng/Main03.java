package xiecheng;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> array=new ArrayList<>();
        int maxElement=0;

        for (int i = 0; i < n; i++) {
            int element=sc.nextInt();
            array.add(element);
            if(element>maxElement){
                maxElement=element;
            }
        }

        BitSet isPrime=sieveOf(maxElement*2);
        mergePrimes(array,isPrime);
        System.out.println(array.size());
    }
    private static BitSet sieveOf(int max){
        BitSet isPrime=new BitSet(max+1);
        isPrime.set(2,max+1);

        for(int p=2;p*p<=max;p=isPrime.nextSetBit(p+1)){
            if(isPrime.get(p)){
                for (int multiple=p*p;multiple<=max;multiple+=p){
                    isPrime.clear(multiple);
                }
            }
        }
        return isPrime;
    }
    private static void mergePrimes(ArrayList<Integer> array,BitSet isPrime){
        boolean merged=true;
        while (merged){
            merged=false;
            for(int i=0;i<array.size()-1;i++){
                if(isPrime.get(array.get(i))&&isPrime.get(array.get(i+1))){
                    array.set(i,array.get(i)+array.get(i+1));
                    array.remove(i+1);
                    merged=true;
                    break;
                }
            }
        }
    }
    public static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        if(num==2){
            return true;
        }

        if(num%2==0){
            return false;
        }

        for (int i=3;i<=Math.sqrt(num);i+=2){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
