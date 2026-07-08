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
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;
        ListNode smallls = new ListNode(-1);
        ListNode smallpointer = smallls;
        ListNode largels = new ListNode(-1);
        ListNode largepointer = largels;
        while(curr!=null){
            if(curr.val < x){
               smallpointer.next = curr;
               smallpointer = smallpointer.next;
            }else{
                largepointer.next = curr;
                largepointer = largepointer.next;
            }
            curr = curr.next;
        }
        smallpointer.next = largels.next;
        largepointer.next = null;
        return smallls.next;
    }
}