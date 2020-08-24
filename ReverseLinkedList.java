/**
 * 
	Reverse a singly linked list.
	
	Example:
	
	Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL
	Follow up:
	
	A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @author Arundathi Patil
 *
 */
public class ReverseLinkedList {
	
	public static ListNode reverseList(ListNode head) {
		
		if(head.next !=null) {
			ListNode node = reverseList(head.next);
			(head.next).next = head;
			head.next = null;
			return node;
		} else {
			return head;
		}
		
	}
	
	public static void main(String[] args) {
		ListNode n5 = new ListNode(5, null);
		ListNode n4 = new ListNode(4, n5);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);
		n1 = ReverseLinkedList.reverseList(n1);
		System.out.println("n1.next:" + n1.next +", n1.val:" + n1.val);
	}

}

/*Definition for singly-linked list.*/
class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
