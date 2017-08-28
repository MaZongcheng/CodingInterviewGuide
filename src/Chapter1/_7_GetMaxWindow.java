package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- GetMaxWindow
 * @version 2017/08/28 11:20
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.LinkedList;

/**
 * ��Ŀ���������ֵ���� (p19)
 *
 * Ҫ��
 * ��һ����������arr��һ����СΪw�Ĵ��ڴ����������߻������ұߣ�ÿ�λ���һ��λ�ã����ÿ�δ�������������ֵ
 * ��ʵ��һ��������
 * �� ���룺��������arr�����ڴ�С w
 * �� �����һ������Ϊ n - w + 1 ������ res,res[i] ��ʾÿһ�ִ���״̬�µ����ֵ
 *
 * ����������
 * �� ���� [4,3,5,4,3,3,6,7]   3
 * �� ��� [5,5,5,4,6,7]
 *
 * �Ѷȣ�����
 *
 * ��ʱ��40����
 */


public class _7_GetMaxWindow {

    public static void main(String[] args){

        int[] array = {4,3,5,4,3,3,6,7};
        int[] maxArray = GetMaxWindow1(array,3);
        for (int i = 0; i < maxArray.length; i++) {
            System.out.print(" [" + maxArray[i] + "] ");
        }
    }

    public static int[] GetMaxWindow1(int[] array,int range){

        int minIndex = 0;int maxIndex = range - 1;int max;
        int[] maxArray = new int[array.length - range + 1];
        max = GetMaxItem(array,minIndex,maxIndex);
        maxArray[minIndex] = max;
        while (maxIndex < array.length - 1){
            ++minIndex;++maxIndex;
            if(array[minIndex-1] < max){
                if(array[maxIndex] <= max){
                    // max���ǲ���
                }else{
                    max = array[maxIndex];
                }
            }else{
                if(array[maxIndex] >= max){
                    max = array[maxIndex];
                }else{
                    max = GetMaxItem(array,minIndex,maxIndex);
                }
            }
            maxArray[minIndex] = max;
        }
        return maxArray;

    }

    public static int GetMaxItem(int[] array,int minIndex,int maxIndex){
        int max = array[minIndex];
        for(int i = minIndex + 1;i <= maxIndex;++i){
            if(max < array[i])
                max = array[i];
        }
        return max;
    }

    // ���Ž⣺ά��һ�����ֵ��˫����� ʱ�临�Ӷȣ�O(arr.length)
    public static int[] GetMaxWindow2(int[] arr,int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for(int i = 0;i < arr.length;++i){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }
            if(i >= w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

}
