package tree;

public class DTree<E> implements BinaryTree<E> {

	protected static class Node<E> {
		E elem;
		Node<E> left;
		Node<E> right;
	}
	
	Node<E> root;
	
	public DTree() {
		root = null;
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
