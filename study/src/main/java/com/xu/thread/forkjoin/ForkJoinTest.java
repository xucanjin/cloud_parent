package com.xu.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: canjin
 * @Date: 2021/6/10
 * 说明:
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        // 创建2000个随机数组成的数组:
        long[] arry=new long[2000];
        long sum=0;
        for(int i=0;i<arry.length;i++){
            arry[i]= (long) (Math.random()*10000);
            sum+=arry[i];
        }
        System.out.println("总数："+sum);

        //使用fork/join
        SumTask sumTask = new SumTask(arry, 0, arry.length);
        long startTime = System.currentTimeMillis();

        //得到计算结果
        Long result = ForkJoinPool.commonPool().invoke(sumTask);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + "时间："+(endTime-startTime));
    }
}

class SumTask extends RecursiveTask<Long> {
    static final int THRESHOLD = 500;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if(end-start<=THRESHOLD){
            // 如果任务足够小,直接计算:
            long sum=0;
            for(int i=start;i<end;i++){
                sum+=this.array[i];
            }
            return sum;
        }
        // 任务太大,一分为二:
        int middle=(start+end)/2;
        SumTask task1=new SumTask(this.array,start,middle);
        SumTask task2=new SumTask(this.array,middle,end);
        //提交任务
        invokeAll(task1,task2);

        //得到task1的计算结果
        Long result1 = task1.join();
        //得到task2的计算结果
        Long result2 = task2.join();

        long result = result1 + result2;
        System.out.println("结果1："+result1+" 结果2："+result2+" 和："+result);
        return result;
    }
}
