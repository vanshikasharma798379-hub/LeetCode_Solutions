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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right)
        {
            return head;
        }
        ListNode d =new ListNode(-1);
        ListNode temp = d;
        d.next = head;
        for( int i = 1 ; i<=left-1; i++)
        {
            temp = temp.next;
        }
        ListNode t1 = temp;
        ListNode head1 = t1.next;
        temp = d;
        for(int i =1 ; i<=right ; i++)
        {
            temp = temp.next;
        } 
        ListNode t2 = temp ;
        ListNode head2 = t2.next;
        t1.next =null;
        t2.next = null;
        ListNode c = head1;
        ListNode p =null;
        ListNode f =null;
        while(c!=null)
        {
            f = c.next;
            c.next = p;
            p = c;
            c = f;
        }
        t1.next = p;
        head1.next = head2 ;
        return d.next;

        
    }
}