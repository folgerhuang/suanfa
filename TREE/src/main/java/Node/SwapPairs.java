package Node;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

/**
 * 24. 两两交换链表中的节点
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListNode head = new ListNode<>(scanner.next());
        ListNode head1 = head;
        while (!scanner.hasNext("end")) {
            head.next  = new ListNode<>(scanner.next());
            head = head.next;
        }
        scanner.close();

        System.out.println(solution(head1));
    }

    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = solution(next.next);
        next.next = head;

        return next;

    }

}
