package com.ds.linkedlist;

import com.ds.linkedlist.LLNode;

public class ReverseLL {
    public static void main(String args[]) {
        LLNode head = new LLNode(10);
        head.next = new LLNode(20);
        head.next.next = new LLNode(30);
        head.next.next.next = new LLNode(40);
        head = reverseLL(head);
        printReverseList(head);

    }

    public static void printReverseList(LLNode head) {
        LLNode temp = head;
        while(temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public static LLNode reverseLL(LLNode head) {
        LLNode prev = null;
        LLNode curr = head;
        LLNode next = null;
        while(curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
