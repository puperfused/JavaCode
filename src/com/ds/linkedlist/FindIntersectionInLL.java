package com.ds.linkedlist;

import com.ds.linkedlist.LLNode;

import java.util.HashSet;

public class FindIntersectionInLL {
    public static void main(String args[]) {
        LLNode head1 = new LLNode(10);
        head1.next = new LLNode(20);
        head1.next.next = new LLNode(30);
        head1.next.next.next = new LLNode(40);
        head1.next.next.next.next = new LLNode(50);

        LLNode head2 = new LLNode(70);
        head2.next = new LLNode(80);
        head2.next.next = new LLNode(90);
        head2.next.next.next = head1.next.next.next;

        int val = findIntersectionLL(head1, head2);
        System.out.println("Intersection point " + val);

    }

    public static int findIntersectionLL(LLNode head1, LLNode head2) {
        HashSet<LLNode> s = new HashSet<>();
        while(head1 != null) {
            s.add(head1);
            head1 = head1.next;
        }
        while(head2 != null) {
            if(s.contains(head2)) {
                return head2.data;
            }
            head2 = head2.next;
        }
        return -1;
    }
}
