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
	
	/** returns the number of nodes in the tree */
	public int size(BinaryTree<E> T) {
		if (!T.isEmpty()) {
			return 1 + size(T.left()) + size(T.right());
		}
		else
			return 0;
	}
	
	/** returns the height of the tree */
	public int height(BinaryTree<E> T) {
		if (T.isEmpty()) {
			return 0;
		}
		else {
			int hleft = height(T.left());
			int hright = height(T.right());
			return Math.max(hleft, hright) + 1;
		}
	}
	
	/** checks whether the tree is perfect */
	public boolean perfect(BinaryTree<E> T) {
		
	}
	
	/** checks whether the tree is complete */
	public boolean complete(BinaryTree<E> T ) {
		
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
				((T.root().compareTo(it)) &&
				allLower(it, T.left()) &&
				allLower(it, T.right()))
				);
	}
	
	private boolean allGreater(E it, DTree<E> T) {
		return (
				T.isEmpty() ||
				((T.root().compareTo(it)) &&
				allGreater(it, T.left()) &&
				allGreater(it, T.right()))
				);
	}
	
	public boolean isBST(DTree<E> T) {
		return (
				T.isEmpty()) ||
				(allLower(T.root(), T.left()) ||
				allGreater(T.root(), T.right())) ||
				(isBST(T.left()) &&
				 isBST(T.right())
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
	
	public void delete (E it) {
	Node<E> aux = root, ant = null;
	boolean found = false;
	while (!found && ( aux != null )) {
		int cmp = aux.elem.compareTo(it);
		if ( cmp == 0)
			found = true ;
		else {
			ant = aux ;
			if (cmp < 0) aux = aux.right ;
			else aux = aux.left ; 
			}
		}
	
	if (found) {
		if (ant == null) root = deleteAux(aux);
		else if (ant.elem.compareTo(it) <0)
			ant.right = deleteAux(aux);
		else ant.left = deleteAux(aux);
		}
	}
	
	protected Node<E> deleteAux(Node<E> aux) {
		if (aux.right == null) return aux.left;
		else if (aux.left == null) return aux.right;
		else {
			Node <E > maxmin = aux.left, prev = aux ;
			while (maxmin.right != null) {
				prev = maxmin;
				maxmin = maxmin.right;
			}
			aux.elem = maxmin.elem ;
			if (prev == aux) aux.left = deleteAux(maxmin);
			else prev.right = deleteAux(maxmin);
			return aux;
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
