package jianzhioffer;

public class Test01 {
    public static void main(String[] args) {
        String path = "a.aef.qerf.bb";
        String s = pathEncryption(path);
        System.out.println(s);


    }
    public static String pathEncryption(String path) {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='.'){
                res.append(' ');
            }else {
                res.append(path.charAt(i));
            }
        }
        return res.toString();
    }
}
