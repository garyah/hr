import java.util.*;

class MyQueue<T> {
    ArrayList<Stack<T>> stacks;
    Stack<T> mainStack;
    Stack<T> spareStack;

    public MyQueue() {
        stacks = new ArrayList<Stack<T>>();
        stacks.add(new Stack<T>());
        stacks.add(new Stack<T>());
        mainStack = stacks.get(0);
        spareStack = stacks.get(1);
    }

    public void enqueue(T value) {
        // System.out.println("enqueue");

        // move all values from main to spare
        // reverses order
        while (!mainStack.isEmpty()) {
            spareStack.push(mainStack.pop());
        }

        // push new value to spare, will be last when values moved back
        spareStack.push(value);

        // move all values from spare to main
        // puts order back
        while (!spareStack.isEmpty()) {
            mainStack.push(spareStack.pop());
        }
    }

    public void dequeue() {
        // System.out.println("dequeue");
        mainStack.pop();
    }

    public T peek() { 
        // System.out.println("peek");
        return mainStack.peek();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}