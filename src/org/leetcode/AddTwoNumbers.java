package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author yangxing
 * @date 2017-10-10
 */
public class AddTwoNumbers {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 实际执行方法
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 处理后的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = null;
        if (l1 == null && l2 == null) {
            return null;
        } else {
            if (l1 == null) {
                int val = l2.val;
                current = new ListNode(val);
                current.next = addTwoNumbers(null, l2.next);
            } else if (l2 == null) {
                int val = l1.val;
                if (val > 9) {
                    val = val % 10;
                    if (l1.next == null) {
                        l1.next = new ListNode(1);
                    } else {
                        l1.next.val++;
                    }
                }
                current = new ListNode(val);
                current.next = addTwoNumbers(l1.next, null);
            } else {
                int val = l1.val + l2.val;
                if (val > 9) {
                    val = val % 10;
                    if (l1.next == null) {
                        l1.next = new ListNode(1);
                    } else {
                        l1.next.val += 1;
                    }
                }
                current = new ListNode(val);
                current.next = addTwoNumbers(l1.next, l2.next);
            }
        }
        return current;
    }


    // 以下方法用于测试

    /**
     * 打印ListNode里的值
     *
     * @param listNode 待打印的ListNode
     * @return 迭代的返回值，为当前结点的值
     */
    private int printListNode(ListNode listNode) {
        if (listNode == null)
            throw new NullPointerException("ListNode not allow null");

        if (listNode.next != null) {
            System.out.print(printListNode(listNode.next) + "\t");
        }
        return listNode.val;
    }

    /**
     * 把数组转换成ListNode
     *
     * @param arr 包含一组数据的数组
     * @return 转换后的ListNode
     */
    private ListNode makeListNode(int[] arr) {
        ListNode listNode = null;
        if (arr == null || arr.length <= 0) {
            return null;
        } else {
            listNode = new ListNode(arr[0]);
            if (arr.length > 1) {
                ListNode current = listNode;

                for (int i = 1; i < arr.length; i++) {
                    current.next = new ListNode(arr[i]);
                    current = current.next;
                }
            }
            return listNode;
        }
    }

    @Test
    public void testPrintListNode() {
        ListNode l1 = makeListNode(new int[]{9, 9});
        ListNode l2 = makeListNode(new int[]{9});
        System.out.println(printListNode(addTwoNumbers(l1, l2)));
//        addTwoNumbers(l1, l2);
    }
}
