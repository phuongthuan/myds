package ds.npt.stack;

public class Stack {

    int stack[] = new int[5];
    int top = 0;

    /**
     * Insert value at top of stack.
     */
    public void push(int data) {

        if (top == 5) {
            System.out.println("Stack is full!");
        } else {
            stack[top] = data;
            top++;
        }
    }

    /**
     * Remove value at top of stack.
     */
    public int pop() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            top--;
            data = stack[top];
            stack[top] = 0;
        }
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
     * Get size of stack.
     */
    public int size() {
        return top;
    }

    /**
     * Check stack is empty.
     */
    public boolean isEmpty() {
        return top <= 0;
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
