package Stack;


/**
 * Array implementation of a Stack
 */
public class StackArrayImpl implements Stack {

    // declare size for later assignment in constructor (one of the disadvantages)
    int size;
    // declare an array
    int[] ar;
    // pointer
    int top;

    // initialized an array where the value of the top being -1 which denotes the stack is empty
    // size of the array is declared here
    public StackArrayImpl(int size) {
        this.size = size;
        this.top = -1;
        ar = new int[size];
    }

    //pushes data into the stack
    public boolean push(int data) throws Exception {
        //checks if the stack is full or not
        if (top == size - 1) {
            throw new Exception("Stack Overflow -> Stack is full");
        } else {
            // after storing the data in the stack, top is pre-incremented to point the latest entry of stack
            // ++top indicates that the top is being incremented first and then data is pushed to stack
            ar[++top] = data;
            System.out.println(data + " is pushed into the stack");
            return true;
        }
    }

    // removes data from the top pointer and decrements the top
    public int pop() throws Exception {
        //checks if the stack is empty or not
        if (top == -1) {
            throw new Exception("Stack underflow -> stack is empty");
        } else {
            // data present in top is assigned to temp variables to display what is popped out of stack
            // top-- indicates that top is post decremented to reassign the top to previous array index
            int poppedData = ar[top--];
            System.out.println(poppedData + " is pushed out of the stack");
            return poppedData;
        }
    }

    // returns the data which top is currently pointing to
    public int peek() throws Exception {
        //checks if the stack is empty or not
        if (top == -1) {
            throw new Exception("Stack underflow -> stack is empty");
        } else {
            return ar[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class Driver {
    public static void main(String[] args) throws Exception {
        Stack s = new StackArrayImpl(5);
        s.push(4);
        s.push(2);
        s.push(7);
        s.push(8);
        s.push(1);
        s.pop();
        s.push(7);
        System.out.println("top element is "+s.peek());
    }
}
