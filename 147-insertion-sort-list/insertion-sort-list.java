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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        List<ListNode> ls = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
           ls.add(curr);
           curr = curr.next;
        }
        Collections.sort(ls,(a,b)->a.val - b.val);
        for(int i=0;i<ls.size()-1;i++){
            ls.get(i).next = ls.get(i+1);
        }
        ls.get(ls.size()-1).next = null;
        return ls.get(0);
    }
}