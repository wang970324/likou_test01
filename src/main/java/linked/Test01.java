package linked;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test01 {
    public static void main(String[] args) {
        ListNode cur1=new ListNode(3);
        ListNode cur2=new ListNode(2);
        ListNode cur3=new ListNode(0);
        ListNode cur4=new ListNode(4);
        cur1.next=cur2;
        cur2.next=cur3;
        cur3.next=cur4;
        //cur4.next=cur2;







    }
    public static boolean hasCycle(ListNode head) {
        ListNode cur=head;
        Set<ListNode> set=new TreeSet<>();
        while (cur!=null){
            if(set.contains(cur)){
                return true;
            }
            set.add(cur);
            cur=cur.next;
        }
        return false;
    }
}
