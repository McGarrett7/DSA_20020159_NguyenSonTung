package Week5;

import java.util.Scanner;
import java.util.Stack;

public class QueueTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int q = sc.nextInt();

            switch (q) {
                case 1:
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
            }
        }
    }

    public static class MyQueue<T> {
        Stack<T> stack1 = new Stack<>();
        Stack<T> stack2 = new Stack<>();

        public void enqueue(T n) {
            stack1.push(n);
        }

        public void dequeue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            stack2.pop();
        }

        public T peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();

        }
    }
}



