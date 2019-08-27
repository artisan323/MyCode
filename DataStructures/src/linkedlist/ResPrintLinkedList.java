package linkedlist;


import java.util.Stack;

public class ResPrintLinkedList {

    public static void main(String[] args) {


        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;



        resPrint(listNode1);

    }

    public static void resPrint(ListNode head){
        if (head == null){
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop().toString());
        }

    }
}
