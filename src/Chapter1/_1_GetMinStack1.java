package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- GetMInStack1
 * @version 2017/07/29 00:32
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Stack;

/**
 * ��Ŀ��ʵ��һ�������ջ��ʵ�ַ���վ����Сֵ�Ĳ���
 *
 * Ҫ��
 *  1��pop��push��getMin�ĸ��Ӷȶ���O(1)
 *  2����Ƶ�ջ���Ϳ���ʹ���ֳɵ�ջ�ṹ
 *
 * �Ѷȣ���
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
