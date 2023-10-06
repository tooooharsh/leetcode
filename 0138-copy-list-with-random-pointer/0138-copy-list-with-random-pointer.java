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

    if (head == null) {
        return null;
    }

    Node current = head;
    while (current != null) {
        Node duplicate = new Node(current.val); //make a dummy node
        duplicate.next = current.next; // dummy ka next = current ka next
        current.next = duplicate;// current ka next = dummy node
        current = duplicate.next; //current ko aage khiskaya
    }

    
    current = head;
    while (current != null) {
        if (current.random != null) {
            current.next.random = current.random.next; //assign the algo
        }
        current = current.next.next;
    }

    
    current = head;
    Node newHead = head.next;
    Node newCurrent = newHead;
    while (current != null) {
        current.next = current.next.next; //dono list ko alag kiya
        current = current.next;
        if (current != null) {
            newCurrent.next = newCurrent.next.next;
            newCurrent = newCurrent.next;
        }
    }

    return newHead;
}
        
    
}