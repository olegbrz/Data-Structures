package tree;

public interface BinaryTree<E> {
	
	/** Test for emptiness. */
	public boolean isEmpty();
	
	/** Retrieves the element at the root. */
	public E root();
	
	/** Retrieves the left subtree. */
	public BinaryTree<E> left();
	
	/** Retrieves the right subtree. */
	public BinaryTree<E> right();
}