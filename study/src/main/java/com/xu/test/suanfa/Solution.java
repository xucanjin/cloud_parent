package com.xu.test.suanfa;

import java.util.Stack;

/**
 * @Author: canjin
 * @Date: 2021/3/11
 * 说明:验证括号是否合法
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("(){}"));
        System.out.println(isValid("(}"));
    }
    public static boolean isValid(String s){
        if(s==null||s.length()==0){
            return true;
        }
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'){
                stack.push(c);
            }
            if(c==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }
            if(c=='}'){
                if(stack.isEmpty()||stack.pop()!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
