package SchoolRecruit.didi2018;

/********************************************************************************
 * CodingInterviewGuide -- 校招·滴滴2018
 * @version 2017/09/28 10:58
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 * 【题目】
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、 8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当 做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 *
 * 【输入描述】
 *  整数N
 * 【输出描述】
 *  第N个丑数
 *
 * 【示例】
 *  输入： 6
 *  输出： 6
 *
 */

public class Problem_02 {

    public static void main(String[] args) {

        for (int i = 1; i <= 10000; i++) {
                System.out.println(getUglyNumber1(i));
        }

    }

    private static int getUglyNumber(int index) {
        assert index > 0;

        if(index < 7) return index;index -= 6;
        int number = 6;
        while(index > 0) {
            ++number;
            if(isUglyNumber(number))
                --index;
        }
        return number;
    }

    private static boolean isUglyNumber(int number) {
        for (int i = 2; i <= number ; ) {
            if(number % i == 0) {
                if(i != 2 && i != 3 && i != 5)
                    return false;
                number /= i;
            } else {
                ++i;
            }
        }
        return true;
    }

    private static boolean isUgly(int number){
        while(number % 2 == 0)
            number/=2;
        while(number % 3 == 0)
            number /=3;
        while(number % 5 == 0)
            number /=5;
        return (number ==1)? true:false;
    }

    private static int getUglyNumber1(int index){
        if(index <= 0)
            return 0;
        int number = 0;
        int uglyFound = 0;
        while(uglyFound < index){
            number++;
            if(isUgly(number)){
                ++uglyFound;
            }
        }
        return number;
    }
}
