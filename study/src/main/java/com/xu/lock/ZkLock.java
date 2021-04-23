package com.xu.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Author: canjin
 * @Date: 2021/3/12
 * 说明: Curator实现zk分布式锁
 */
public class ZkLock {
    public static void main(String[] args) {

        /*基于ZooKeeper分布式锁的流程
        1. 客户端连接上zookeeper，并在指定节点（locks）下创建临时顺序节点node_n
        2. 客户端获取locks目录下所有children节点
        3. 客户端对子节点按节点自增序号从小到大排序，并判断自己创建的节点是不是序号最小的，若是则获取锁；若不是，则监听比该节点小的那个节点的删除事件
        4. 获得子节点变更通知后重复此步骤直至获得锁；
        5. 执行业务代码，完成业务流程后，删除对应的子节点释放锁。
        */
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString("127.0.0.1").//zk的server地址，多个server之间使用英文逗号分隔开
                connectionTimeoutMs(15*100).  //连接超时时间 15秒
                sessionTimeoutMs(10*100).  //会话超时时间，默认是60s
                //失败重试策略    maxRetries：最大重试次数
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                build();
        curatorFramework.start();

        //分布式锁案例
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/locks");
        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                try {
                    //加锁
                    lock.acquire();
                    System.out.println(Thread.currentThread().getName()+"拿到锁");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        //释放锁
                        lock.release();
                        System.out.println(Thread.currentThread().getName()+"释放锁");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
