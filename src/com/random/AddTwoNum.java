package com.random;

import static java.lang.Math.min;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class AddTwoNum {

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        int len1 = 0;
        while(temp != null) {
            len1++;
            temp = temp.next;
        }
        temp = l2;
        int len2 = 0;
        while(temp != null) {
            len2++;
            temp = temp.next;
        }
        int commonlen = min(len2, len1);
        int carry = 0;
        ListNode tempNode = new ListNode(0);
        ListNode res = tempNode;
        for(int i=0; i<commonlen; i++) {
            int sum = l1.val + l2.val + carry;
            carry = (sum/10);
            ListNode node = new ListNode(sum%10);
            res.next = node;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int sum = l1.val + carry;
            carry = (sum) / 10;
            ListNode node = new ListNode(sum%10);
            res.next = node;
            res = res.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            int sum = l2.val + carry;
            carry = (sum) / 10;
            ListNode node = new ListNode(sum%10);
            res.next = node;
            res = res.next;
            l2 = l2.next;
        }
        if(carry > 0) {
            ListNode node = new ListNode(carry);
            res.next = node;
        }
        return tempNode.next;
    }
    public static void main(String args[]) {
        ListNode l1 = new ListNode(0);
        //l1.next = new ListNode(8);
        //l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
        //l2.next.next = new ListNode(5);

        ListNode ans = solution(l1, l2);
        while(ans != null) {
            System.out.println(ans.val + "->");
            ans = ans.next;
        }
    }
}
