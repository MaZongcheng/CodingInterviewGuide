package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- GetMaxTree
 * @version 2017/08/29 09:23
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目：构造数组的MaxTree (p22)
 *
 * 要求：
 *
 * 一个数组的MaxTree定义如下：
 * · 数组必须没有重复的元素
 * · MaxTree是一颗二叉树，数组的每一个值对应一个二叉节点
 * · 包括MaxTree树在内且在其中每一颗子树上，值最大的节点都是树的头
 *
 * 给定一个没有重复元素的数组arr，构造出其MaxTree
 * 若数组长度为N,则时间复杂度为O(N),额外空间复杂度为O(N)
 *
 * 难度：￥￥￥
 *
 * 用时：128分钟 (尝试失败，用的是书上的解题思路,看来还搞不定校级的题目p）
 */

public class _8_GetMaxTree {

    public static void main(String[] args){

        int[] array  = {3,4,5,1,2};
        int[] node = getParentNode(array);

        for (int i = 0; i < node.length; i++) {
            System.out.println(node[i]);
        }

    }

    public static int[] getParentNode(int[] array){

        int[] node = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < node.length; i++) {
            node[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < array.length; i++) {
            if(stack.isEmpty() || array[stack.peek()] > array[i]){
                if(!stack.isEmpty() && (node[i] == Integer.MIN_VALUE || array[node[i]] > array[stack.peek()])){
                    node[i] = stack.peek();
                }
                stack.push(i);
            }else{
                if(node[stack.peek()] == Integer.MIN_VALUE || array[node[stack.peek()]] > array[i])
                    node[stack.peek()] = i;
                while(!stack.isEmpty() && array[stack.peek()] > array[i])
                    stack.pop();
            }
        }
        return node;
    }

    public static Node getMaxTree(int[] arr){
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Node,Node> lBigMap = new HashMap<>();
        HashMap<Node,Node> rBigMap = new HashMap<>();
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            while(!stack.isEmpty() && stack.peek().value < curNode.value){
                popStackSetMap(stack,lBigMap);
                stack.push(curNode);
            }
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack,lBigMap);
        }
        for (int i = nArr.length - 1; i != -1; i--) {
            Node curNode = nArr[i];
            while((!stack.isEmpty()) && stack.peek().value < curNode.value){
                popStackSetMap(stack,rBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,rBigMap);
        }
        Node head = null;
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if(left == null && right == null){
                head = curNode;
            }else if(left == null){
                if(right.left == null){
                    right.left = curNode;
                }else{
                    right.right = curNode;
                }
            }else if(right == null){
                if(left.left == null){
                    left.left = curNode;
                }else {
                    left.right = curNode;
                }
            }else{
                Node parent = left.value < right.value ? left : right;
                if(parent.left == null){
                    parent.left = curNode;
                }else{
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    private static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if(stack.isEmpty()){
            map.put(popNode,null);
        }else{
            map.put(popNode,stack.peek());
        }
    }

}

class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int data){
        this.value = data;
    }
}
