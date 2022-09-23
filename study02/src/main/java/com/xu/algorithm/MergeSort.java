package com.xu.algorithm;

/**
 * @author xucanjin
 * @date 2022/09/23
 * @description 多路归并排序
 */
public class MergeSort {

    public static void main(String[] args) {

        //归并排序
        //1. 将每个文件最开始的数读入(由于有序，所以为该文件最小数)，存放在一个大小为40 的 first_data 数组中；
        //2. 选择 first_data 数组中最小的数 min_data，及其对应的文件索引 index；
        //3. 将 first_data 数组中最小的数写入文件 result，然后更新数组 first_data(根据 index读取该文件下一个数代替 min_data)；
        //4. 判断是否所有数据都读取完毕，否则返回 2。

        sort();
    }

    /**
     * 自己写的对19个数组进行5路归并的程序，只是简单实现。
     * 假定5个数组已经分别排好序了：{0,5,11,18}，{4,7,9,14}，{6,8,12,17}，{10,13,15,16}，{1,2,3}
     * 0	5	11	18
     * 4	7	9	14
     * 6	8	12	17
     * 10	13	15	16
     * 1	2	3
     * 刚开始时，从5个数组中读入最初的数据到tmp[5]数组中，
     * 即0,4,6,10,1.找出最小的值为0，在第0个数组中。把0放入最终的接收数组data[]中，并把第0个数组更新，data[0]=0：
     */
    private static void sort() {
        int max = 999;
        int[] a0 = {0, 5, 11, 18};
        int[] a1 = {4, 7, 9, 14};
        int[] a2 = {6, 8, 12, 17};
        int[] a3 = {10, 13, 15, 16};
        int[] a4 = {1, 2, 3};

        int len0 = 4;
        int len1 = 4;
        int len2 = 4;
        int len3 = 4;
        int len4 = 3;

        //初始化长度为19的数组，接收最终的有序数组
        int[] data = new int[19];
        // data数组的下标
        int k = 0;

        //索引数组，存放数组当前元素的下标，index[0]指向第一个数组 index[1]指向第二个数组
        int[] index = new int[5];

        //存放 a0到a4这5个数组的元素
        int[] tmp = new int[5];


        while (index[0] < len0 || index[1] < len1 || index[2] < len2
                || index[3] < len3 || index[4] < len4) {

            // 如果记录的第一个数组的下标小于4
            if (index[0] < len0) {
                tmp[0] = a0[index[0]];
            } else {
                tmp[0] = max;
            }
            // 如果记录的第二个数组的下标小于4
            if (index[1] < len1) {
                tmp[1] = a1[index[1]];
            } else {
                tmp[1] = max;
            }

            // 如果记录的第三个数组的下标小于4
            if (index[2] < len2) {
                tmp[2] = a2[index[2]];
            } else {
                tmp[2] = max;
            }

            if (index[3] < len3) {
                tmp[3] = a3[index[3]];
            } else {
                tmp[3] = max;
            }

            if (index[4] < len4) {
                tmp[4] = a4[index[4]];
            } else {
                tmp[4] = max;
            }

            int min = tmp[0];
            int pos = 0;

            // 找最小值，并记录最小值位置
            for (int j = 1; j < 5; j++) {
                if (min > tmp[j]) {
                    min = tmp[j];
                    pos = j;
                }
            }
            index[pos]++;
            data[k] = min;
            k++;
            /*if (k == 19) {
                break;
            }*/
        }

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
