package com.xu.test.suanfa;

/**
 * @Author: canjin
 * @Date: 2021/3/26
 * 说明: 阶梯问题：每次只能上一级或2级阶梯，10级阶梯有多少种可能
 */
public class JieTi {
    public static void main(String[] args) {
        Integer sum = getSum2(10);
        System.out.println(sum);
    }

    private static Integer getSum(Integer num){
        if(num==1){
            return 1;
        }
        if(num==2){
            return 2;
        }
        return getSum(num-1)+getSum(num-2);
    }

    private static Integer getSum2(Integer num){
        if(num==1){
            return 1;
        }
        if(num==2){
            return 2;
        }
        Integer a=1;
        Integer b=2;
        Integer temp=0;
        for(int i=3;i<=num;i++){
            temp=a+b;
            a=b;
            b=temp;
            System.out.println(temp);
        }
        return temp;
    }
}
