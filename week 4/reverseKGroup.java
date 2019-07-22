/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) {
            return head; 
        }
        int counter = 0; 
       
        ListNode newNode = new ListNode(0);
        newNode.next = head; 
        ListNode temp = newNode; 
        while(head!= null) {
            counter++;
            if(counter % k == 0) {
                temp = reverseK(temp, head.next);
                head = temp.next; 
            }
            else {
                head = head.next; 
            }
            
            
        }
        return newNode.next; 
    }
    
    public ListNode reverseK(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode current = start.next; 
        ListNode next = null; 
        
        ListNode ret = current; 
        while(current!= end) {
            next = current.next;
            current.next = prev; 
            
            prev = current; 
            current = next; 
        }
        start.next = prev;
        ret.next = current; 
        return ret; 
    }
}