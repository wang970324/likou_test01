package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HeBing {
    public static void main(String[] args) {
       List<Integer> list=new ArrayList<>();


    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> list=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int l=intervals[i][0];
            int r=intervals[i][1];
            if(list.size()==0||list.get(list.size()-1)[1]<l){
                list.add(new int[]{l,r});
            }else {
                list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],r);
                int temp=Math.max(list.get(list.size()-1)[1],r);
                list.set(list.size()-1,new int[]{list.get(list.size()-1)[0],temp});

            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
