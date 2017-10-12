package SchoolRecruit.jingdong2018.slove_1;

import java.util.Comparator;
import java.util.PriorityQueue;

/********************************************************************************
 * CodingInterviewGuide -- SchoolRecruit.jingdong2018.slove_1
 * @version 2017/09/23 11:16
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 *
 * 东东在一本古籍上看到有一种神奇数,如果能够将一个数的数字
 * 分成两组,其中一组数字的和等于另一组数字的和,我们就将这
 * 个数称为神奇数。例如242就是一个神奇数,我们能够将这个数
 * 的数字分成两组,分别是{2,2}以及{4},而且这两组数的和都是4.
 * 东东现在需要统计给定区间中有多少个神奇数,即给定区间[l, r],
 * 统计这个区间中有多少个神奇数,请你来帮助他。
 *
 * 输入描述:
 * 输入包括一行,一行中两个整数l和r(1 ≤ l, r ≤ 10^9, 0 ≤ r - l ≤ 10^6),以空格分割
 *
 * 输出描述:
 * 输出一个整数,即区间内的神奇数个数
 *
 * 示例1
 *
 * 输入
 * 1 50
 *
 * 输出
 * 4
 *
 */

public class Problem_02 {

    public static int getMagicNumber(int l,int r) {

        int sum = 0;
        for (int i = l; i <= r; i++) {
            if(isMagicNumber(getNumberQueue(i)))
                ++sum;
        }
        return sum;

    }

    public static boolean isMagicNumber(PriorityQueue<Integer> queue) {

        int sum = 0;
        while (!queue.isEmpty()) {
            if(sum <= 0)
                sum += queue.poll();
            else
                sum -= queue.poll();
        }
        return (sum == 0); // 如果最终结果为零，则刚好是神奇数
    }

    private static PriorityQueue<Integer> getNumberQueue(int number){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new BigComparable());
        while (number > 0){
            queue.add(number % 10);
            number /= 10;
        }
        return queue;
    }

    private static class BigComparable implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

    public static void main(String[] args) {

         System.out.println(getMagicNumber(1,100));

    }

}
