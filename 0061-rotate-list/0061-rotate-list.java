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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        k = k % len;
        if(k == 0){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i =1 ; i<=k; i++)
        {
            fast = fast.next;
        }
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode a = slow.next;
        slow.next = null;
        ListNode t = a;
        while(t.next!=null)
        {
            t = t.next;
        }
        t.next = head;
        return a;
    }
}