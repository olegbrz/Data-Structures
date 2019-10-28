package tree;

public class DTree<E> implements BinaryTree<E> {

	protected static class Node<E> {
		E elem;
		Node<E> left;
		Node<E> right;
	}
	
	Node<E> root;
	
	/* Creates an empty tree */
	public DTree() {
		root = null;
	}
	
	/* Creates a tree given its root and the
	 * left and right subtrees
	 */
	public DTree(E it, DTree<E> TL, DTree<E> TR) {
		root = new Node<E>();
		root.elem = it;
		root.left = TL.root;
		root.right = TR.root;
	}
	
	public boolean search(DTree<E> T, E it) {
		if (T.isEmpty())
			return false;
		else
			return (T.root() == it) ||
					search(T.left(), it) ||
					search(T.right(), it);
	}
	
	public boolean allLower(E it, DTree<E> T) {
		return (
				T.isEmpty() ||
				((T.root() < it) &&
				allLower(it, T.left()) &&
				allLower(it, T.right()))
				);
	}
	
	private boolean allGreater(E root2, DTree<E> right) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isBsT(DTree<E> T) {
		return (
				T.isEmpty()) ||
				(allLower(T.root(), T.left()) ||
				allGreater(T.root(), T.right())) ||
				(isBsT(T.left()) &&
				 isBsT(T.right())
				);
	}
	
	public void insert ( E it ) {
	Node <E> newnode = new Node <E>();
	newnode.elem = it ;
	newnode.left = newnode.right = null;
	
	if ( root == null ) {
		root = newnode;
		}
	else {
		Node <E > aux = root, prev = null;
		
		while ( aux != null ) {
			prev = aux ;
			if (aux.elem.compareTo(it) < 0)
				aux = aux.right;
			else aux = aux.left;
		}
		
		if (prev.elem.compareTo(it) < 0)
			prev.right = newnode;
		else prev.left = newnode;
		}
	}


	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public E root() {
		return root.elem;
	}

	@Override
	public DTree<E> left() {
		DTree<E> T = new DTree<E>();
		T.root = this.root.left;
		return T;
	}

	@Override
	public DTree<E> right() {
		DTree<E> T = new DTree<E>();
		T.root = this.root.right;
		return T;
	}

}
