package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- 仅用递归函数和栈操作逆序一个栈
 * @version 2017/08/24 10:06
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Stack;

/**
 * 题目：如何仅用递归函数和栈操作逆序一个栈
 *
 * 要求：
 * 1、
 *
 *
 * 难度：￥￥
 *
 * 用时：31分钟 （最优解）
 */

public class _3_ReverseStack {

    private static int getLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.empty()){
            return result;
        }
        else{
            int last = getLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        int size = stack.size();
        while(size > 0){
            stack.push(getLastElement(stack));
            --size;
        }
    }

    public static void reverse_R(Stack<Integer> stack){
        if(stack.empty()){
            return;
        }else{
            int i = getLastElement(stack);
            reverse_R(stack);
            stack.push(i);
        }
    }

    public static void  showStack(Stack<Integer> stack){
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse_R(stack);
        showStack(stack);
    }

}
