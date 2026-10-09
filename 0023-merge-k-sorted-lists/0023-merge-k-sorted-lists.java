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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0)
        {
            return null;
        }
        ArrayList<ListNode> arr = new ArrayList<>();
        for(ListNode m :lists){
            arr.add(m);
        }
        while(arr.size()>1)
        {
            ListNode a= arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            ListNode b = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            ListNode c = merge(a , b);
            arr.add(c);
        }  
        return arr.get(0);      
    }
    ListNode merge( ListNode a , ListNode b)
    {
        ListNode d = new ListNode(-1);
        ListNode t1 = a;
        ListNode t2 = b;
        ListNode t = d;
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
        return d.next;

    }
}