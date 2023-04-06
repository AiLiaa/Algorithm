package LinkedList;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 双指针，快慢指针，快比慢先走 n+1,这样可以找到待删除结点的前驱结点
 */

public class DeleteTheNthToLastNode {

    public static ListNode solution(ListNode head, int n){
        ListNode dummyHead = new ListNode(-1, head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create2(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode res = solution(listNode, 4);
        ListNode.print(res);
    }

}
