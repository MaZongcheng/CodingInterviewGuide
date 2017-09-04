package SchoolRecruit.wangyi2018;

/********************************************************************************
 * CodingInterviewGuide -- 堆棋子
 * @version 2017/09/01 11:28
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * 小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行
 * y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个
 * 棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。
 * 小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋
 * 子所需要的最少操作次数.
 *
 *
 * 输入描述:
 * 输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
 * 第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
 * 第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)
 *
 * 输出描述:
 * 输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需
 * 要的操作数,以空格分割。行末无空格
 *
 * 如样例所示:
 * 对于1个棋子: 不需要操作
 * 对于2个棋子: 将前两个棋子放在(1, 1)中
 * 对于3个棋子: 将前三个棋子放在(2, 1)中
 * 对于4个棋子: 将所有棋子都放在(3, 1)中
 * 输入例子1:
 * 4
 * 1 2 4 9
 * 1 1 1 1
 * 输出例子1:
 * 0 1 3 10
 *
 * 难度：￥￥￥
 *
 */

public class 堆棋子 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] x = new int[size];
            int[] y = new int[size];
            for (int i = 0; i < size; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < size; i++) {
                y[i] = in.nextInt();
            }
            int[] res = new int[0];
            try {
                res = MinOptions(size, x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < size; i++) {
                result.append(String.valueOf(res[i]) + " ");
            }
            System.out.println(result.toString().trim());
        }
        in.close();
    }

    public static int[] MinOptions(int size,int[] x,int[] y) throws Exception {
        if(x == null || y == null || x.length != y.length || size != x.length){
            throw new Exception("输入参数有误。");
        }

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        int results[] = new int[size];
        for (int i = 0; i < size; i++) {
            results[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                for (int k = 0; k < size; k++) {
                    minQueue.add(Math.abs(x[i] - x[k]) + Math.abs(y[j] - y[k]));
                }

                int res = 0;
                for (int m = 0;!minQueue.isEmpty(); m++) {
                    res += minQueue.poll();
                    results[m] = Math.min(results[m],res);
                }
            }
        }
        return results;
    }

}
