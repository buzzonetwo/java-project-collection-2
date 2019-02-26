
public class BinNode<T extends Comparable<T>> {

	public T data;
	public BinNode<T> left;
	public BinNode<T> right;
	
	public BinNode(T dat) {
		data = dat;
	}

}
