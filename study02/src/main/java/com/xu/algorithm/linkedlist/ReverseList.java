package com.xu.algorithm.linkedlist;

/**
 * @author xucanjin
 * @date 2022/03/29
 * @description 反转链表 如将1 2 3 反转
 */
public class ReverseList {

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public static ListNode iterator(ListNode head) {
        //存放前一个节点
        ListNode prev = null;
        //保存下一个节点
        ListNode next;

        //当前节点
        ListNode curr = head;
        while (curr != null) {
            //先保存当前节点的下一个节点
            next = curr.next;
            //把当前节点的next指针指向prev
            curr.next = prev;
            //把当前节点保存到prev
            prev = curr;
            //把当前节点赋值为下一个节点
            curr = next;
        }
        return prev;
    }

    /**
     * 递归，要先找到最后一个节点
     *
     * @param head
     * @return
     */
    public static ListNode recursion(ListNode head) {

        //将链表2个2个的反转，将大问题拆成一个一个的小问题
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = recursion(head.next);
        //将当前节点的下一节点的next指向当前节点
        head.next.next = head;
        //将当前节点的next指向null
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        //ListNode prev = iterator(node1);
        ListNode prev = recursion(node1);
        System.out.println(prev);
    }

    /**
     * 合并2个链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode cur = list1.val < list2.val ? list1 : list2;
        cur.next = mergeTwoLists(cur.next, list1.val >= list2.val ? list1 : list2);
        return cur;
    }
}
