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
    public ListNode mergeKLists(ListNode[] lists) {
        // early returns
        if (lists == null || lists.length < 1) return null;
        // while the lists are not unified
        // keep picking pairs of lists
        // and merging them
        while (lists.length > 1) {
            List<ListNode> merged = new ArrayList<>();

            for (int i = 0; i < lists.length; i += 2) {
                var l1 = lists[i];
                var l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                merged.add(merge(l1, l2));
            }

            lists = merged.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    private ListNode merge (ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        var current = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return result.next;
    }
}
