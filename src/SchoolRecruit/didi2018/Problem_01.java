package SchoolRecruit.didi2018;

import java.util.HashMap;

/********************************************************************************
 * CodingInterviewGuide -- 校招·滴滴2018
 * @version 2017/09/27 22:44
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 * 【题目】
 * 给出n个数字 a_1,...,a_n，问最多有多少不重叠的非空区间，
 * 使得每个区间内数字的xor都等于0。
 *
 * 【输入描述】
 * 第一行一个整数ｎ； 第二行ｎ个整数 a_1,...,a_n；
 * 对于 30%的数据，n<=20； 对于100%的数据，n<=100000, a_i<=100000；
 *
 * 【输出描述】
  * 一个整数表示最多的区间个数；
 *
 * 【示例】
 * 输入： 4 3 0 2 2
 * 输出： 2
 */

public class Problem_01 {

    public static void main(String[] args) {

        int array[] = { 1,1,0,1,1};
        System.out.println(getMaxIntervalNum(array));

    }

    private static int getMaxIntervalNum(int[] array) {
        int xes[] = new int[array.length];
        int xor = 0;int res = Integer.MIN_VALUE;
        HashMap<Integer,Integer> xorMap = new HashMap<>();
        xorMap.put(0,-1);
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
            if(i > 0) {
                if(xorMap.containsKey(xor)) {
                    int index = xorMap.get(xor);
                    xes[i] = Math.max( index == -1 ? 1 : xes[index] + 1,xes[i-1]);
                } else {
                    xes[i] = xes[i - 1];
                }
            } else
                xes[i] = array[i] == 0 ? 1 : 0;
            xorMap.put(xor,i);
            res = Math.max(res,xes[i]);
        }
        return res;
    }
}
