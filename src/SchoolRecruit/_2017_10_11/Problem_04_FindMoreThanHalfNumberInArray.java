package SchoolRecruit._2017_10_11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/********************************************************************************
 * CodingInterviewGuide -- SchoolRecruit._2017_10_11
 * @version 2017/10/11 22:56
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 * 在数组中找到出现次数大于N/K的数
 *
 * 【题目】
 * 给定一个整型数组arr，打印其中出现次数大于一半的数，如果 没有这样的数，打印提示信息。
 *
 * 【进阶】
 * 给定一个整型数组arr，再给定一个整数K，打印所有出现次数大于N/K的数，如果没有这样的数，打印提示信息。
 *
 * 【级别】
 *
 *  校　★★★☆
 *
 * 【思路】
 *
 *  初级，两两删除不同的数，最后能剩下的数才有可能是出现次数大于N/2的数，最后再验证一遍即可
 *
 *  进阶，其实和初级一样，不过是一次删除K个不同的数，然后一一验证剩下的最多K-1个数,删除K个数的算法可以用map实现
 */

public class Problem_04_FindMoreThanHalfNumberInArray {

    public static void main(String[] args) {

        int[] array = {1,2,2,3,3,3,2,3};

        findMoreThanHalfNumberInArray(array);
        findMoreThanNdivideKNumberInArray(array,3);

    }

    private static void findMoreThanHalfNumberInArray(int[] array) {

        int candidate = array[0];int times = 1;
        for (int i = 1; i < array.length; i++) {
            if(times == 0) {
                candidate = array[i];
                ++times;
            }
            else if(candidate == array[i])
                ++times;
            else
                --times;
        }
        if(times > 0) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if(candidate == array[i])
                    ++count;
            }
            if(count * 2 > array.length)
                System.out.println(candidate);
            else
                System.out.println("no such number");
        } else {
            System.out.println("no such number");
        }

    }

    private static void findMoreThanNdivideKNumberInArray(int[] array,int k) {

        HashMap<Integer,Integer> candidates = new HashMap<>(k - 1);

        for (int i = 0; i < array.length; i++) {
            if(candidates.containsKey(array[i])) {
               candidates.replace(array[i],candidates.get(array[i]) + 1);
            } else {
                if(candidates.size() < k-1) {
                    candidates.put(array[i],1);
                } else {
                    allCandsMinusOne(candidates);
                }
            }
        }
        int num = 0;
        for (int number :
                candidates.keySet()) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {

                if(number == array[i])
                    ++count;
            }
            if(count * k > array.length){
                num++; System.out.println(number);
            }
        }
        if(num == 0)
            System.out.println("no such number");

    }

    private static void allCandsMinusOne(HashMap<Integer,Integer> map) {
        List<Integer> removeList = new LinkedList<>();
        for(Map.Entry<Integer,Integer> set : map.entrySet()) {
            Integer key = set.getKey();
            Integer value = set.getValue();
            if(value == 1) {
                removeList.add(key);
            }
            map.put(key,value - 1);
        }

        for (Integer removeKey :
                removeList) {
            map.remove(removeKey);
        }
    }

}
