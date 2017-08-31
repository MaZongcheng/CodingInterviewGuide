package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- ConstructOriginalQueue
 * @version 2017/08/30 11:03
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * ��Ŀ����
 С��ͬѧ��1��n��n�����ְ���һ����˳�������һ������Q�С��������Զ���Qִ�������³���
 while(!Q.empty())              //���в��գ�ִ��ѭ��
 {
 int x=Q.front();            //ȡ����ǰ��ͷ��ֵx
 Q.pop();                 //������ǰ��ͷ
 Q.push(x);               //��x�����β
 x = Q.front();              //ȡ����ʱ���ͷ��ֵ
 printf("%d\n",x);          //���x
 Q.pop();                 //������ʱ��Ķ�ͷ
 }

 ��ȡ����ͷ��ֵ������ʱ�򣬲���������ǰ��ͷ��
 С��ͬѧ���֣���γ���ǡ�ð�˳�������1,2,3,...,n������С�������㹹���ԭʼ�Ķ��У�����������[ע��ԭ������������5�д�Ӧ��Ϊ3������������]

 ��������:
 ��һ��һ������T��T �� 100����ʾ����������ÿ����������һ����n��1 �� n �� 100000�������������n֮�Ͳ�����200000��
 �������:

 ����ÿ�����ݣ����һ�У���ʾԭʼ�Ķ��С�����֮����һ���ո��������Ҫ����ĩ�������Ŀո�.

 ʾ��1
 ����

 4
 1
 2
 3
 10
 ���

 1
 2 1
 2 1 3
 8 1 6 2 10 3 7 4 9 5
 *
 * �Ѷȣ���
 *
 * ��ʱ��50����
 */

public class _9_ConstructOriginalQueue {

    public static void ConstructOriginalQueue(int n){

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = n; i > 0; i--) {
            queue.add(i);
            int x = queue.poll();
            queue.add(x);
        }

        while (!queue.isEmpty()){
            System.out.print(queue.pollLast() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            ConstructOriginalQueue(nums[i]);
        }

    }

}
