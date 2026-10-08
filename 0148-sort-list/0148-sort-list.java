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
    public ListNode sortList(ListNode head) {
        if( head==null ||head.next == null)
        {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast  = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(temp);
        return merge(l , r);
        
    }
    public ListNode merge(ListNode head, ListNode temp)
    {
          ListNode dummy = new ListNode(-1);
          ListNode t = dummy;
          ListNode t1 = head;
          ListNode t2 = temp;
          while(t1!=null && t2!=null)
          {
            if(t1.val<=t2.val)
            {
                t.next = t1;
                t1 = t1.next;
                t = t.next;
            }
            else
            {
                t.next = t2;
                t2 = t2.next;
                t = t.next;
            }
        }
        if(t1==null)
        {
            t.next = t2;
        }
        else
        {
            t.next = t1;
        }
        return dummy.next;
    }
   
}