package SchoolRecruit._2017_10_11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/********************************************************************************
 * CodingInterviewGuide -- SchoolRecruit._2017_10_11
 * @version 2017/10/16 19:11
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 * 一种消息接收并打印的结构设计
 *
 * 【题目】
 *
 * 消息流吐出2，一种结构接收而不打印2，因为1还没出现。
 * 消息流吐出1，一种结构接收1，并且打印：1，2。
 * 消息流吐出4，一种结构接收而不打印4，因为3还没出现。
 * 消息流吐出5，一种结构接收而不打印5，因为3还没出现。
 * 消息流吐出7，一种结构接收而不打印7，因为3还没出现。
 * 消息流吐出3，一种结构接收3，并且打印：3，4，5。
 * 消息流吐出9，一种结构接收而不打印9，因为6还没出现。
 * 消息流吐出8，一种结构接收而不打印8，因为6还没出现。
 * 消息流吐出6，一种结构接收6，并且打印：6，7，8，9。
 *
 * 已知一个消息流会不断地吐出整数1~N，但不一定按照顺序吐出。如果
 * 上次打印的数为i，那么当i+1出现时，请打印i+1及其之后接收过的并
 * 且连续的所有数，直到1~N全部接收并打印完，请设计这种接收并打印
 * 的结构。
 *
 * 【要求】
 * 消息流最终会吐出全部的1~N，当然最终也会打印完所有的1~N，要求接
 * 收和打印1~N的整个过程，时间复杂度为O(N)。
 *
 *【级别】
 *
 *  校　★★★☆
 *
 *【思路】
 *
 * 一个开头map和一个结尾map,每个连续区间都是一个链表
 */

public class Problem06_MessageStreamPrint {



    public static void main(String[] args) {
        MessageStream messageStream = new MessageStream();
        messageStream.AddMessage(new Entry(2,"2"));
        messageStream.AddMessage(new Entry(1,"1"));
        messageStream.AddMessage(new Entry(5,"5"));
        messageStream.AddMessage(new Entry(4,"4"));
        messageStream.AddMessage(new Entry(3,"3"));
        messageStream.AddMessage(new Entry(6,"6"));
        messageStream.AddMessage(new Entry(7,"7"));
        messageStream.AddMessage(new Entry(8,"8"));
        messageStream.AddMessage(new Entry(9,"9"));
        messageStream.AddMessage(new Entry(10,"10"));
    }

}

class Entry
{
    int key;
    String value;

    public Entry(int key,String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

class MessageStream {

    int cur = 1;
    private HashMap<Integer,LinkedList<Entry>> headMap = new HashMap<>();
    private HashMap<Integer,LinkedList<Entry>> tailMap = new HashMap<>();

    public void AddMessage(Entry entry) {
        if(headMap.containsKey(entry.getKey() + 1)) {
            headMap.get(entry.getKey() + 1).addFirst(entry);
            headMap.put(entry.getKey(),headMap.get(entry.getKey() + 1));
            headMap.remove(entry.getKey() + 1);
        }
        else if(tailMap.containsKey(entry.getKey() - 1)) {
            tailMap.get(entry.getKey() - 1).addLast(entry);
            tailMap.put(entry.getKey(),tailMap.get(entry.getKey() - 1));
            tailMap.remove(entry.getKey());
        } else {
            LinkedList<Entry> list = new LinkedList<>();
            list.addLast(entry);
            headMap.put(entry.getKey(),list);
            tailMap.put(entry.getKey(),list);
        }

        if(headMap.containsKey(cur)) {
            PrintMessage(headMap.get(cur));
            tailMap.remove(headMap.get(cur).getLast().getKey());
            cur = headMap.get(cur).getLast().getKey() + 1;
            headMap.remove(cur);
        }
    }

    private void PrintMessage(LinkedList<Entry> list) {
        for (Entry entry :
                list) {
            System.out.print(entry.getValue());
        }
    }
}
