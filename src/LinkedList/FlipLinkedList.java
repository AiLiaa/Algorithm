package LinkedList;

/**
 * 反转一个单链表。
 *
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 *
 */

public class FlipLinkedList {
    // 双指针法
    // 前驱和当前指针，temp临时保留cur的下一结点
    public static ListNode solution(ListNode head){
        ListNode prev = null;
        ListNode temp = null; // 保留cur的next结点
        ListNode cur = head;
        while (cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // 头插法
    public static ListNode solution2(ListNode head){
        ListNode cur = head;
        ListNode temp = null;
        // 虚拟头结点
        ListNode dumpyHead = new ListNode(-1, null);
        while (cur != null){
            temp = cur.next;
            cur.next = dumpyHead.next;
            dumpyHead.next = cur;
            cur = temp;
        }
        return dumpyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create2(new int[]{1, 2, 3, 4, 5});
        ListNode.print(listNode);
        ListNode res = solution(listNode);
        ListNode.print(res);
        ListNode res2 = solution2(res);
        ListNode.print(res2);
    }
}
