package SchoolRecruit.jingdong2018.slove_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/********************************************************************************
 * CodingInterviewGuide -- SchoolRecruit.jingdong2018.slove_1
 * @version 2017/09/21 13:45
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

/*
 *
 * 东东从京京那里了解到有一个无限长的数字序列:
 * 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, ...(数字k在该序列中正 好出现k次)。
 * 东东想知道这个数字序列的第n项是多少,你能帮帮他么
 *
 * 输入描述: 输入包括一个整数n(1 ≤ n ≤ 10^18)
 *
 * 输出描述:
 * 输出一个整数,即数字序列的第n项
 *
 * 示例1
 *
 * 输入 169
 * 输出 18
 *
 */

public class Problem_01 {

    public static int getArrayItemFormIndex(int index) {
        int item = (int) (Math.sqrt(1 + 8 * (index - 1)) / 2 - 1 + 0.5);
        return item + 1;
    }

    public static void main(String[] args) {

//        int history = 0;
//
//        for (int i = 1; i <= 45; i++) {
//            if(history != getArrayItemFormIndex(i))
//                System.out.println();
//            System.out.print(getArrayItemFormIndex(i) + " ");
//            history = getArrayItemFormIndex(i);
//        }

//        long p = (long) Math.pow(2,38);
//
//        System.out.print(p);


        try {
            FileInputStream stream = new FileInputStream("chars.txt");
            int i = stream.read();
            stream.skip(1);
            System.out.print(i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
