public class BST<T extends Comparable <T>> {

	public BinNode<T> root;
	
	public BST() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		return !(root != null);
	}
	
	
	public void add(T data) {
		BinNode<T> temp = new BinNode<T>(data);
		if (isEmpty()) {
			root = temp;
		}
		else if (root != null) {
			addHelp(data, root);
		}
	}
	
	private void addHelp(T data, BinNode<T> above) {
		if (above.left != null && (data.compareTo(above.data) == -1 || data.compareTo(above.data) == 0)){
			addHelp(data, above.left);
		}
		else if (above.right != null && data.compareTo(above.data) == 1){
			addHelp(data, above.right);
		}
		else if ((above.left == null) && (data.compareTo(above.data) == -1 || data.compareTo(above.data) == 0)){
			above.left = new BinNode<T>(data);
		}
		else if ((above.right == null) && data.compareTo(above.data) == 1){
			above.right = new BinNode<T>(data);
		}
	}
	
	public DList<T> inOrder() {
		DList<T> l = new DList<T>();
		l = inOrderHelp(root, l);
		return l;
	}
	
	private DList<T> inOrderHelp(BinNode<T> bin, DList<T> l) {
		if (bin != null) {
			inOrderHelp(bin.left, l);
			l.addEnd(bin.data);
			inOrderHelp(bin.right, l);
		}
		return l;
	}
	
	public DList<T> preOrder() {
		DList<T> l = new DList<T>();
		l = preOrderHelp(root, l);
		return l;
	}
	
	private DList<T> preOrderHelp(BinNode<T> bin, DList<T> l) {
		if (bin != null) {
			l.addEnd(bin.data);
			preOrderHelp(bin.left, l);
			preOrderHelp(bin.right, l);
		}
		return l;
	}
	
	public DList<T> postOrder() {
		DList<T> l = new DList<T>();
		l = postOrderHelp(root, l);
		return l;
	}
	
	private DList<T> postOrderHelp(BinNode<T> bin, DList<T> l) {
		if (bin != null) {
			postOrderHelp(bin.left, l);
			postOrderHelp(bin.right, l);
			l.addEnd(bin.data);
		}
		return l;
	}
	
	public void remove(T data) {
		BinNode<T> t = new BinNode<T>(null);
		t.right = root;
		t.left = null;
		removeHelp(data, t, root);
	}
	
	private BinNode<T> minSub(BinNode<T> node) {
		BinNode<T> t2 = node.left;
		while (t2.right != null) {
			t2 = t2.right;
		}
		return t2;
	}
	private BinNode<T> minSubParent(BinNode<T> node) {
		BinNode<T> t1 = node;
		BinNode<T> t2 = node.left;
		while (t2.right != null) {
			t1 = t2;
			t2 = t2.right;
		}
		return t1;
	}
	
	private void removeHelp(T data, BinNode<T> parent, BinNode<T> child) {
		if (child != null) {
		removeHelp(data, child, child.left);
		removeHelp(data, child, child.right);
			
		int numC;
		
		boolean isLeft = false;
		if (parent.left == child) {
			isLeft = true;
		}
		
		if (child.left == null && child.right == null) {
			numC = 0;
		}
		else if (child.left == null) {
			numC = 1;
		}
		else if (child.right == null) {
			numC = -1;
		}
		else {
			numC = 2;
		}
		
		if (data.compareTo(child.data) == 0) {
			if (isLeft) {
				if (numC == 0) {
					parent.left = null;
				}
				else if (numC == -1) {
					parent.left = child.left;
				}
				else if (numC == 1) {
					parent.left = child.right;
				}
				else {
					BinNode<T> t1 = child;
					BinNode<T> t2 = child.left;
					while (t2.right != null) {
						t1 = t2;
						t2 = t2.right;
					}
					if (t2 == child.left) {
						child.data = child.left.data;
						child.left = child.left.left;						
					}
					else {
						t1.right = t2.left;
						child.data = t2.data;
					}
				}
			}
			else {
				if (numC == 0) {
					parent.right = null;
				}
				else if (numC == -1) {
					parent.right = child.left;
				}
				else if (numC == 1) {
					parent.right = child.right;
				}
				else {
					BinNode<T> t1 = child;
					BinNode<T> t2 = child.left;
					while (t2.right != null) {
						t1 = t2;
						t2 = t2.right;
					}
					if (t2 == child.left) {
						child.data = child.left.data;
						child.left = child.left.left;						
					}
					else {
						t1.right = t2.left;
					 	child.data = t2.data;
					}
				}
			}
		}
		}
	}
	
	/* this is here for posterity in case i ever feel like figuring out what was wrong with this code
	 * i got to somehow make only one addition in the diff check and i don't know why there was still an exception in the rules
	 * of the removal
	private void removeHelp(T data, BinNode<T> above) {
		if (above != null) {
			removeHelp(data, above.left);
			removeHelp(data, above.right);
			if (above.left != null && above.left.data.compareTo(data)==0) {
				BinNode<T> t1 = null;
				BinNode<T> t2 = null;
				if (above.left.left != null) {
					t1 = above.left;
					t2 = above.left.left;
					while (t2.right != null) {
						t1 = t2;
						t2 = t2.right;
					}
					if (above.left.left.right == null) {
						above.left.data = t2.data;
						above.left.left = above.left.left.left;
					}
					else {
						above.left.data = t2.data;
						t1.right = null;
					}
				}
				else if (above.left.right != null) {
					BinNode<T> temp = above.left.right;
					above.left = temp;
				}
				else {
					above.left = null;
				}
			}
			if (above.right != null && above.right.data.compareTo(data)==0) {
				BinNode<T> t1 = null;
				BinNode<T> t2 = null;
				if (above.right.left != null) {
					t1 = above.right;
					t2 = above.right.left;
					while (t2.right != null) {
						t1 = t2;
						t2 = t2.right;
					}
					if (above.right.left.right == null) {
						above.right.data = t2.data;
						above.right.left = above.right.left.left;
					}
					else {
						above.right.data = t2.data;
						t1.right = null;
					}
				}
				else if (above.right.right != null) {
					BinNode<T> temp = above.right.right;
					above.right = temp;
				}
				else {
					above.right = null;
				}
			}
		}
	}*/
}
