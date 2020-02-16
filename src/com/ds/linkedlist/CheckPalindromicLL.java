package com.ds.linkedlist;

/**
 *  Recursive approach of checking if the linked list is palindromic or not
 */
public class CheckPalindromicLL {

    Node head;
    Node left;

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void push(int key) {
        Node newNode = new Node(key);
        newNode.next = head;
        head = newNode;
    }

    public boolean isPalindrome(Node right) {
        left = head;
        if(right == null) {
            return true;
        }
        boolean rightResult = isPalindrome(right.next);
        if(rightResult == false) {
            return false;
        }
        boolean compResult = ((right.data == left.data) ? true:false);
        left = left.next;
        return compResult;
    }

    public boolean isPalindromeUtil(Node head) {
        boolean result = isPalindrome(head);
        return result;
    }

    public static void main(String args[]) {
        CheckPalindromicLL llist = new CheckPalindromicLL();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(2);
        llist.push(2);
        llist.push(1);
        boolean ans = llist.isPalindromeUtil(llist.head);
        if(ans) {
            System.out.println("Given list is palindromic");
        } else {
            System.out.println("Not a palindromic string");
        }
    }
}
