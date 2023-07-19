package WEEK2;

import WEEK1.ListNode;

public class MiddleOfLL {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
