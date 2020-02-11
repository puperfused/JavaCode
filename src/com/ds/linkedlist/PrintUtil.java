package com.ds.linkedlist;

public class PrintUtil {
    public static void printList(LLNode head) {
        LLNode temp = head;
        while(temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}
