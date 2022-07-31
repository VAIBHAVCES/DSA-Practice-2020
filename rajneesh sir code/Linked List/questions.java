public class questions {
    public class ListNode {
        int val;
        ListNode next;
      ListNode() {}
       ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public ListNode midnode(ListNode head){

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }

    public ListNode mergeTwoSort(ListNode c1, ListNode c2){

        ListNode dumy= new ListNode(-1);
        while(c1!=null && c2!=null){
                if(c1.val < c2.val){
                    ListNode temp=c1;
                    c1=c1.next;
                    temp.next=null;
                    dumy.next=c1;
                    dumy=dumy.next;



                }else{
                    ListNode temp=c2;
                    c2=c2.next;
                    temp.next=null;
                    dumy.next=c2;
                    dumy=dumy.next;
                    
                }
        } 
        return dumy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null ){
                return head;
        }

        
        ListNode mid = midnode(head);
        if(head==mid)
            return head;
        ListNode temp = mid;
        mid=mid.next;
        temp.next=null;
        return mergeTwoSort(sortList(head) , sortList(mid));
        
    }
    // **********************leetcode 138
    
}