package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- 由两个栈组成的队列
 * @version 2017/08/02 23:07
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Stack;

/**
 * 题目：编写一个类，用两个栈实现队列。
 *
 * 要求：
 * 1、支持队列的基本操作(add、poll、peek)
 *
 *
 * 难度：￥￥
 *
 * 用时：31分钟 （最优解）
 */

public class _2_TwoStackQueue {

    private Stack<Integer> mStackPush;
    private Stack<Integer> mStackPop;

    _2_TwoStackQueue(){
        mStackPush = new Stack<>();
        mStackPop = new Stack<>();
    }

    public void add(int item){
        mStackPush.push(item);
    }

    public int poll(){
        if(mStackPush.isEmpty() && mStackPop.isEmpty()){
            throw new RuntimeException("The queue is empty!");
        }
        if(mStackPop.isEmpty()){
            while (!mStackPush.isEmpty()){
                mStackPop.push(mStackPush.pop());
            }
        }
        return mStackPop.pop();
    }

    public int peek(){
        if(mStackPush.isEmpty() && mStackPop.isEmpty()){
            throw new RuntimeException("The queue is empty!");
        }
        if(mStackPop.isEmpty()){
            while (!mStackPush.isEmpty()){
                mStackPop.push(mStackPush.pop());
            }
        }
        return mStackPop.peek();
    }

    public boolean isEmpty(){
        if(mStackPush.isEmpty() && mStackPop.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){

        _2_TwoStackQueue queue = new _2_TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.add(11);
        queue.add(22);
        queue.add(33);
        queue.add(44);
        queue.add(55);
        while (!queue.isEmpty()){
            System.out.println(queue.peek());
            System.out.println(queue.poll());
        }
    }
}