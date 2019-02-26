
public class Node<T> {

	T data;
	Node<T> next;
	Node<T> prev;
	
	public Node(T dat) {
		data = dat;
		
	}
	

	public Node<T> reverse(Node<T> head){
		Node<T> back = head;
		while (back.next != null) {
			back = back.next;
		}
		Node<T> temp1 = back;
		Node<T> temp2 = back;
		while (temp1 != null) {
			temp2.next = new Node<T>(temp1.data);
			temp2.next.prev = temp2;
			temp2 = temp2.next;
			temp1 = temp1.prev;
			
		}
		temp2.next = temp1;
		Node<T> newhead = back.next;
		newhead.prev = null;
		return newhead;
 	}
	
	public Node<T> reverse2 (Node<T> head){
		  Node <T> curr = head;
		  while (curr != null){
		   curr = curr.next;
		   head.next = head.prev;
		   head.prev = curr;
		   if (curr != null){
		   head = curr;
		   }
		  }
		  return head;
		 }
	
	
	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		
		n1.next = n2;
		n2.prev = n1;
		
		n2.next = n3;
		n3.prev = n2;
		
		n3.next = n4;
		n4.prev = n3;
		
		n4.next = n5;
		n5.prev = n4;
		
		Node<Integer> a = n1.reverse2(n1);
		System.out.println(a.prev);
		
		
		System.out.println(a.data);
		System.out.println(a.next.data);
		System.out.println(a.next.next.data);
		System.out.println(a.next.next.next.data);
		System.out.println(a.next.next.next.next.data);
		
		//System.out.println(a.data);
		System.out.println(a.next.prev.data);
		System.out.println(a.next.next.prev.data);
		System.out.println(a.next.next.next.prev.data);
		System.out.println(a.next.next.next.next.prev.data);
		System.out.println(a.next.next.next.next.data);
	}

}
