/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> orgToCopy = new HashMap<>();

        var current = head;
        while (current != null) {
            orgToCopy.put(current, new Node(current.val));
            current = current.next;
        }
        
        current = head;
        while (current != null) {
            var copy = orgToCopy.get(current);
            copy.next = orgToCopy.get(current.next);
            copy.random = orgToCopy.get(current.random);
            
            current = current.next;
        }

        return orgToCopy.get(head);
    }
}
