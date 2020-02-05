package com.ds.linkedlist;

class LLNode{
    int data;
    LLNode next;
    LLNode(int data){
        this.data = data;
        next = null;
    }
}

public class MiddleElement {
    public static void main(String args[]){
        LLNode head = new LLNode(10);
        head.next = new LLNode(20);
        head.next.next = new LLNode(30);
        head.next.next.next = new LLNode(40);
        head.next.next.next.next = new LLNode(50);
        int middleElement = findMiddleElement(head);
        System.out.println(middleElement);
    }

    static int findMiddleElement(LLNode head){
        LLNode slow = head;
        LLNode fast = head;
        if(head != null) {
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        if(slow != null){
            return slow.data;
        }
        return -1;
    }
}
