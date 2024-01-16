import java.util.Scanner;

public class xiaoxieToDaxie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char c=in.next().charAt(0);
            char convert;
            if(c>='A'&&c<='Z'){
                System.out.println((char) (c+32));
            }else {
                System.out.println(Character.toUpperCase((char)(c-32)));
            }
        }

    }

}
