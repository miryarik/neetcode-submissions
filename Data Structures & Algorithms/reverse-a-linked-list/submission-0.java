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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        Stack<Integer> stack = new Stack<>();
        var current = head;
        
        while (true) {
            stack.push(current.val);
            if (current.next != null)
                current = current.next;
            else break;
        }

        var newHead = new ListNode(stack.pop());
        current = newHead;

        while (!stack.isEmpty()) {
            current.next = new ListNode(stack.pop());
            current = current.next;
        }
        
        return newHead;
    }
}
