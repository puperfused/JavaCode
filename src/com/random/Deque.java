
import java.util.*;

/** Node structure of Linked List */
class Node {

    Integer val;
    Node next;
    Node prev;
    
    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next, Node prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class DequeDLL {

    private Node front;
    private Node rear;
    private int size;

    DequeDLL() {
    }

    /** Method to check if the Deque is empty or not */
    public boolean isEmpty() {
        return front == null ;
    }

    /** Returns the size of the deque */
    public int size() {
        return size;
    }

    /** Adds the element to the front of the deque */
    public void addFirst(int val) {

        Node newNode = new Node(val);

        if(front != null) {
            newNode.next = front;
            front.prev = newNode;
        }
        front = newNode;

        if(rear == null) {
            rear = front;
        }

        size++;
    }

    /** Adds the element to the rear of the deque */
    public void addLast(int val) {

        Node newNode = new Node(val);

        if(rear != null) {
            rear.next = newNode;
            newNode.prev = rear;
        }
        rear = newNode;

        if(rear == null) {
            front = rear;
        }

        size++;
    }

    /** Removes the element from the front of the deque */
    public int removeFirst() {

        if(isEmpty()) {
            return -1;
        }

        Node firstNode = front;
        front = front.next;

        if(front == null) {
            rear = null;
        } else {
            front.prev = null;
        }

        size--;
        return firstNode.val;

    }

    /** Removes the element from the rear end of the deque */
    public int removeLast() {
        
        if(isEmpty()) {
            return -1;
        }

        Node lastNode = rear;
        rear = rear.prev;

        if(rear == null) {
            front = null;
        } else {
            rear.next = null;
        }

        size--;
        return lastNode.val;
    }

    /** Prints the deque from front */
    public void printDequeFromFront() {

        if(isEmpty()) {
            System.out.println("Deque is empty...");
            return;
        }

        Node temp = front;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}

class Deque {
    public static void main(String args[]) {
        DequeDLL deque = new DequeDLL();
        //deque.printDequeFromFront();
        deque.addFirst(1);
        //deque.printDequeFromFront();
        deque.addFirst(2);
        deque.addFirst(3);
        //deque.printDequeFromFront();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.printDequeFromFront();
        deque.removeFirst();
        deque.printDequeFromFront();
        deque.removeLast();
        deque.printDequeFromFront();
    }
}

