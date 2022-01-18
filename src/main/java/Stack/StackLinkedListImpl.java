package Stack;

public class StackLinkedListImpl implements Stack {

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    // the top pointer for the Stack
    Node head;
    // holds the size of the stack at any given period
    int size;

    // constructor to initialize a new Node with head pointing to null and zero size
    public StackLinkedListImpl() {
        head = null;
        size = 0;
    }

    //pushes data into the stack
    @Override
    public boolean push(int data) {

        //create a new node with data
        // head -> null
        Node temp = new Node(data);
        // temp.next which was pointing to null is now pointing to head pointer
        // temp -> temp.next <-head
        temp.next = head;
        // size is incremented as a new data is inserted
        size++;
        // head which was pointing the temp.next is now pointing temp
        // head -> temp -> temp.next -> null
        head = temp;
        System.out.println(data + " is pushed into the stack");
        return true;
    }

    // removes data from the top pointer and decrements the top
    @Override
    public int pop() throws Exception {
        if (head == null) {
            throw new Exception("Stack underflow -> stack is empty");
        } else {
            // to store the current data which is popped
            int poppedData = head.data;
            // head/top pointer is pointing the next node of head node
            head = head.next;
            // size is decremented
            size--;
            System.out.println(poppedData + " is pushed out of the stack");
            return poppedData;
        }
    }

    // to get the data which head is currently pointing to
    @Override
    public int peek() throws Exception {
        if (head == null) {
            throw new Exception("Stack underflow -> stack is empty");
        } else {
            // returns the data which head is pointing currently
            return head.data;
        }
    }

    // to check if the Stack is empty
    @Override
    public boolean isEmpty() {
        return head==null;
    }
}

class StackLinkedListImplDriver {
    public static void main(String[] args) throws Exception {
        Stack s = new StackLinkedListImpl();
        s.push(2);
        s.push(6);
        s.push(7);
        s.pop();
        s.push(9);
        s.push(1);
        s.pop();
        System.out.println("Data at the top is "+s.peek());
    }
}