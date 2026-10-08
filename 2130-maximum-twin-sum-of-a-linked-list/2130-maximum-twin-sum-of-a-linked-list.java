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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode a = slow.next;
        slow.next = null;
        ListNode curr = a;
        ListNode prev = null;
        ListNode f = null;
        while(curr!=null)
        {
            f = curr.next;
            curr.next = prev;
            prev =curr;
            curr = f;
        }
        ListNode t1 = head;
        ListNode t2 = prev;
        int sum =0;
        int max = 0;
        while(t1 != null && t2 != null)
        {
            sum = t1.val+t2.val;
            t1 = t1.next;
            t2 = t2.next;
            max = Math.max(max , sum);
        } 
        return max;
              
    }
}