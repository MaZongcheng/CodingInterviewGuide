package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- GetMinStack2
 * @version 2017/07/29 14:45
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Stack;

/**
 * ��Ŀ��ʵ��һ�������ջ��ʵ�ַ���վ����Сֵ�Ĳ���
 *
 * Ҫ��
 *  1��pop��push��getMin�ĸ���m   �ȶ���O(1)
 *  2����Ƶ�ջ���Ϳ���ʹ���ֳɵ�ջ�ṹ
 *
 * �Ѷȣ���
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
