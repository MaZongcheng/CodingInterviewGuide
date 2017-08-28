package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- GetMaxWindow
 * @version 2017/08/28 11:20
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.LinkedList;

/**
 * 题目：生成最大值数组 (p19)
 *
 * 要求：
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑倒最右边，每次滑动一个位置，求出每次窗口内数组的最大值
 * 请实现一个函数：
 * · 输入：整型数组arr，窗口大小 w
 * · 输出：一个长度为 n - w + 1 的数组 res,res[i] 表示每一种窗口状态下的最大值
 *
 * 测试用例：
 * · 输入 [4,3,5,4,3,3,6,7]   3
 * · 输出 [5,5,5,4,6,7]
 *
 * 难度：￥￥
 *
 * 用时：40分钟
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
                    // max还是不变
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

    // 最优解：维护一个最大值的双向队列 时间复杂度：O(arr.length)
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
