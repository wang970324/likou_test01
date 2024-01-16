package suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main03 {
    public static void main(String[] args) {
        //两个列表组成字典
        List<String> list1=new ArrayList<>();
        list1.add("张三");
        list1.add("李四");
        list1.add("王五");
        list1.add("赵六");
        List<Integer> list2=new ArrayList<>();
        list2.add(16);
        list2.add(22);
        list2.add(23);
        list2.add(20);

        HashMap<String,Integer> hashMap=new HashMap<>();

        for (int i=0;i<list1.size();i++){
            hashMap.put(list1.get(i),list2.get(i));
        }
        System.out.println(hashMap);

    }
}
