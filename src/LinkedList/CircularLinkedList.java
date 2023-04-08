package LinkedList;

/**
 * 环形链表2
 *
 * 题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 1. 断链表是否环
 * 可以使用快慢指针法，分别定义 fast 和 slow 指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，
 * 如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。
 *
 * 2. 如果有环，如何找到这个环的入口
 *
 * x:头结点到环入口
 * y:换入口到相遇
 * z:相遇到入口
 *
 * 相遇时：
 * slow指针走过的节点数为: x + y（因为快慢是 2步:1步 的关系，一定会在环的第一圈相遇。当slow进入时，无论fast在环的任何位置），
 * fast指针走过的节点数：x + y + n (y + z)
 *
 * 换算：
 * (x + y) * 2 = x + y + n (y + z)
 * x = (n - 1) (y + z) + z
 *
 * 所以：
 * 从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点，
 * 那么当这两个指针相遇的时候就是环形入口的节点。
 *
 */

public class CircularLinkedList {
    public static ListNode solution(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){ // 环
                ListNode index1 = head;
                ListNode index2 = fast;
                // 找环入口
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

}
