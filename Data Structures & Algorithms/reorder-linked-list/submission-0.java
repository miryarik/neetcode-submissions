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
        // find the halves
        // separate the second half
        // and reverse it
        // merge the two halves
        var slow = head;
        var fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // the second half, which is to be reversed
        // starts on slow.next
        var second = slow.next;
        slow.next = null;
        ListNode prev = null;

        while (second != null) {
            var next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // reversal ends with second on null
        // and prev at the first node of the reversed part
        // move second back to prev
        second = prev;
        var first = head;

        // now merge
        while (second != null) {
            var temp1 = first.next;
            var temp2 = second.next;

            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
        }
    }
}
