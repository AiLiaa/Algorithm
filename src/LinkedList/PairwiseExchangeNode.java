package LinkedList;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

public class PairwiseExchangeNode {

    public static ListNode solution(ListNode head){
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null){
            // 以cur等于虚拟头结点为例
            // cur->1->2->3->4->5
            // 2->1->3->4->5
            ListNode temp = cur.next;// 临时保存第一个结点
            ListNode temp2 = cur.next.next.next;// 临时保存第三个结点
            cur.next = cur.next.next;// 虚拟头结点指向第二个结点
            cur.next.next = temp; // 第二个结点指向临时保存的第一个结点
            cur.next.next.next = temp2;// 第一个结点指向保存的第三个结点

            // 2->1(cur)->3->4->5  后移，为后面循环准备
            cur = cur.next.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create2(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode res = solution(listNode);
        ListNode.print(res);
    }
}
