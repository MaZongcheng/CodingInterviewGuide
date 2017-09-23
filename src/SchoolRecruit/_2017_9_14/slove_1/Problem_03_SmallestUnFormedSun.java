package SchoolRecruit._2017_9_14.slove_1;

/********************************************************************************
 * CodingInterviewGuide --
 * @version 2017/09/14 22:09
 * @author xtw, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 * 正数数组的最小不可组成和
 *
 * 【题目】
 *
 * 给定一个正数数组arr，
 * 其中所有的值都为整数，以下是最小不 可组成和的概念：
 * 把arr每个子集内的所有元素加起来会出现很多值，其中
 * 最小的记为min，最大的记为max。 在区间[min,max]上，
 * 如果有数不可以被arr某一个子集相加得到，那么其中最小
 * 的那个数是arr的最小不可组成和。 在区间[min,max]上，
 * 如果所有的数都可以被arr的某一个子集相加得到，那么
 * max+1是arr的最小不可组成和。
 *
 * 请写函数返回正数数组arr的最小不可组成和。
 *
 * 【举例】
 *
 * arr=[3,2,5]。子集{2}相加产生2为min，子集{3,2,5}相加产生 10为max。
 * 在区间[2,10]上，4、6和9不能被任何子集相加得到， 其中4是arr的最小不可组成和。
 * arr=[1,2,4]。子集{1}相加产生1为min，子集{1,2,4}相加产生 7为max。
 * 在区间[1,7]上，任何数都可以被子集相加得到，所以 8是arr的最小不可组成和。
 *
 * 【进阶题目】
 *
 * 如果已知正数数组arr中肯定有1这个数，是否能更快地得到最小不可组成和？
 *
 *
 *
 */


public class Problem_03_SmallestUnFormedSun {

    public static void main(String[] args){

        int[] array = { 3,2,5};
        System.out.println(getSmallestUnFormedSun(array));

    }

    public static int getMinUnComfortable(int[] arr){

        int min = Integer.MAX_VALUE,max = 0;
        for (int item :
                arr) {
            if(min > item)
                min = item;
            max += item;
        }

        int res[] = new int[max - min + 1];
        int offset = min;
        res[arr[0] - offset] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = min; j <= max - min; j++) {
                if(i > min && res[arr[i] - offset] != 1){
                    continue;
                }else{
                    res[arr[i] - offset] = 1;
                }
            }
        }

        int i;
        for (i = 0; i < res.length; i++) {
            if(res[i] != 1)
                break;
        }
        return i == res.length ? i + offset : max + 1;
    }

    public static int getSmallestUnFormedSun(int[] arr){

        if(arr == null || arr.length == 0)
            return 1;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max += arr[i];
            min = Math.min(min,arr[i]);
        }

        boolean form[] = new boolean[max + 1];
        form[0] = true; // 为了使单个元素去求和时是真的  (i + 0 = i)
        for (int i = 0; i < arr.length; i++) {
            for (int j = max; j >= arr[i]; j--) {
                form[j] = form[j - arr[i]] || form[j];
            }
        }

        for (int i = min; i < form.length; i++) {
            if(!form[i])
                return i;
        }

        return max + 1;
    }

}