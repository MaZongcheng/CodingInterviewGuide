package SchoolRecruit.wangyi2018;

/********************************************************************************
 * CodingInterviewGuide -- ������
 * @version 2017/09/01 11:28
 * @author ������, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ʱ�����ƣ�1��
 * �ռ����ƣ�32768K
 *
 * С�׽�n�����Ӱڷ���һ�����޴�������ϡ���i�����ӷ��ڵ�x[i]��
 * y[i]�С�ͬһ������������ö�����ӡ�ÿһ�β���С�׿��԰�һ��
 * �������𲢽����ƶ���ԭ���ӵ��ϡ��¡����ҵ�����һ�������С�
 * С����֪��Ҫ�������ϳ�����һ��������������i(1 �� i �� n)����
 * ������Ҫ�����ٲ�������.
 *
 *
 * ��������:
 * �����������,��һ��һ������n(1 �� n �� 50),��ʾ���ӵĸ���
 * �ڶ���Ϊn�����ӵĺ�����x[i](1 �� x[i] �� 10^9)
 * ������Ϊn�����ӵ�������y[i](1 �� y[i] �� 10^9)
 *
 * �������:
 * ���n������,��i����ʾ��������һ������������i����������
 * Ҫ�Ĳ�����,�Կո�ָ��ĩ�޿ո�
 *
 * ��������ʾ:
 * ����1������: ����Ҫ����
 * ����2������: ��ǰ�������ӷ���(1, 1)��
 * ����3������: ��ǰ�������ӷ���(2, 1)��
 * ����4������: ���������Ӷ�����(3, 1)��
 * ��������1:
 * 4
 * 1 2 4 9
 * 1 1 1 1
 * �������1:
 * 0 1 3 10
 *
 * �Ѷȣ�������
 *
 */

public class ������ {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int size = in.nextInt();
            int[] x = new int[size];
            int[] y = new int[size];
            for (int i = 0; i < size; i++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < size; i++) {
                y[i] = in.nextInt();
            }
            int[] res = new int[0];
            try {
                res = MinOptions(size, x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < size; i++) {
                result.append(String.valueOf(res[i]) + " ");
            }
            System.out.println(result.toString().trim());
        }
        in.close();
    }

    public static int[] MinOptions(int size,int[] x,int[] y) throws Exception {
        if(x == null || y == null || x.length != y.length || size != x.length){
            throw new Exception("�����������");
        }

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        int results[] = new int[size];
        for (int i = 0; i < size; i++) {
            results[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                for (int k = 0; k < size; k++) {
                    minQueue.add(Math.abs(x[i] - x[k]) + Math.abs(y[j] - y[k]));
                }

                int res = 0;
                for (int m = 0;!minQueue.isEmpty(); m++) {
                    res += minQueue.poll();
                    results[m] = Math.min(results[m],res);
                }
            }
        }
        return results;
    }

}
