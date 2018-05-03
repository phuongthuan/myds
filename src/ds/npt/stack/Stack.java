package ds.npt.stack;

public class Stack {

    int stack[] = new int[5];
    int top = 0;

    /**
     * Insert value at top of stack.
     */
    public void push(int data) {
        stack[top] = data;
        top++;
    }

    /**
     * Remove value at top of stack.
     */
    public int pop() {
        int data;
        top--;
        data = stack[top];
        stack[top] = 0;
        return data;
    }

    /**
     * Get value at the top of stack.
     */
    public int peek() {
        int data;
        data = stack[top-1];
        return data;
    }

    /**
     * Show all of the value in stack.
     */
    public void show() {
        for (int number : stack) {
            System.out.println("| " + number + " |");
        }
    }
}
