package com.algorithm.domain;

import java.util.Stack;

/**
 * Created by mravindran on 01/04/20.
 */
public class StringReverser {

    public String reverse(String input)  {
        Stack<Character> stringValue = new Stack<>();
//        for (int i=0; i < input.length(); i++) {
//            stringValue.add(input.charAt(i));
//        }
if (input  == null) {
    throw new IllegalArgumentException();
}
        for (char ch: input.toCharArray()) {
            stringValue.push(ch);
        }
        String reverseString = "";
        StringBuffer stringBuffer = new StringBuffer();
//        for (int  i= 0 ; i < input.length(); i++) {
//            reverseString += stringValue.pop();
//        }

        while (!stringValue.empty()) {
            //reverseString += stringValue.pop();
            stringBuffer.append(stringValue.pop());
        }

        System.out.println(reverseString);
        System.out.println(stringBuffer.toString());
        return reverseString;
    }
}
