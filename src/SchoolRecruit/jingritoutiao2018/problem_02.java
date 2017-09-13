package SchoolRecruit.jingritoutiao2018;

import java.util.Scanner;

/********************************************************************************
 * CodingInterviewGuide -- 
 * @version 2017/09/09 19:15
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 *【题目】
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有
 * 区间中经过如下计算的值最大的一个：
 * 区间中的最小数 * 区间所有数的和
 * 最后程序输出经过计算后的最大值即可，不需要输出具体的区
 * 间。如给定序列 [6 2 1]则根据上述公式, 可得到所有可以选
 * 定各个区间的计算值:
 * [6] = 6 * 6 = 36;
 * [2] = 2 * 2 = 4;
 * [1] = 1 * 1 = 1;
 * [6,2] = 2 * 8 = 16;
 * [2,1] = 1 * 3 = 3;
 * [6, 2, 1] = 1 * 9 = 9;
 * 从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出
 * 为 36。
 * 区间内的所有数字都在[0, 100]的范围内;
 *
 *【测试用例】
 * 输入
 * 第一行输入数组序列个数，第二行输入数组序列。
 * 输出
 * 输出数组经过计算后的最大值。
 * 样例输入
 * 3
 * 6 2 1
 * 样例输出
 * 36
 * Hint
 * 对于 50%的数据, 1 <= n <= 10000;
 * 对于 100%的数据, 1 <= n <= 500000;
 *
 * 【难度】
 *
 *  校 ★★☆☆
 *
 */

public class problem_02 {

    public static void main(String[] args){

        System.out.print("b");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int array[] = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(getMaxResult(array));
        in.close();
    }

    public static int getMaxResult(int[] array){

        int sum = 0;int range;int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = array[i];
            range = i - 1;
            while(range >= 0){
                if(array[range] < array[i])
                    break;
                sum += array[range];
                range--;
            }
            range = i + 1;
            while(range < array.length){
                if(array[range] < array[i])
                    break;
                sum += array[range];
                ++range;
            }
            if(sum * array[i] > maxSum)
                maxSum = sum * array[i];
        }
        return maxSum;
    }
}