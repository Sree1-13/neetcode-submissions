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

    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode temp = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse the second half
        ListNode second = slow.next;
        slow.next = null;              // split the list
        ListNode prev = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // 3. merge the two halves alternately
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode f = first.next, s = second.next;
            first.next = second;
            second.next = f;
            first = f;
            second = s;
        }


    }
}
