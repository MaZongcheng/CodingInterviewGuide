package SchoolRecruit._2017_9_14;

/********************************************************************************
 * CodingInterviewGuide --
 * @version 2017/09/14 22:09
 * @author xtw, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/


public class Problem_03 {

    public static void main(String[] args){

        int[] array = { 3,2,5};
        System.out.println(getMinUnComfortable(array));

    }

    public static int getMinUnComfortable(int[] array){

        int min = Integer.MAX_VALUE,max = 0;
        for (int item :
                array) {
            if(min > item)
                min = item;
            max += item;
        }

        int res[] = new int[max - min + 1];
        int offset = min;
        res[array[0] - offset] = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = min; j <= max - min; j++) {
                if(i > min && res[array[i] - offset] != 1){
                    continue;
                }else{
                    res[array[i] - offset] = 1;
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

}
