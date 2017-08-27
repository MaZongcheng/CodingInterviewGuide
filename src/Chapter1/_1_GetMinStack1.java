package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- GetMInStack1
 * @version 2017/07/29 00:32
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Stack;

/**
 * 题目：实现一个特殊的栈，实现返回站内最小值的操作
 *
 * 要求：
 *  1、pop、push、getMin的复杂度都是O(1)
 *  2、设计的栈类型可以使用现成的栈结构
 *
 * 难度：￥
 */

public class _1_GetMinStack1 {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    _1_GetMinStack1(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer item){
        if(dataStack.isEmpty() || item <= minStack.peek())
            minStack.push(item);
        dataStack.push(item);
    }

    public Integer pop(){
        if(dataStack.isEmpty())
            throw new RuntimeException("The stack is empty!");
        else{
            if(dataStack.peek() == minStack.peek())
                minStack.pop();
        }
        return dataStack.pop();
    }

    public Integer getMin(){
        if(minStack.isEmpty()){
            throw new RuntimeException("The stack is empty!");
        }
        return minStack.peek();
    }
}
