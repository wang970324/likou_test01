package xiecheng;

import java.util.*;

public class Main04 {
    static List<List<Integer>> adj;
    static int[] distFromA;
    static int[] distFromB;
    static int diameter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        adj=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int a=bifFind(1,new int[n+1]);
        distFromA=new int[n+1];
        int b=bifFind(a,distFromA);
        distFromB=new int[n+1];
        bifFind(b,distFromB);
        diameter=distFromB[a];

        for (int i = 1; i <=n ; i++) {
            int potent=Math.max(diameter,Math.max(distFromA[i]+1,distFromB[i]+1));
            System.out.println(potent);
        }
    }
    public static int bifFind(int start,int[] dist){
        Arrays.fill(dist,-1);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        dist[start]=0;

        int farthestNode=start;

        while (!queue.isEmpty()){
            int node=queue.poll();
            for(int neighbor:adj.get(node)){
                if(dist[neighbor]==-1){
                    queue.add(neighbor);
                    dist[neighbor]=dist[node]+1;
                    if(dist[neighbor]>dist[farthestNode]){
                        farthestNode=neighbor;
                    }
                }
            }
        }
        return  farthestNode;
    }
}
