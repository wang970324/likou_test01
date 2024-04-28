import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Test04 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        map.put(4,40);

        List<Integer> list=new ArrayList<>();

        System.out.println(list);

    }

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i);
            if(c=='('){
                stack.add(')');
            } else if (c == '[') {
                stack.add(']');
            } else if (c == '{') {
                stack.add('}');
            } else if (stack.isEmpty()||stack.pop()!=c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
