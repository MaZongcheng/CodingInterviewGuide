package SchoolRecruit.jingritoutiao2018;

import java.util.*;

/********************************************************************************
 * CodingInterviewGuide -- 
 * @version 2017/09/07 17:21
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 *����Ŀ��
 * PΪ�����Ķ�άƽ�������㼯������ P ��ĳ��x�����x���� P
 * ������㶼���� x �����Ϸ������ڣ��������궼����x�������
 * ��Ϊ�����ġ���������С����ġ���ļ��ϡ������е��
 * ������������궼���ظ�, �����᷶Χ��[0, 1e9) �ڣ�
 * ����ͼ��ʵ�ĵ�Ϊ���������ĵ�ļ��ϡ�
 *
 * ��ʵ�ִ����ҵ����� P �е����� ����� ��ļ��ϲ������
 * ����
 * ��һ������㼯�ĸ��� N�� ������ N �У�ÿ���������ִ���
 * ��� X ��� Y �ᡣ
 * ���
 * ��������ġ� �㼯�ϣ� ���� X ���С����ķ�ʽ�����ÿ
 * ���������ֱַ������ X ��� Y�ᡣ
 *
 *���������롿
 * 5
 * 1 2
 * 5 3
 * 4 6
 * 7 5
 * 9 0
 *
 *�����������
 * ���������� x ���������������Ϊ��
 * 4 6
 * 7 5
 * 9 0
 * Hint
 * ���� 50%������, 1 <= n <= 10000;
 * ���� 100%������, 1 <= n <= 500000;
 *
 * ���Ѷȡ�
 *
 *  ξ �����
 */

public class Problem_01 {

    public static int[] generateRandomArray(int size) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = (int) (Math.random() * 1000);
            }
        return arr;
    }

    public static boolean isEqual(LinkedList<Node> list1, LinkedList<Node> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        while (!list1.isEmpty()) {
            Node node1 = list1.pollFirst();
            Node node2 = list2.pollFirst();
            if (node1.x != node2.x || node1.y != node2.y) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            System.out.print("(" + x[i] + "," + y[i] + ") ");
        }
        System.out.println();
    }

    public static void printLinkedList(LinkedList<Node> list) {
        for (Node node : list) {
            System.out.print("(" + node.x + "," + node.y + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int testTime = 3000000;
        for (int i = 0; i < testTime; i++) {
            int size = 10;
//            int[] x = generateRandomArray(size);
//            int[] y = generateRandomArray(size);
            int[] x = {407,6,754,299,424,567,972,323,825,338};
            int[] y = {104,29,867,651,908,394,442,64,366,158};
            LinkedList<Node> res1 = null;
            try {
                res1 = getMaxPoint(x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
            {
                printArray(x, y);
                printLinkedList(res1);
                break;
            }
        }
    }

    public static LinkedList<Node> getMaxPoint(int[] x,int[] y) throws Exception {

        if(x.length != y.length){
            throw new Exception("x.length != y.length");
        }
        LinkedList<Node> res = new LinkedList<>();
        Node[] points = new Node[x.length];
        LinkedList<Node> xQueue = new LinkedList<>();
        LinkedList<Node> yQueue = new LinkedList<>();

        for (int i = 0; i < x.length; i++) {
            points[i] = new Node(x[i],y[i]);
        }

        Arrays.sort(points,new XComparator());
        for (int i = 0; i < points.length; i++) {
            xQueue.add(points[i]);
        }

        Arrays.sort(points,new YComparator());
        for (int i = 0; i < points.length; i++) {
            yQueue.add(points[i]);
        }

        while (!xQueue.isEmpty()){
            while (xQueue.peekFirst() != yQueue.peekLast()){
                yQueue.remove(xQueue.peekFirst());
                xQueue.removeFirst();
            }
            while (yQueue.peekFirst() != xQueue.peekLast()){
                xQueue.remove(yQueue.peekFirst());
                yQueue.removeFirst();
            }
            if(!xQueue.isEmpty())
                res.add(xQueue.removeFirst());
            if(!xQueue.isEmpty())
                res.add(xQueue.removeLast());
            if(!yQueue.isEmpty())
                yQueue.removeFirst();
            if(!yQueue.isEmpty())
                yQueue.removeLast();
        }

        res.sort(new XComparator());
        return res;
    }

    public static class Node{
        public int x;
        public int y;

        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1,Node o2){
            if(o1.x != o2.x){
                return o1.x - o2.x;
            }else{
                return o2.y - o1.y;
            }
        }
    }

    public static class XComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1,Node o2){
            return o1.x - o2.x;
        }
    }

    public static class YComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1,Node o2){
                return o1.y - o2.y;
        }
    }

}
