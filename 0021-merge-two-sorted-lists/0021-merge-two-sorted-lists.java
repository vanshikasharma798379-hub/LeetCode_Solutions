/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) 
        {
            return list2;
        }
        if(list2 == null)
        {
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode i = list1;
        ListNode j = list2;
        ListNode t = dummy;
        while(i!=null && j!=null)
        {
            if(i.val<=j.val)
            {
                t.next = i;
                i = i.next;
                t = t.next;
            }
            else
            {
                t.next = j;
                j = j.next;
                t = t.next;
            }
           
        }
         if(i==null)
            {

                t.next = j;
            }
            else
            {
                t.next = i;
            }
        return dummy.next;
        
    }
}