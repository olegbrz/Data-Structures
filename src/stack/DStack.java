package stack;

import list.Node;

public class DStack <E> implements Stack <E> {
	private Node<E> head;
	private int cnt;
	
	/** Constructors */
	public DStack(){
		head = null ;
		cnt = 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean push(E it) {
		head = new Node<E>(it, head);
		cnt ++;
		return true ;

	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E topValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
