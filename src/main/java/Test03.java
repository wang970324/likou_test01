import java.util.TreeSet;

public class Test03 {
    public static void main(String[] args) {

    }

    public static int search (int[] nums, int target) {
        // write code here
        int left=0;
        int right=nums.length-1;

        while (left<right){
            int temp=left+(right-left)/2;
            if(nums[temp]<target){
                left=temp+1;
            } else if (nums[temp]>target) {
                right=temp-1;
            }else {
                return temp;
            }
        }
        return -1;
    }

class ListNode {
    int val;
     ListNode next;
     ListNode(int x) {
          val = x;
         next = null;
     }}
    public boolean hasCycle(ListNode head) {
        ListNode cur=head;
        TreeSet<ListNode> set=new TreeSet<>();
        while(cur!=null){
            if(set.contains(cur)){
                return true;
            }
            set.add(cur);
        }
        return false;
    }
}
