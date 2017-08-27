package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- ջջ����
 * @version 2017/08/26 21:31
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Stack;

/**
 * ��Ŀ����ν���һ��ջ�ͳ�������һ��ջ����
 *
 * Ҫ��
 * 1��
 *
 *
 * �Ѷȣ���
 *
 * ��ʱ��20����
 */

public class _5_SortStackByStack {

    public static void main(String[] args){

        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(4);
        stack.add(3);
        stack.add(2);
        stack.add(1);

        stack = sortStackByStack(stack);

    }

    // ���Ž�
    public static void sortStackByStack2(Stack<Integer> stack){

        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static Stack<Integer> sortStackByStack(Stack<Integer> stack){

        int max;
        Stack<Integer> helper = new Stack<>();
        int num = stack.size() - 1;

        while(!stack.isEmpty()){
            max = stack.pop();
            while (!stack.isEmpty()){

                if(max < stack.peek()){
                    helper.add(max);
                    max = stack.pop();
                }
                else
                    helper.add(stack.pop());
            }

            for(int i = 0; i < num;++i){
                stack.add(helper.pop());
            }
            --num;
            helper.add(max);
        }
        return helper;
    }

}
