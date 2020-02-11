package com.ds.linkedlist;

import java.util.Scanner;
import com.ds.linkedlist.LLNode;

/**
 * Rotate a linked list by k node in counter clock wise direction
 */

public class RotateListByKNode {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        scan.close();
        LLNode head = new LLNode(10);
        head.next = new LLNode(20);
        head.next.next = new LLNode(30);
        head.next.next.next = new LLNode(40);
        head.next.next.next.next = new LLNode(50);
        head.next.next.next.next.next = new LLNode(60);
        //printList(head);
        head = rotateListByKNode(head, k);
        printList(head);
    }

    public static void printList(LLNode head) {
        LLNode temp = head;
        while(temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public static LLNode rotateListByKNode(LLNode head, int k) {
        if(k == 0) {
            return head;
        }
        int count = 1;
        //LLNode kthNode = null;
        LLNode curr = head;
        while(curr != null) {
            if(count == k){
                break;
            }
            count++;
            curr = curr.next;
        }

        LLNode kthNode = curr;
        //head = kthNode.next;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        head = kthNode.next;
        kthNode.next = null;
        //printList(head);
        return head;
    }
}
