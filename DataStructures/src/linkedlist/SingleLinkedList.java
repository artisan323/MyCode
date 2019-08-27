package linkedlist;

public class SingleLinkedList{
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {this.val = val;}

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

class MyLinkedList {

    private ListNode head = null;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode mnode = head;
        int i = 0;
        while(mnode != null){
            if(i == index){
                return mnode.val;
            }
            mnode = mnode.next;
            i++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head = newHead;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode mnode = head;
        while(mnode.next != null){
            mnode = mnode.next;
        }
        ListNode node = new ListNode(val);
        mnode.next = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode mnode = head;
        int i = 1;
        while(mnode != null){
            if(i == index){
                ListNode node = new ListNode(val);
                node.next = mnode.next;
                mnode.next = node;
            }
            mnode = mnode.next;
            i++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode mnode = head;
        int i = 1;
        while(mnode != null){
            if(i == index){
                mnode.next = mnode.next.next;
            }
            mnode = mnode.next;
            i++;
        }
    }
}