package ds.npt.stack;

public class Runner {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(4);
        stack.push(5);
        stack.push(8);
        stack.push(2);

        stack.show();

        System.out.println("Pop number: " + stack.pop());
        stack.show();
        System.out.println("Get number: " + stack.peek());

    }
}
