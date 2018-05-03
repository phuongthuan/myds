package ds.npt.stack;

public class Runner {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Empty status: " + stack.isEmpty());
        stack.push(4);
        stack.show();
        stack.push(5);
        stack.show();
        stack.push(8);
        stack.show();
        stack.push(2);
        stack.show();
        stack.push(1);
        stack.show();
        System.out.println("================");

        stack.pop();
        stack.show();
        stack.pop();
        stack.show();
        stack.pop();
        stack.show();
        stack.pop();
        stack.show();
        stack.pop();
        stack.show();
//        System.out.println("Size is: " + stack.size());
//        System.out.println("Empty status: " + stack.isEmpty());
//        System.out.println("Get number: " + stack.peek());
    }
}
