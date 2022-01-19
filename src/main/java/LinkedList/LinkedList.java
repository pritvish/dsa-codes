package LinkedList;

public class LinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // to traverse through a linkedlist
    public void traversal(Node head) {

        // temporary assigning head to current cursor
        Node current = head;

        // traversing until the current cursor points null
        while (current != null) {
            System.out.println(current.data);
            // moving cursor to the next node
            current = current.next;
        }
    }

    // to add a data(Node) to a particular position
    public void insert(int data, int pos, Node head) {

        // create a new Node
        Node newNode = new Node(data);

        // if the new Node needs to be added at the beginning of the LinkedList
        if (pos == 0) {
            // now newNode's next pointer will point the same node which head is already pointing
            // head -> existingNode <- newNode.next
            newNode.next = head;
            // the head pointer reassigns itself and points to the newNode
            // head -> newNode| newNode.next -> existingNode
            head = newNode;
        }

        // temporarily assigning head to a node
        // head -> prev | prev.next
        Node prev = head;

        // iterating pos-1 number of times to reach the correct position
        // prev pointer now points to the pos.next node in the LinkedList at the end of iteration
        // prev|prev.next -> pos.next
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }

        // newNode|newNode.next -> prev.next,
        // newNode's next will point to prevNode's next
        newNode.next = prev.next;
        // prev.next(lastNode pointer) -> newNode|newNode.next
        prev.next = newNode;
    }

    // to delete a Node from a given position
    public void delete(Node head, int pos) {

        // the current head pointer reassigns itself to the next Node of head
        // thus leaving the previous head without pointer
        if (pos == 0) {
            head = head.next;
            return;
        }

        // temporary pointer prev is created for traversal
        Node prev = head;

        // iterated and reached the node before the deletion position
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }

        // skips the intermediate node and points to the node after that
        prev.next = prev.next.next;

    }
}
