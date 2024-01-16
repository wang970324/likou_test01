public class Main03 {
    public static void main(String[] args) {
        String s="abcdefg";
        String s1 = reverseStr(s, 2);
        System.out.println(s1);


    }
    public static String reverseStr(String s, int k) {
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i=i+2*k){
            int r=i+k-1;
            reverse(arr,i,Math.min(r,arr.length-1));
        }
        return String.valueOf(arr);

    }
    public static void reverse(char[] arr,int l,int r){

        while(l<r){
            char temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }

    }
}
