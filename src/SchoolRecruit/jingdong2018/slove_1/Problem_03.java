package SchoolRecruit.jingdong2018.slove_1;

/********************************************************************************
 * CodingInterviewGuide -- SchoolRecruit.jingdong2018.slove_1
 * @version 2017/09/27 00:51
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 * 给定一个字符串s, 请计算输出含有连续两个s作为子串的最短字符串。
 * 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),s中每
 * 个字符都是小写字母.
 *
 * 输出描述:
 * 输出一个字符串,即含有连续两个s作为子串的最短字符串。
 *
 * 示例1
 *
 * 输入 abracadabra
 *
 * 输出 abracadabracadabra
 */

public class Problem_03 {

    public static void main(String[] args) {

        System.out.println(getShortestDoubleString("abracadabra"));

    }

    public static String getShortestDoubleString(String s) {

        int i = 1;
        for (; i < s.length(); i++) {
            if(s.substring(i,s.length()).equals(s.substring(0,s.length() - i)))
                break;
        }
        return s + s.substring(i - 1,s.length());

    }

}
