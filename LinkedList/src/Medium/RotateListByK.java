package Medium;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RotateListByK {
    public static void main(String[] args) {

    }

    public static ListNode rotate(ListNode head, int k){
        if(k<=0 || head==null || head.next==null){
            return head;
        }

        ListNode last = head;
        int length = 1;
        while(last.next != null){
            last = last.next;
            length++;
        }

        int rotations = k%length;
        int skip = length - rotations;
        ListNode newLast = head;
        for(int i=0; i<skip-1; i++){
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;

        return head;

    }
}

