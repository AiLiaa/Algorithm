package LinkedList;

/**
 * 链表相交
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 *
 * 先对两链表长度进行比较
 * 把较长的链表cur指针移lenA-lenB
 * 然后同时遍历A,B链表。找到指针相同的链表即为相交链表
 */

public class IntersectLinkedList {
    public static ListNode solution(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null){
            lenA++;
            curA = curA.next;
        }
        while (curB != null){
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 交换，总认为A是长链表，方便后续操作
        if (lenB > lenA){
            int tempLen = lenB;
            lenB = lenA;
            lenA = tempLen;
            ListNode temp = curA;
            curA = curB;
            curB = temp;
        }
        int gap = lenA - lenB;
        while (gap-- > 0){
            curA = curA.next;
        }
        while (curA != null){
            if (curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
