class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null; 
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }
        
        ListNode head = new ListNode(-1);
        ListNode current = head; 
        while(!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
            if(current.next != null) {
                pq.add(current.next);
            }
        }
        return head.next; 
        
    }
}