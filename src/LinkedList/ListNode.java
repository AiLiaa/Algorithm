package LinkedList;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 * 示例 2： 输入：head = [], val = 1 输出：[]
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 */


// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    // 打印链表元素val
    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // 头插法建立链表
    public static ListNode create1(int[] nums){
        int length = nums.length;
        ListNode dummy = new ListNode(-1, null);
        for (int i = 0; i < length; i++) {
            ListNode listNode = new ListNode(nums[i], dummy.next);
            dummy.next = listNode;
        }
        return dummy.next;
    }

    // 尾插法建立链表
    public static ListNode create2(int[] nums){
        int length = nums.length;
        ListNode dummy = new ListNode(-1, null);
        ListNode temp = dummy;
        for (int i = 0; i < length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            dummy.next = listNode;
            dummy = listNode;
        }
        return temp.next;
    }
}
