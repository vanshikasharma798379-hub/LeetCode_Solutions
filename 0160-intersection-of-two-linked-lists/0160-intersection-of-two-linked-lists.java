/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(temp1!=null)
        {
            temp1 =temp1.next;
            len1++;
        }
        while(temp2!=null)
        {
            temp2 =temp2.next;
            len2++;
        }
        ListNode temp3 = headA;
        ListNode temp4 = headB;
        if(len1>len2)
        {
            int diff1 = len1-len2;
            for(int i = 1; i<=diff1; i++)
            {
                temp3 = temp3.next;
            }
        }
        else
        {
            int diff2 = len2-len1;
            for(int i = 1; i<=diff2; i++)
            {
                temp4 = temp4.next;
            }
        }
        while(temp3!=temp4)
        {
            temp3 =temp3.next;
            temp4 = temp4.next;
        }        
        return temp3;
    }
}