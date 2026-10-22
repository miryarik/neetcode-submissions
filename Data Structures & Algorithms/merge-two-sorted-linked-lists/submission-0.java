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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        var last = merged;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                last.next = list1;
                list1 = list1.next;
            }
            else {
                last.next = list2;
                list2 = list2.next;
            }

            last = last.next;
        }

        if (list1 != null) {
            last.next = list1;
        }
        else {
            last.next = list2;
        }

        return merged.next;
    }
}