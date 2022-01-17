package Stack;

public interface Stack {

    boolean push(int data) throws Exception;
    int pop() throws Exception;
    int peek() throws Exception;
    boolean isEmpty();
}
