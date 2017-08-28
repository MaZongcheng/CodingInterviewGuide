package Chapter1;

/********************************************************************************
 * CodingInterviewGuide -- 汉诺塔问题升级版
 * @version 2017/08/27 12:12
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/**
 * 题目：用栈来求解汉诺塔问题 (p14)
 *
 * 要求：
 * 1、限制从左移动到右或从右移动到左，都必须经过中
 *
 * 2、打印最优移动过程和最优总步数
 *
 * 难度：￥￥￥
 *
 * 用时：80分钟
 */

public class _6_HanoiProblem {

    public static void hanoiProblem(int n,String left,String mid,String right){

        if(n > 0){
            System.out.println("Move " + n + " form " + left + " to " + right);
            hanoiProblem(n-1,mid,left,right);
            System.out.println("Move " + n + " form " + left + " to " + right);
        }

    }

    public static void main(String[] args){

        hanoiProblem1(2,"left","mid","right");

    }

    public static int hanoiProblem1(int num,String left,String mid,String right){
        if(num < 1)
            return 0;
        return process(num,left,mid,right,left,right);
    }

    public static int process(int num,String left,String mid,String right,String from,String to){
        if(num == 1){
            if(from.equals(mid) || to.equals(mid)){
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            }else{
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }else{
            if(from.equals(mid) || to.equals(mid)){
                String another = (from.equals(left) || to.equals(left)) ? right : left;
                int part1 = process(num - 1,left,mid,right,from,another);
                int part2 = 1;
                System.out.println("Move " + num + " from " + from + " to " + to);
                int part3 = process(num - 1,left,mid,right,another,to);
                return part1 + part2 + part3;
            }else{
                int part1 = process(num - 1,left,mid,right,from,to);
                int part2 = 1;
                System.out.println("Move " + num + " from " + from + " to " + mid);
                int part3 = process(num - 1,left,mid,right,to ,from);
                int part4 = 1;
                System.out.println("Move " + num + " from " + mid + " to " + to);
                int part5 = process(num - 1,left,mid,right,from,to);
                return part1 + part2 + part3 + part4 + part5;
            }
        }
    }

}
