package LinkedList;

/**
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
 * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 * 如果 index 大于链表长度，则不会插入节点。
 * 如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */

public class DeviseLinkdeList {

    int size;// 结点个数
    ListNode head;// 虚拟头结点

    DeviseLinkdeList(){
        size = 0;
        head = new ListNode(0);
    }


    public int get(int index){
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        // 有虚拟头结点，用<=查找index+1
        for (int i = 0; i <= index; i++) {
            cur = cur.next;

        }
        return cur.val;
    }

    public void addAtIndex(int val, int index){

        if (index > size){
            return;
        }
        if (index < 0){
            index = 0;
        }
        // 找到前驱结点
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode add = new ListNode(val);
        add.next = pre.next;
        pre.next = add;
        size++;
    }

    public void addAtHead(int val){
        addAtIndex(0,val);
    }

    public void addAtTail(int val){
        addAtIndex(size, val);
    }

    public void deleteAtIndex(int index){
        if (index < 0 || index >= size){
            return;
        }
        size --;
        if (index == 0){
            head = head.next;
            return;
        }
        ListNode pred = head;
        for (int i = 0; i < index ; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode = RemoveElements.create2(new int[]{ 1, 2, 3, 4, 5});
        RemoveElements.print(listNode);
        System.out.println();
        DeviseLinkdeList deviseLinkdeList = new DeviseLinkdeList();
        deviseLinkdeList.head.next = listNode;
        deviseLinkdeList.size = 5;
        deviseLinkdeList.deleteAtIndex(0);
        RemoveElements.print(deviseLinkdeList.head.next);
        System.out.println();
        deviseLinkdeList.addAtIndex(100,1);
        RemoveElements.print(deviseLinkdeList.head.next);
        System.out.println();
    }
}

////双链表
//class ListNode{
//    int val;
//    ListNode next,prev;
//    ListNode() {};
//    ListNode(int val){
//        this.val = val;
//    }
//}
//
//
//class MyLinkedList {
//
//    //记录链表中元素的数量
//    int size;
//    //记录链表的虚拟头结点和尾结点
//    ListNode head,tail;
//
//    public MyLinkedList() {
//        //初始化操作
//        this.size = 0;
//        this.head = new ListNode(0);
//        this.tail = new ListNode(0);
//        //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
//        head.next=tail;
//        tail.prev=head;
//    }
//
//    public int get(int index) {
//        //判断index是否有效
//        if(index<0 || index>=size){
//            return -1;
//        }
//        ListNode cur = this.head;
//        //判断是哪一边遍历时间更短
//        if(index >= size / 2){
//            //tail开始
//            cur = tail;
//            for(int i=0; i< size-index; i++){
//                cur = cur.prev;
//            }
//        }else{
//            for(int i=0; i<= index; i++){
//                cur = cur.next;
//            }
//        }
//        return cur.val;
//    }
//
//    public void addAtHead(int val) {
//        //等价于在第0个元素前添加
//        addAtIndex(0,val);
//    }
//
//    public void addAtTail(int val) {
//        //等价于在最后一个元素(null)前添加
//        addAtIndex(size,val);
//    }
//
//    public void addAtIndex(int index, int val) {
//        //index大于链表长度
//        if(index>size){
//            return;
//        }
//        //index小于0
//        if(index<0){
//            index = 0;
//        }
//        size++;
//        //找到前驱
//        ListNode pre = this.head;
//        for(int i=0; i<index; i++){
//            pre = pre.next;
//        }
//        //新建结点
//        ListNode newNode = new ListNode(val);
//        newNode.next = pre.next;
//        pre.next.prev = newNode;
//        newNode.prev = pre;
//        pre.next = newNode;
//
//    }
//
//    public void deleteAtIndex(int index) {
//        //判断索引是否有效
//        if(index<0 || index>=size){
//            return;
//        }
//        //删除操作
//        size--;
//        ListNode pre = this.head;
//        for(int i=0; i<index; i++){
//            pre = pre.next;
//        }
//        pre.next.next.prev = pre;
//        pre.next = pre.next.next;
//    }
//}
