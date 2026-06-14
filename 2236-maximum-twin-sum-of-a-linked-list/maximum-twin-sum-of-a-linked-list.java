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
        // ListNode curr = head;
        // List<Integer> ls = new ArrayList<>();
        // while(curr!=null){
        //    ls.add(curr.val);
        //    curr = curr.next;
        // }
        // int result = 0;
        // int i = 0;
        // int j = ls.size()-1;
        // while(i<j){
        //     result = Math.max(result,ls.get(i)+ls.get(j));
        //     i++;
        //     j--;
        // }
        // return result;

        Stack<Integer> st = new Stack<>();
        ListNode curr = head;
        while(curr!=null){
            st.push(curr.val);
            curr = curr.next;
        }
        int N = st.size();
        curr = head;
        int count = 1;
        int result = 0;
        while(count <= N/2){
            result = Math.max(result,curr.val+st.peek());
            curr = curr.next;
            st.pop();
            count++;
        }
        return result;

    }
}