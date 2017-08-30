package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- GetMaxTree
 * @version 2017/08/29 09:23
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.HashMap;
import java.util.Stack;

/**
 * ��Ŀ�����������MaxTree (p22)
 *
 * Ҫ��
 *
 * һ�������MaxTree�������£�
 * �� �������û���ظ���Ԫ��
 * �� MaxTree��һ�Ŷ������������ÿһ��ֵ��Ӧһ������ڵ�
 * �� ����MaxTree��������������ÿһ�������ϣ�ֵ���Ľڵ㶼������ͷ
 *
 * ����һ��û���ظ�Ԫ�ص�����arr���������MaxTree
 * �����鳤��ΪN,��ʱ�临�Ӷ�ΪO(N),����ռ临�Ӷ�ΪO(N)
 *
 * �Ѷȣ�������
 *
 * ��ʱ��128���� (����ʧ�ܣ��õ������ϵĽ���˼·,�������㲻��У������Ŀp��
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
