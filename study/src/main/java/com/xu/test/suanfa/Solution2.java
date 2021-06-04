package com.xu.test.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/4/21
 * 说明:
 */
public class Solution2 {
    public static void main(String[] args) {

        /*int i = removeDuplicates(new int[]{1, 2, 2, 3, 4, 5,6});
        System.out.println(i);*/
        //System.out.println(bf(100));

        //System.out.println(erotos(100));
        System.out.println(reverseString("abcd"));
        //System.out.println(reverse(322));
        //System.out.println(min(new int[]{1,2,4,6}));
        //System.out.println(GetLeastNumbers_Solution(new int[]{1,2,8,6,7},3));

    }

    //删除排序数组中的重复项,返回去重数组的长度
    //双指针算法
    //数组完成排序后，我们使用2个指针i和j，i是慢指针，j是快指针。
    // 只要num[i]=num[j],我们就增加j以跳过重复项。当遇到num[i]!=num[j]时，跳过重复项的运行已经结束，
    // 必须把num[i]的值复制到num[i+1]，然后递增i，直到j到达数组的末尾。
    private static int removeDuplicates(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];//此处i已经加了1了
            }
        }
        return i+1;
    }


    //统计n以内的素数个数
    //素数：只能被1和自身整除的自然数，0、1除外
    //1、暴力破解
    private static int bf(int n){
        int count=0;
        for(int i=2;i<n;i++){
            count+=isPrime(i) ? 1:0;
        }
        return count;
    }
    private static boolean isPrime(int x) {
        //这里i 只要小于根号x就行，不需要到x，可以减少遍历次数
        for (int i = 2; i * i <= x; i++) {
            //x能被i整除，说明不是素数
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    //2、埃氏筛选法
    //素数*n必然是合数，因此可以从2开始遍历，将所有的合数做上标记
    public static int erotos(int n){
        boolean[] isPrime=new boolean[n];//默认是false，false表示素数
        int count=0;
        for(int i=2;i<n;i++){
            //是素数
            if(!isPrime[i]){
                count++;
                //找到满足条件的合数
                for(int j=2*i;j<n;j=j+i){
                    isPrime[j]=true;
                }
            }
        }
        return count;
    }

    //字符串反转
    public static String reverseString(String str){
        char[] chars = str.toCharArray();
        int length=str.length();

        for(int i=0;i<length;i++){
            chars[i]=str.charAt(length-1-i);
        }
        return new String(chars);
    }


    //数字反转
    public static int reverse(int x){
        //记录反转后的值
        int res=0;
        while(x!=0){
            //余数
            int t=x %10;

            int num=res*10+t;
            //
            if((num-t) /10!=res ){
                return 0;
            }
            res=num;
            x=x/10;
        }
        return res;
    }

    //找出数组的最小值
    public static int min(int[] arr) {
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        return min;
    }

    //找出最小的k个数
    public static List<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        List<Integer> list=new ArrayList<>(k);
        if( k>input.length){
            return list;
        }
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
}
