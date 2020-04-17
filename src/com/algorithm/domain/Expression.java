package com.algorithm.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mravindran on 01/04/20.
 */
public class Expression {

    public boolean isBalanced(String  input) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        if (input ==  null) {
            throw new IllegalArgumentException();
        }

        for (char ch: input.toCharArray()) {
            if (isLeftExpression(ch)) {
                stack.push(ch);
            }
            if (isRightExpression(ch)) {
                if (stack.empty()) {
                    result = false;
                }
                if (result) {
                    Character top = stack.pop();
                    if (isValidRightLeftExpression(ch, top)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    private boolean isValidRightLeftExpression(char right, Character left) {
        return (right == ')' && left != '(' ) ||  (right == ']' && left != '[' ) || (right == '>' && left != '<' ) || (right == '}' && left != '{' );
    }

    private boolean isRightExpression(char ch) {
        return ch == ')' || ch == ']' || ch == '>' || ch == '}';
    }

    private boolean isLeftExpression(char ch) {
        return ch == '(' || ch == '[' || ch == '<' || ch == '{';
    }
}
