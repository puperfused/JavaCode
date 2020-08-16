import java.util.*;

class StackVO {

    int[] arr;
    private int capacity;
    private int topIdx;
    private static int minElement = Integer.MAX_VALUE;

    StackVO(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.topIdx = -1;
    }
    
    public int getMinimumElement() {
        if(topIdx == -1) {
            return -1;
        }
        return minElement;
    }

    public void push(int x) {

        if(topIdx > capacity) {
            System.out.println("Stack is full");
            return;
        }
        if(topIdx == -1) {
            arr[++topIdx] = x;
            minElement = x;
            return;
        }
        if(x >= minElement) {
            arr[++topIdx] = x;
        } else {
            arr[++topIdx] = (7*x - minElement);
            minElement = x;
        }
    }

    public int pop() {
        if(topIdx == -1) {
            System.out.println("Nothing to pop, Stack is empty");
            return -1;
        }

        int topElement = arr[topIdx];
        if(topElement > minElement) {
            return arr[topIdx--];
        }
        
        int originalValue = minElement;
        int prevMinElement = (7*minElement - arr[topIdx--]);
        minElement = prevMinElement;
        return originalValue;
    }

    public int top() {
        if(topIdx == -1) {
            return -1;
        }
        if(arr[topIdx] < minElement) {
            return minElement;
        }
        return arr[topIdx];
    }

    public void printStack() {
        for(int i=0; i<=topIdx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class GetMinInStack {
    public static void main(String args[]) {
        int arr[] = {3,5,7,2,1,4,6};
        StackVO stack = new StackVO(16);
        stack.pop();
        for(int val : arr) {
            stack.push(val);
        }
        stack.printStack();

        System.out.println("Current top value = " + stack.top());
        System.out.println("Minimum element before pop operation = " + stack.getMinimumElement());
        System.out.println("Popped element = " + stack.pop());
        System.out.println("Minimum element after pop operation = " + stack.getMinimumElement());
        System.out.println();

        System.out.println("Current top value = " + stack.top());
        System.out.println("Minimum element before pop operation = " + stack.getMinimumElement());
        System.out.println("Popped element = " + stack.pop());
        System.out.println("Minimum element after pop operation = " + stack.getMinimumElement());
        System.out.println();
        
        System.out.println("Current top value = " + stack.top());
        System.out.println("Minimum element before pop operation = " + stack.getMinimumElement());
        System.out.println("Popped element = " + stack.pop());
        System.out.println("Minimum element after pop operation = " + stack.getMinimumElement());
        System.out.println();

        System.out.println("Current top value = " + stack.top());
        System.out.println("Minimum element before pop operation = " + stack.getMinimumElement());
        System.out.println("Popped element = " + stack.pop());
        System.out.println("Minimum element after pop operation = " + stack.getMinimumElement());
        System.out.println();

        System.out.println("Current top value = " + stack.top());
        System.out.println("Minimum element before pop operation = " + stack.getMinimumElement());
        System.out.println("Popped element = " + stack.pop());
        System.out.println("Minimum element after pop operation = " + stack.getMinimumElement());
        System.out.println();

        System.out.println("Current top value = " + stack.top());
        System.out.println("Minimum element before pop operation = " + stack.getMinimumElement());
        System.out.println("Popped element = " + stack.pop());
        System.out.println("Minimum element after pop operation = " + stack.getMinimumElement());
        System.out.println();

        System.out.println("Current top value = " + stack.top());
        System.out.println("Minimum element before pop operation = " + stack.getMinimumElement());
        System.out.println("Popped element = " + stack.pop());
        System.out.println("Minimum element after pop operation = " + stack.getMinimumElement());
        System.out.println();

        System.out.println("Current top value = " + stack.top());
        System.out.println("Minimum element before pop operation = " + stack.getMinimumElement());
        System.out.println("Popped element = " + stack.pop());
        System.out.println("Minimum element after pop operation = " + stack.getMinimumElement());
        System.out.println();
    }
}