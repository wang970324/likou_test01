package lianbiao;

import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4=new ListNode(4,listNode5);
        ListNode listNode3=new ListNode(3,listNode4);
        ListNode listNode2=new ListNode(2,listNode3);
        ListNode listNode1=new ListNode(1,listNode2);

        ListNode cur=listNode1;
        for(int i=0;i<5;i++){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }

        System.out.println("逆转指定区间链表：");
        ListNode res = reversList2(listNode1, 2, 4);
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }

    }
    public static ListNode reversList2(ListNode head,int left,int right){
        ListNode dummy=new ListNode(-1,null);
        dummy.next=head;
        ListNode cur=dummy;

        for(int i=0;i<left-1;i++){
            cur=cur.next;
        }

        ListNode temp1=cur;

        ListNode temp2=cur.next;

        for(int i=left-1;i<right;i++){
            cur=cur.next;
        }
        ListNode temp3=cur;
        ListNode temp4=cur.next;
        cur.next=null;

        ListNode listNode = reversList1(temp2);
        temp1.next=listNode;
        listNode.next=temp4;
        return dummy.next;
    }
    public static ListNode reversList1(ListNode head){
        ListNode cur=head;
        ListNode dummy=new ListNode(-1,null);

        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=dummy.next;
            dummy.next=cur;
            cur=temp;
        }
        return dummy.next;
    }
}
class ListNode{
    int val;
    ListNode next;

    ListNode(){

    }

    ListNode(int val){
        this.val=val;
    }

    ListNode (int val,ListNode next){
        this.val=val;
        this.next=next;
    }

}
