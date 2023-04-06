package LinkedList;

public class RemoveElements {

    public static ListNode solution(ListNode head, int val){

        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy; // 前置结点
        ListNode cur = head; // 当前结点

        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    // 打印链表元素val
    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
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


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode head = create2(nums);
        print(head);
        ListNode res = solution(head, 1);
        System.out.println();
        print(res);

    }

}
