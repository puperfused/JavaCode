package com.random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        if(len == 0) {
            return true;
        }
        st.push(s.charAt(0));
        for(int i=1; i<len; i++) {
            char top;
            if(!st.isEmpty()) {
                top = st.peek();
            } else {
                st.push(s.charAt(i));
                continue;
            }
            if(top == '(' && s.charAt(i) == ')') {
                st.pop();
            } else if(top == '{' && s.charAt(i) == '}') {
                st.pop();
            } else if(top == '[' && s.charAt(i) == ']') {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        if(!st.isEmpty()) {
            return false;
        }
        return true;
    }
}

public class ValidParentheses {
    public static void main(String args[]) {
        Solution test = new Solution();
        String str = "([)";
        boolean result = test.isValid(str);
        System.out.println(result);
    }
}
