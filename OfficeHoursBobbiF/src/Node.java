
/**
 * @author ashkanvafai
 * Creates the nodes for the linked list
 * @param <T> data type of data held by nodes
 */
public class Node<T> {
	private T data; //data assigned to the node
	private Node<T> next; //the next node

	
	/**
	 * Gets the node's data
	 * @return the data
	 */
	public T getData() {
		return data; 
	}	
	
	/**
	 * Get the next node
	 * @return next node
	 */
	public Node<T> getNext(){
		return next;
	}
	
	/**
	 * sets the node's data
	 */
	public void setData (T Data){
		this.data = Data; 
	
	}
	
	/**
	 * set a node as another node's next node
	 */
	public void setNext (Node <T> Next){
		this.next = Next;
	}
	
		
	
	
	
}