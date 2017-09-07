package SchoolRecruit.wangyi2018;

/********************************************************************************
 * CodingInterviewGuide -- ������
 * @version 2017/09/05 18:15
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Arrays;
import java.util.Scanner;

/**
 * ������
 * ʱ�����ƣ�1��
 * �ռ����ƣ�32768K
 *
 * ����Ŀ��
 * С����ʦ�Ƿǳ�������,����Ҫ������ѧ���ڽ������ǰ���ų�
 * һ��,������Ҫ��ѧ��������߲��ݼ���˳�����С���һ��,n��
 * ѧ�����жӵ�ʱ��,С����ʦ����ȥ�������ˡ�ѧ���������л�
 * �ᷴ����,����ѧ���Ǿ�����һ�η��Ķ���,���Ƕ���һ����
 * �еķ��ֵΪÿ����������ѧ����߲�ľ���ֵ�ܺ͡����ڰ�
 * �����˳�����еĶ��еķ��ֵ����С��,���ǵ�Ȼ�������շ�
 * ��ֵ����˳���������жӡ����ڸ���n��ѧ�������,�����
 * ����Щѧ���жӵ������ܵķ��ֵ��С����ʦ����һ������
 * �ð�����
 *
 * ��������:
 * �����������,��һ��һ������n(1 �� n �� 50),��ʾѧ������
 * ��
 * �ڶ���Ϊn������h[i](1 �� h[i] �� 1000),��ʾÿ��ѧ������
 * ��
 * �������:
 * ���һ������,��ʾn��ѧ���жӿ��Ի�õ����ķ��ֵ��
 *
 * ��������ʾ:
 * ����������˳����: 25-10-40-5-25, ��߲����ֵ���ܺ�Ϊ
 * 15+30+35+20=100��
 * �������ķ��ֵ�ˡ�
 * ��������1:
 * 5
 * 5 10 25 40 25
 * �������1:
 * 100
 *
 * ���Ѷȡ�
 *
 * ξ�������
 */

public class ������ {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(MadQueue(array));
        scanner.close();

    }

    public static int MadQueue(int[] array){

        Arrays.sort(array);
        int minIndex = 0;int maxIndex = array.length - 1;
        int Devalues = array[maxIndex--] - array[minIndex++];
        while(maxIndex > minIndex){
            if((minIndex / 2) == 0){
                Devalues += array[maxIndex+1] - array[minIndex];
            }else{
                Devalues += array[maxIndex] - array[minIndex - 1];
            }
            Devalues += array[maxIndex--] - array[minIndex++];
        }
        if(maxIndex == minIndex){
            Devalues += array[minIndex] - array[0] > array[array.length-1] - array[minIndex]
                    ? array[minIndex] - array[0] : array[array.length-1] - array[minIndex];
        }
        return Devalues;
    }

}
