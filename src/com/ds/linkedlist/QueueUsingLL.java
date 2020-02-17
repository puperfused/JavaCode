package com.ds.linkedlist;

/**
 *  Program to implement queue with enqueue and dequeue operations using linked list
 */

class QNode {
    int data;
    QNode next;
    QNode(int data) {
        this.data = data;
        next = null;
    }
}

class Queue {
    QNode front, rear;

    public Queue(){
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        QNode newQNode = new QNode(data);
        if(this.rear == null) {         //queue is empty
            this.front = this.rear = newQNode;
            return;
        }
        this.rear.next = newQNode;
        this.rear = newQNode;
    }

    public void dequeue() {
        if(this.front == null) {        //queue is empty
            return;
        }
        if(this.front == this.rear)
            this.front = this.rear = null;
        this.front = this.front.next;
    }

    public void printQueue() {
        QNode temp = this.front;
        while(temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class QueueUsingLL {
    public static void main(String args[]) {
        Queue queue = new Queue();
        for(int i=0; i<6; i++) {
            queue.enqueue(i+1);
        }
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }
}

