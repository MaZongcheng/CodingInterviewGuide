package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- GetMinStack2
 * @version 2017/07/29 14:45
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Stack;

/**
 * 题目：实现一个特殊的栈，实现返回站内最小值的操作
 *
 * 要求：
 *  1、pop、push、getMin的复杂m   度都是O(1)
 *  2、设计的栈类型可以使用现成的栈结构
 *
 * 难度：￥
 */

public class _1_GetMinStack2 {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public _1_GetMinStack2() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int item){
        if(this.minStack.isEmpty()){
            this.minStack.push(item);
        }else if(item < this.getMin()){
            this.minStack.push(item);
        }else{
            int newMin = this.minStack.peek();
            this.minStack.push(newMin);
        }
        this.dataStack.push(item);
    }

    public Integer pop(){
        if(this.dataStack.isEmpty()){
            throw new RuntimeException("This stack is empty!");
        }
        this.minStack.pop();
        return this.dataStack.pop();
    }

    public Integer getMin(){
        if(this.minStack.isEmpty()){
            throw new RuntimeException("This stack is empty!");
        }
        return minStack.peek();
    }

}
