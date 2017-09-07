package SchoolRecruit.wangyi2018;

/********************************************************************************
 * CodingInterviewGuide -- 疯狂队列
 * @version 2017/09/05 18:15
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.Arrays;
import java.util.Scanner;

/**
 * 疯狂队列
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * 【题目】
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成
 * 一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个
 * 学生在列队的时候,小易老师正好去卫生间了。学生们终于有机
 * 会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队
 * 列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按
 * 照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯
 * 狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算
 * 出这些学生列队的最大可能的疯狂值。小易老师回来一定会气
 * 得半死。
 *
 * 输入描述:
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人
 * 数
 * 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身
 * 高
 * 输出描述:
 * 输出一个整数,表示n个学生列队可以获得的最大的疯狂值。
 *
 * 如样例所示:
 * 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为
 * 15+30+35+20=100。
 * 这是最大的疯狂值了。
 * 输入例子1:
 * 5
 * 5 10 25 40 25
 * 输出例子1:
 * 100
 *
 * 【难度】
 *
 * 尉　★★☆☆
 */

public class 疯狂队列 {

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
