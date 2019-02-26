

public class linkedlist<T> {

/**
 * @author ashkanvafai
 * the linked list
 * @param <T> data type to hold in the list
 */
// make the linked list here, add the data to the nodes 
		private Node<T> head; //head of the list
		private int length; //length of the list
		
		/**
		 * constructor 
		 */
		public linkedlist()
		{
			head = null;
			length = 0;
		}
		
		/**
		 * method for adding nodes to list
		 * @param data
		 */
		public void add (T data)
		{				
			Node<T> n = new Node<T>();	
			n.setData(data);
			
			if( head == null ){
				head = n;
			}
			else {
				Node<T> lastnode = head;
			
				while (lastnode.getNext() != null)
				{
					lastnode = lastnode.getNext();
				}
				//find the last node, and set next to the node you want to add. then set the newly added node's next to null.
				lastnode.setNext(n);
			}	
			length++;
						
		}
		/**
		 * @return length of list
		 */
		public int getLength()
		{
			return length;
		}
		
		/**
		 * @param index
		 * @return data in the node
		 */
		public T getNodeData (int index) 
		
		{
			T c = null;
			Node<T> curr = head;
			int cnt= 0;
			
			while (curr != null && cnt < index)
			{
				curr = curr.getNext();
				cnt++;	
			}
			if (curr != null)
			{
				c = curr.getData(); 
			}
			
			if (length == 1)
			{
				c = head.getData();
			}
			
			return c;
			
		}
		/**
		 * removes node from list
		 * @param index
		 */
		public void removeNode(int index)
		{
			if (length == 1)
			{
				head = null;
			}
			
			else if (index == 0)
			{
				head = head.getNext();
			}
			else
			{
				int count = 1;
				Node<T> curr = head;
				if (length != 0 && curr.getNext() != null)
				{
					for (int i = 0; i< length; i++)
					{
						if (count == index)
						{
							curr.setNext(curr.getNext().getNext());
							//length--; //PROBLEM
							break;
						}
						curr = curr.getNext();
						count++;
					}
				}
			}
		}	
}


