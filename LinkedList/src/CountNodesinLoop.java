class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}


public class CountNodesinLoop {
    public static void main(String[] args) {

    }

    public static int countNodesinLoop(Node head)
    {
        //Add your code here.

        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp = slow.next;
                int length = 1;
                while(temp != slow){
                    length++;
                    temp = temp.next;
                }
                return length;
            }
        }

        return 0;
    }
}
