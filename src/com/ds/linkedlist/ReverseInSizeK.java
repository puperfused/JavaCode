package com.ds.linkedlist;

import com.ds.linkedlist.LLNode;

public class ReverseInSizeK {
    public static void main(String args[]) {
        LLNode head = new LLNode(10);
        head.next = new LLNode(20);
        head.next.next = new LLNode(30);
        head.next.next.next = new LLNode(40);
        head.next.next.next.next = new LLNode(50);
        head.next.next.next.next.next = new LLNode(60);
        head.next.next.next.next.next.next = new LLNode(70);
        int k = 2;
        head = reverseInSizeK(head, k);
        PrintUtil.printList(head);
    }

    public static LLNode reverseInSizeK(LLNode head, int k) {

        int count = 0;
        LLNode prev = null;
        LLNode curr = head;
        LLNode next = null;
        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null) {
            head.next = reverseInSizeK(next, k);
        }
        return prev;
    }
}


