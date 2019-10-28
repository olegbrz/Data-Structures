/*
 * Implementation of Doubly Linked List (DDL) on Java
 * 
 * Oleg Brezitskyy
 * Data Structures and Algorithms
 * 2º Ingeniería de la Salud
 * Universidad de Málaga
 * 
 */

package list;

public class DDL<E> implements List<E> {

	private Node<E> head;
	private Node<E> curr;
	private Node<E> tail;
	private int listSize;
	
	@Override
	public void clear() {
		curr = tail = head = new Node<E>();
		head.setNext(tail);
		tail.setPrev(head);
		listSize = 0;
		
	}

	@Override
	public boolean insert(E item) {
		Node<E> p = curr.getNext();
		Node<E> aux = new Node<E>(curr.getItem(), curr, p);
		curr.setItem(item);
		curr.setNext(aux);
		p.setPrev(aux);
		if (tail == curr) {
			tail = curr.getNext();
		}
		listSize++;
		return true;
	}

	@Override
	public boolean append(E item) {
		Node<E> aux = tail.setNext(new Node<E>(tail, null));
		aux.setItem(item);
		tail = aux.getNext();
		listSize++;
		return true;
	}

	@Override
	public E remove() {
		if (curr == tail) {
			return null;
		}
		E item = curr.getItem();
		
		curr.setItem(curr.getNext().getItem());
		if (curr.getNext() == tail) {
			tail = curr;
		}
		curr.setNext(curr.getNext().getNext());
		listSize--;
		return item;
	}

	@Override
	public void moveToStart() {
		curr = head.getNext();
		
	}

	@Override
	public void moveToEnd() {
		curr = tail;
		
	}

	@Override
	public void prev() {
		if (curr != head) {
			curr = curr.getPrev();
		}
	}

	@Override
	public void next() {
		if (curr != tail) {
			curr = curr.getNext();
		}
		
	}

	@Override
	public int length() {
		return listSize;
	}

	@Override
	public int currPos() {
		Node<E> aux = head.getNext();
		int i = 0;
			for (i = 0; aux != curr; i++) {
				aux = aux.getNext();
			}
		return i;
	}

	@Override
	public boolean moveToPos(int pos) {
		if (pos < 0 || pos > listSize) {
			return false;
		}
		
		curr = head.getNext();
		for(int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		return true;
	}

	@Override
	public E getValue() {
		return curr.getItem();
	}

	@Override
	public boolean isAtEnd() {
		return (curr == tail);
	}

	@Override
	public boolean isEmpty() {
		return (listSize == 0);
	}
	
	@Override
	public String toString() {
		String list = new String();
		Node<E> aux = head.getNext();
		for(int i= 0; i < listSize; i++) {
			list = list + aux.getItem();
			aux = aux.getNext();
		}
		return list;
	}

}
