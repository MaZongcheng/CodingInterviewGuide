package SchoolRecruit._2017_10_11;

import javax.print.attribute.HashDocAttributeSet;
import java.util.HashMap;

/********************************************************************************
 * CodingInterviewGuide -- SchoolRecruit._2017_10_11
 * @version 2017/10/13 20:04
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 * 设计RandomPool结构
 *
 *【题目】
 *
 * 设计一种结构，在该结构中有如下三个功能：
 * insert(key)：将某个key加入到该结构，做到不重复加入。
 * delete(key)：将原本在结构中的某个key移除。
 * getRandom()：等概率随机返回结构中的任何一个key。
 *
 *【要求】
 *
 * Insert、delete和getRandom方法的时间复杂度都是O(1)。
 *
 *【级别】
 *
 *  校　★★★☆
 *
 *【思路】
 *
 * 要为每一个加入的元素编一个序号，建立两个内部哈希表，一个存 k = 序号，v = 值，另一个存 k = 值，v = 序号。
 * 要getRandom() 时利用 序号-值 map 用随机数函数取值，
 * 要删除元素时先用 值-序号 map 找到序号，然后用最后一个值覆盖掉前面的值然后删除最后面一个即可
 *
 */

public class Problem05_RandomPool {

    public static void main(String[] args) {

        RandomPool randomPool = new RandomPool();

        for (int i = 0; i < 10; i++) {
            randomPool.insert(i);
        }

        randomPool.delete(1);
        randomPool.delete(2);
        randomPool.delete(3);
        randomPool.delete(4);
        randomPool.delete(5);
        randomPool.delete(6);
        randomPool.delete(7);
        randomPool.delete(8);
        randomPool.delete(9);
        for (int i = 0; i < 100; i++) {
            System.out.println(randomPool.getRandom());
        }

    }

}

class RandomPool {

    private HashMap<Integer,Integer> nkMap = new HashMap<>();
    private HashMap<Integer,Integer> knMap = new HashMap<>();
    private int order;

    public void insert(int key) {

        nkMap.put(++order,key);
        knMap.put(key,order);

    }

    public void delete(int key) {

        nkMap.replace(knMap.get(key),nkMap.get(order));
        knMap.replace(nkMap.get(order),order - 1);
        knMap.remove(key);
        nkMap.remove(order--);

    }

    public int getRandom() {

        assert !nkMap.isEmpty();
        return nkMap.get(getRandomNum(order));

    }

    public int getRandomNum(int max) {

        return 1 + (int) (Math.random() * (max));

    }

}