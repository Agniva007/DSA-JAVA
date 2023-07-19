package WEEK1;


public class MergeTwoSortedList {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        // for storing head reference
        ListNode result = new ListNode();
        //  dummy node for travelling
        ListNode node = result;

        if(list1 == null && list2 == null)return null;
        if(list1==null && list2 != null)return list2;
        if(list1!=null && list2 == null)return list1;

        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                node.next = temp1;
                temp1 = temp1.next;
            }else{
                node.next = temp2;
                temp2 = temp2.next;
            }

            node = node.next;
        }

        if(temp1!=null){
            node.next = temp1;
        }
        if(temp2!=null){
            node.next = temp2;
        }

        // now return the reference.next bcuz merged list stars from .next
        return result.next;
    }
}
