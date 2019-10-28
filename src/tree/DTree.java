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
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E root() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinaryTree<E> left() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinaryTree<E> right() {
		// TODO Auto-generated method stub
		return null;
	}

}
