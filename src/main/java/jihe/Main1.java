package jihe;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,22);
        map.put(2,33);
        map.put(3,15);
        map.put(4,20);
        map.put(5,14);
        map.put(6,18);

        List<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>=18){
                list.add(entry.getKey());
            }
        }
        System.out.println(list);
    }
}
