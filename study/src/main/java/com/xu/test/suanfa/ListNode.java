package com.xu.test.suanfa;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: canjin
 * @Date: 2021/3/26
 * 说明: 输入一个链表，反转链表后，输出新链表的表头。反转链表就是要求修改指针的指向
 *  {1,2,3}  {3,2,1}
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution1 {

    public static void main(String[] args) {
        Solution1 so=new Solution1();
        int[] arr={3,6,1,5,9};
        so.MySort(arr);
    }

    //递归
    public static ListNode reverseList(ListNode head) {
        //节点为null
        if(head == null || head.next == null) {
            return head;
        }

        ListNode preNode = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return preNode;
    }

    //将每个节点的指针反转，指向next的指针改为指向pre的指针
    private static ListNode ReverseList2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode pre = null;
        //next用于记录当前结点的下一个结点地址
        ListNode next= null;
        //curr记录当前节点
        ListNode curr=head;
        //head指向null时，循环终止。
        while (curr != null) {
            //记录当前节点下一个节点的地址
            next=curr.next;
            //当前节点的next指向前一个节点
            curr.next=pre;
            //把当前节点赋值给pre
            pre=curr;
            //让当前节点变为下一个节点
            curr=next;
        }
        return pre;//当循环结束时,pre所指的就是反转链表的头结点
    }

    public int[] MySort (int[] arr) {
        quickSort(arr , 0 , arr.length-1);
        return arr;
    }
    public void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);
            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, point + 1, right);
        }
    }

    /**
     * 分割数组，找到分割点
     */
    public int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }

            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= first) {
                left++;
            }

            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
