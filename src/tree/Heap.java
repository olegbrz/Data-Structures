package tree;

public interface Heap <E extends Comparable <? super E>> {
	
	/** Checks whether the heap is empty or not */
	public boolean isEmpty();
	
	/** returns the number or elements in the heap */
	public int size();
	
	/** inserts an element in the tree */
	public void insert(E it);
	
	/** removes an element from the tree */
	public E deleteMin();
}
