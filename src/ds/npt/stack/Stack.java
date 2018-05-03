package ds.npt.stack;

public class Stack {
    int maxsize = 2;
    int stack[] = new int[maxsize];
    int top = 0;

    /**
     * Insert value at top of stack.
     */
    public void push(int data) {
        if (size() == maxsize) {
            //Expand size of array.
            expand();
        }
        stack[top] = data;
        top++;
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

            //Reduce size of array by shrink.
            shrink();
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
            System.out.print(number);
        }
        System.out.print("\n");
    }



    private void expand() {
        int length = size();
        //Create new array with double size.
        int newStack[] = new int[maxsize*2];

        //Copy all element from stack array to newStack array.
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        maxsize *= 2;
    }

    private void shrink() {
        int length = size();
        if (length <= (maxsize/2)/2) {
            maxsize = maxsize/2;
            int newStack[] = new int[maxsize];
            System.arraycopy(stack, 0, newStack, 0, length);
            stack = newStack;
        }
    }
}
