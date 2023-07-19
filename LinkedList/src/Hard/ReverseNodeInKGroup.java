package Hard;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseNodeInKGroup {
    public static void main(String[] args) {

    }

    public static ListNode reverse(ListNode head, int k){
        if(k<=1 || head == null) return head;

        ListNode current = head;
        ListNode prev = null;
        int length = getLength(head);
        int count = length/k;
        while(count>0){
            ListNode last = prev;
            ListNode newEnd = current;
            ListNode next = current.next;
            for(int i=0; i<k && current!=null; i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }

            if(last == null){
                prev = head;
            }else{
                last.next = prev;
            }

            newEnd.next = current;
            prev = newEnd;
            count--;
        }

        return head;
    }

    public static int getLength(ListNode head){
        ListNode node = head;
        int count = 1;
        while(node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
}
