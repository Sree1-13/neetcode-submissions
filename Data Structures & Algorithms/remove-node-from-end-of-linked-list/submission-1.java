class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy, slow = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}